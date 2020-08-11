import java.io.*;
import java.util.*;
/**
 * Name: SolarSystem
 * Purpose: To hold the data regarding gravitational bodies in the solar system
 * and then use them to simulate the solar system.
 *
 * @author Harry Baker
 * @version 3.2
 * Date: 11.12.2017
 *
 */
public class SolarSystem
  {
  private ArrayList<GravBody> sol = new ArrayList<GravBody>();
  // ArrayList of GravBodys that will represent the solar system
  private double iTotE;
  // Intial total mechanical energy of the system
  private PhysicsVector iTotL;
  // Intial total angular momentum of the system
  private double totKE;
  // Total kinetic energy of the system
  private double totGPE;
  // Total gravitational potential energy of the system
  private double totE;
  // Total mechanical energy of the system
  private PhysicsVector totL;
  // Total angular momentum of the system
  private double diffE;
  // Difference between intial and final mechanical energies
  private PhysicsVector diffL;
  // Difference between intial and final angular momenta

  /**
   * Default constructor of SolarSystem. Creates 24 bodies: The Sun, the 8
   * planets, the moons of Earth and Mars, the Galilean Moons, Titan, Enceladus,
   * Mimas, Pluto, Charon, Ceres and Eris. By using ArrayList, this can be added
   * to at a later time.
   *
   * For clarity, the components of the GravBodys are first defined using the
   * form:
   * nameM = mass of body
   * nameR = radius of body
   * namer = position of body
   * namev = velocity of body
   *
   * The GravBody is then created and then added to sol. Additionally, moons are
   * indented below their parent body
   *
   * Initial data from JPL at an epoch of 00:00 22nd November 2017 
   *
   */
  public SolarSystem()
    {
      double sunM = 1.988544e30;
      double sunR = 6.955e8;
      PhysicsVector sunr = new PhysicsVector(3.037212274223160e8,8.862329146259788e8,-1.880286442834383e7);
      PhysicsVector sunv = new PhysicsVector(-9.571616640254677,9.156225023046215,2.288491358574066e-1);
      GravBody sun = new GravBody("Sun",sunr,sunv,sunM,sunR);
      sol.add(sun);

      double mercuryM = 3.302e23;
      double mercuryR = 2.440e6;
      PhysicsVector mercuryr = new PhysicsVector(5.124528152795412e10,-2.816573796001798e10,-7.066094743068278e9);
      PhysicsVector mercuryv = new PhysicsVector(1.457351437134092e4,4.455170504270037e4,2.302082710197132e3);
      GravBody mercury = new GravBody("Mercury",mercuryr,mercuryv,mercuryM,mercuryR);
      sol.add(mercury);

      double venusM = 4.8685e24;
      double venusR = 6.0518e6;
      PhysicsVector venusr = new PhysicsVector(-9.135549180797623e10,-5.621099774744527e10,4.487298665212650e9);
      PhysicsVector venusv = new PhysicsVector(1.826072013601489e4,-2.988023517615618e4,-1.464084028219821e3);
      GravBody venus = new GravBody("Venus",venusr,venusv,venusM,venusR);
      sol.add(venus);

      double earthM = 5.97219e24;
      double earthR = 6.37101e6;
      PhysicsVector earthr = new PhysicsVector(7.501287427913301e10,1.283726937476953e11,-2.475287725434452e7);
      PhysicsVector earthv = new PhysicsVector(-2.620638529263413e4,1.495838049550632e4,5.006214358482808e-1);
      GravBody earth = new GravBody("Earth",earthr,earthv,earthM,earthR);
      sol.add(earth);

        double moonM = 7.349e22;
        double moonR = 1.7374e6;
        PhysicsVector moonr = new PhysicsVector(7.506927599115247e10,1.279711708355045e11,-1.851214902363718e6);
        PhysicsVector moonv = new PhysicsVector(-2.524941108572238e4,1.509134602383103e4,-6.463578190401265e1);
        GravBody moon = new GravBody("Moon",moonr,moonv,moonM,moonR);
        sol.add(moon);

      double marsM = 6.4185e23;
      double marsR = 3.3899e6;
      PhysicsVector marsr = new PhysicsVector(-2.467157778178580e11,1.863876076180318e10,6.415514654488299e9);
      PhysicsVector marsv = new PhysicsVector(-8.412871770166096e2,-2.208780363623634e4,-4.424077352639184e2);
      GravBody mars = new GravBody("Mars",marsr,marsv,marsM,marsR);
      sol.add(mars);

        double phobosM = 1.08e20;
        double phobosR = 11.1e3;
        PhysicsVector phobosr = new PhysicsVector(-2.467126859577897e11,1.863010144930422e10,6.413578950952418e9);
        PhysicsVector phobosv = new PhysicsVector(9.403201400439650e2,-2.123678478281269e4,-1.249161043167853e3);
        GravBody phobos = new GravBody("Phobos",phobosr,phobosv,phobosM,phobosR);
        sol.add(phobos);

        double deimosM = 1.80e20;
        double deimosR = 6.0e3;
        PhysicsVector deimosr = new PhysicsVector(-2.466974134336410e11,1.862774548288341e10,6.405944318054851e9);
        PhysicsVector deimosv = new PhysicsVector(-2.220823816089462e2,-2.089998709050713e4,-6.207243811020025e2);
        GravBody deimos = new GravBody("Deimos",deimosr,deimosv,deimosM,deimosR);
        sol.add(deimos);

      double ceresM = 9.393e20;
      double ceresR = 4.73e5;
      PhysicsVector ceresr = new PhysicsVector(-1.574995427383465e11,3.538539535348019e11,4.018538755132540e10);
      PhysicsVector ceresv = new PhysicsVector(-1.669526216831862e4,-8.706833645289297e3,2.801959916082300e3);
      GravBody ceres = new GravBody("Ceres",ceresr,ceresv,ceresM,ceresR);
      sol.add(ceres);

      double jupiterM = 1.89813e27;
      double jupiterR = 7.1492e7;
      PhysicsVector jupiterr = new PhysicsVector(-6.636945443664249e11,-4.688000073630689e11,1.678946364461195e10);
      PhysicsVector jupiterv = new PhysicsVector(7.382905974777615e3,-1.005126172044950e4,-1.234858916335728e2);
      GravBody jupiter = new GravBody("Jupiter",jupiterr,jupiterv,jupiterM,jupiterR);
      sol.add(jupiter);

        double ganymedeM = 1.482e23;
        double ganymedeR = 2.634e6;
        PhysicsVector ganymeder = new PhysicsVector(-6.626868333608372e11,-4.691555619369162e11,1.678938327727523e10);
        PhysicsVector ganymedev = new PhysicsVector(1.102082480304983e4,2.129838577887176e2,3.129847940155884e2);
        GravBody ganymede = new GravBody("Ganymede",ganymeder,ganymedev,ganymedeM,ganymedeR);
        sol.add(ganymede);

        double ioM = 8.933e22;
        double ioR = 1.8213e6;
        PhysicsVector ior = new PhysicsVector(-6.639256292557373e11,-4.691504959240770e11,1.677368003879449e10);
        PhysicsVector iov = new PhysicsVector(2.192966692196031e4,-1.960790943940037e4,-2.600626092271563e2);
        GravBody io = new GravBody("Io",ior,iov,ioM,ioR);
        sol.add(io);

        double callistoM = 1.076e23;
        double callistoR = 2.403e6;
        PhysicsVector callistor = new PhysicsVector(-6.635448776928874e11,-4.706760536129699e11,1.673208225101885e10);
        PhysicsVector callistov = new PhysicsVector(1.555628628885461e4,-9.342766260052205e3,8.103614659290326);
        GravBody callisto = new GravBody("Callisto",callistor,callistov,callistoM,callistoR);
        sol.add(callisto);

        double europaM = 4.797e22;
        double europaR = 1.565e6;
        PhysicsVector europar = new PhysicsVector(-6.639689776165701e11,-4.694184398562968e11,1.675773282562286e10);
        PhysicsVector europav = new PhysicsVector(1.982059958976745e4,-1.558883673748259e4,-1.308689330027217e2);
        GravBody europa = new GravBody("Europa",europar,europav,europaM,europaR);
        sol.add(europa);

      double saturnM = 5.68319e26;
      double saturnR = 6.0268e7;
      PhysicsVector saturnr = new PhysicsVector(-2.438354067953424e10,-1.504210077215750e12,2.712431114581323e10);
      PhysicsVector saturnv = new PhysicsVector(9.129037029617647e3,-1.881482875053840e2,-3.599100563570183e2);
      GravBody saturn = new GravBody("Saturn",saturnr,saturnv,saturnM,saturnR);
      sol.add(saturn);

        double mimasM = 3.75e19;
        double mimasR = 1.988e5;
        PhysicsVector mimasr = new PhysicsVector(-2.456045011360482e10,-1.504146752247578e12,2.710241105904508e10);
        PhysicsVector mimasv = new PhysicsVector(4.237187858340070e3,-1.165432945998352e4,6.096748518820496e3);
        GravBody mimas = new GravBody("Mimas",mimasr,mimasv,mimasM,mimasR);
        sol.add(mimas);

        double enceladusM = 1.0805e20;
        double enceladusR = 2.523e5;
        PhysicsVector enceladusr = new PhysicsVector(-2.428753610481535e10,-1.504406052861081e12,2.721772939066273e10);
        PhysicsVector enceladusv = new PhysicsVector(2.064400798209600e4,3.948909063817100e3,-3.641858001115515e3);
        GravBody enceladus = new GravBody("Enceladus",enceladusr,enceladusv,enceladusM,enceladusR);
        sol.add(enceladus);

        double titanM = 1.34553e23;
        double titanR = 2.5755e6;
        PhysicsVector titanr = new PhysicsVector(-2.398466886715624e10,-1.503202800022186e12,2.656555010073549e10);
        PhysicsVector titanv = new PhysicsVector(3.927994719952334e3,1.786267978848334e3,-8.610707770918455e2);
        GravBody titan = new GravBody("Titan",titanr,titanv,titanM,titanR);
        sol.add(titan);

      double uranusM = 8.68103e25;
      double uranusR = 2.5559e7;
      PhysicsVector uranusr = new PhysicsVector(2.662174078107345e12,1.335907966966883e12,-2.952732094763464e10);
      PhysicsVector uranusv = new PhysicsVector(-3.104513105985848e3,5.769268436016593e3,6.182620011400930e1);
      GravBody uranus = new GravBody("Uranus",uranusr,uranusv,uranusM,uranusR);
      sol.add(uranus);

      double neptuneM = 1.0241e26;
      double neptuneR = 2.4766e7;
      PhysicsVector neptuner = new PhysicsVector(4.285407176437102e12,-1.303388413465425e12,-7.192076929110849e10);
      PhysicsVector neptunev = new PhysicsVector(1.545217201602197e3,5.231651559510536e3,-1.438763387012960e2);
      GravBody neptune = new GravBody("Neptune",neptuner,neptunev,neptuneM,neptuneR);
      sol.add(neptune);

        double tritonM = 2.147e22;
        double tritonR = 1.3526e6;
        PhysicsVector tritonr = new PhysicsVector(4.285111476896264e12,-1.303435436081140e12,-7.173049662451446e10);
        PhysicsVector tritonv = new PhysicsVector(2.559240982910577e3,8.736003397438425e3,2.297994855997914e3);
        GravBody triton = new GravBody("Triton",tritonr,tritonv,tritonM,tritonR);
        sol.add(triton);

      double plutoM = 1.307e22;
      double plutoR = 1.195e6;
      PhysicsVector plutor = new PhysicsVector(1.594209706944101e12,-4.742305430790793e12,4.631703031101704e10);
      PhysicsVector plutov = new PhysicsVector(5.279648741331379e3,5.941916038440797e2,-1.608784248644031e3);
      GravBody pluto = new GravBody("Pluto",plutor,plutov,plutoM,plutoR);
      sol.add(pluto);

        double charonM = 1.53e21;
        double charonR = 6.05e5;
        PhysicsVector charonr = new PhysicsVector(1.594198790431995e12,-4.742320745351346e12,4.631151380044961e10);
        PhysicsVector charonv = new PhysicsVector(5.172667474287958e3,5.999427527872327e2,-1.413101388777968e3);
        GravBody charon = new GravBody("Charon",charonr,charonv,charonM,charonR);
        sol.add(charon);

      double erisM = 1.66e22;
      double erisR = 1.163e6;
      PhysicsVector erisr = new PhysicsVector(1.293707250141005e13,5.514200878492332e12,-3.029116862064204e12);
      PhysicsVector erisv = new PhysicsVector(-6.676818640765134e2,1.550792634895299e3,1.590308195948496e3);
      GravBody eris = new GravBody("Eris",erisr,erisv,erisM,erisR);
      sol.add(eris);

      double halleyM = 2.2e14;
      double halleyR = 11e3;
      PhysicsVector halleyr = new PhysicsVector(-3.057184660162650e12,3.903328085224600e12,-1.484351640515568e12);
      PhysicsVector halleyv = new PhysicsVector(1.844155748665115e2,1.253575465688417e3,-1.572230537486558e2);
      GravBody halley = new GravBody("Halley's Comet",halleyr,halleyv,halleyM,halleyR);
      sol.add(halley);

      double voyager1M = 825.5;
      double voyager1R = 5;
      PhysicsVector voyager1r = new PhysicsVector(-4.234407023202105e12,-1.665900341852535e13,1.205651949704697e13);
      PhysicsVector voyager1v = new PhysicsVector(-2.073827946383681e3,-1.366170469472560e4,9.870813406585764e3);
      GravBody voyager1 = new GravBody("Voyager 1",voyager1r,voyager1v,voyager1M,voyager1R);
      sol.add(voyager1);

      double voyager2M = 825.5;
      double voyager2R = 5;
      PhysicsVector voyager2r = new PhysicsVector(4.785875244039839e12,-1.315899033756657e13,-1.024863338245244e13);
      PhysicsVector voyager2v = new PhysicsVector(4.241858018825248e3,-9.410116085444109e3,-1.137713856656307e4);
      GravBody voyager2 = new GravBody("Voyager 2",voyager2r,voyager2v,voyager2M,voyager2R);
      sol.add(voyager2);

      iTotE = 0;
      iTotL = new PhysicsVector();
      totKE = 0;
      totGPE = 0;
      totE = totKE + totGPE;
      totL= new PhysicsVector();
      diffE = 0;
      diffL = new PhysicsVector();
    }

  /**
   * Prints the characteristics of all the bodies in the system
   *
   */
  public void printSystemChar()
    {
      for(int i=0; i<sol.size(); i++)
        {
          sol.get(i).printBodyChar();
        }
    }

  /**
   * Prints the positions and velocities of all the bodies in the system
   *
   */
  public void printSystem()
    {
      for(int i=0; i<sol.size(); i++)
        {
          sol.get(i).printBody();
        }
    }

  /**
   * Prints the names of all the bodies in the system
   *
   */
  public void printSystemBodyNames()
    {
      for(int i=0; i<sol.size(); i++)
        {
          System.out.println(sol.get(i).getName());
        }
    }

  /**
   * Prints the energy and angular momentum of the system
   */
  public void printEnergyAndL()
    {
      calcTotKE();
      calcTotGPE();
      calcTotEnergy();
      calcTotAngularMomentum();
      System.out.println("Total KE: " + totKE + " J");
      System.out.println("Total GPE: " + totGPE + " J");
      System.out.println("Total Energy: " + totE + " J");
      System.out.println("Total Angular Momentum: " + totL.magnitude() + " kgm^2/s");
    }

  /**
   * Prints the conservation of mechanical energy and angular momentum of the
   * system.
   *
   */
  public void printConservation()
    {
      System.out.println("Difference in intial and final energy:");
      System.out.println(diffE + " J");
      System.out.println("\n" + "Difference in intial and final angular momentum:");
      System.out.println(diffL.magnitude() + " kgm^2/s");
    }

  /**
   * Adds a body to the system
   *
   * @param p Body to be added
   *
   */
  public void addBody(GravBody p)
    {
      sol.add(p);
    }

  /**
   * Runs the Euler algorithm on the entire system by a time-step for a duration.
   * It also calculates intial and final mechanical energy for every iteration
   * and formats them as strings to be printed to output files.
   *
   * @param t Time-step of each iteration
   * @param d Duration of the simulation
   * @param filename Name of the output files
   * @param f Number of outputs to file
   *
   * @throws IOException Throws exception if a problem occurs writing to a file
   *
   */
  public void runEular(double t, double d, int f, String filename)
  throws IOException
    {
      double tott = 0; // Total time elasped
      int iNum = 0; // Iteration number
      String conservationEData = "";
      // String to hold the conservation of mechanical energy for the system
      // every iteration
      String conservationLData = "";
      // String to hold the conservation of angular momentum for the system
      // every iteration

      // First calculates the intial energy, angular momentum to use later
      calcIntialEL();

      do{
        iNum++; // Increases iteration number every iteration

        // Calculates the accelerations of all the bodies in the system
        calcTotSystemAcc(sol);

        // Moves all the bodies by the Euler algorithm
        for(int i=0; i<sol.size(); i++)
          {
            sol.get(i).euler(t);

            // If the user wanted an output file, the x and y positions for
            // each body is added to a string at intervals defined by the user
            if(! filename.equals("nooutput")&&(iNum % f == 0))
              {
                sol.get(i).setPositionData();
              }
          }

        // Calculates the final energy and angular momentum of the system and
        // the difference between the intial and final values
        calcConservation();

        // Adds the conservation of energy and angular momentum to the
        // appropiate string and the adds a new line to the position data
        // string at every requested interval if the user decided to output
        if(! filename.equals("nooutput")&&(iNum % f == 0))
          {
            conservationEData += iNum + "\t" + diffE + "\n";
            conservationLData += iNum + "\t" + diffL.magnitude() + "\n";
          }

          tott += t; // Increases the time elasped by the time-step

      }while(tott<=d);
      // Runs for the duration specified

      // If the user chose to output data, the collected data from the
      // simulation is sent to the appropiate files in intervals defined by
      // the user
      if(! filename.equals("nooutput"))
        {
          dataOutput(conservationEData,filename + "_Energy");
          dataOutput(conservationLData,filename + "_L");
        }
      for(int i=0; i<sol.size(); i++)
        {
          dataOutput(sol.get(i).getPositionData(),filename + "_"
          + sol.get(i).getName() + "_Position");
        }
    }

  /**
   * Runs the Euler-Cramer algorithm on the entire system by a time-step for a
   * duration. It also calculates intial and final mechanical energy for every
   * iteration and formats them as strings to be printed to output files.
   *
   * @param t Time-step of each iteration
   * @param d Duration of the simulation
   * @param filename name of the output files
   * @param f Number of outputs to file
   *
   * @throws IOException Throws exception if a problem occurs writing to a file
   *
   */
  public void runCramer(double t, double d, int f, String filename)
  throws IOException
    {
      double tott = 0; // Total time elasped
      int iNum = 0; // Iteration number

      // String to hold the x and y positions of each body, every iteration
      String conservationEData = "";
      // String to hold the conservation of mechanical energy for the system
      // every iteration
      String conservationLData = "";
      // String to hold the conservation of angular momentum for the system
      // every iteration

      // First calculates the intial energy and angular momentum of the system
      calcIntialEL();

      do{
        iNum++; // Increases iteration number every iteration

        // Calculates the accelerations of all the bodies in the system
        calcTotSystemAcc(sol);

        // Moves all the bodies by the Euler-Cramer
        for(int i=0; i<sol.size(); i++)
          {
            sol.get(i).eulerCramer(t);

            // If the user wanted an output file, the x and y positions for
            // each body is added to a string
            if(! filename.equals("nooutput")&&(iNum % f == 0))
              {
                sol.get(i).setPositionData();
              }
          }

        // Calculates the final energy and angular momentum of the system and
        // the difference between the intial and final values
        calcConservation();

        // Adds the conservation of energy and angular momentum to the
        // appropiate string, every iteration, and the adds a new line to the
        // position data string for each iteration
        if(! filename.equals("nooutput")&&(iNum % f == 0))
          {
            conservationEData += iNum + "\t" + diffE + "\n";
            conservationLData += iNum + "\t" + diffL.magnitude() + "\n";
          }

        tott += t; // Increases the time elasped by the time-step

      }while(tott<=d);
      // Runs for the duration specified

      // If the user chose to output data, the collected data from the
      // simulation is sent to the appropiate file
      if(! filename.equals("nooutput"))
        {
          dataOutput(conservationEData,filename + "_Energy");
          dataOutput(conservationLData,filename + "_L");
        }
      for(int i=0; i<sol.size(); i++)
        {
          dataOutput(sol.get(i).getPositionData(),filename + "_"
          + sol.get(i).getName() + "_Position");
        }
    }

  /**
   * Runs the Euler-Richardson algorithm on the entire system by a time-step for
   * a duration. It also calculates intial and final mechanical energy for every
   * iteration and formats them as strings to be printed to output files.
   *
   * @param t Time-step of each iteration
   * @param d Duration of the simulation
   * @param filename name of the output files
   * @param f Number of outputs to file
   *
   * @throws IOException Throws exception if a problem occurs writing to a file
   *
   */
  public void runRichardson(double t, double d, int f, String filename)
  throws IOException
    {
      double tott = 0; // Total time elasped
      int iNum = 0; // Iteration number

      // String to hold the x and y positions of each body, every iteration
      String conservationEData = "";
      // String to hold the conservation of mechanical energy for the system
      // every iteration
      String conservationLData = "";
      // String to hold the conservation of angular momentum for the system
      // every iteration

      // First calculates the intial energy and angular momentum of the system
      calcIntialEL();

      do{
        iNum++; // Increases iteration number every iteration

        // Calculates the accelerations of all the bodies in the system
        calcTotSystemAcc(sol);

        // Creates a copy of sol to calculate the acceleration at the midpoint
        // of the iteration
        ArrayList<GravBody> solmid = new ArrayList<GravBody>();

        // Copies each body from sol to solmid and moves them forward by 0.5t
        // using Euler
        for(int i=0; i<sol.size(); i++)
          {
            GravBody body = new GravBody(sol.get(i));
            solmid.add(i,body);
            solmid.get(i).euler(0.5*t);
          }

        // Calculates the acceleration of each body at the midpoint
        calcTotSystemAcc(solmid);

        // Uses the Euler-Cramer algorithm with the velocity and acceleration
        // from the mid-point of the iteration
        for(int i=0; i<sol.size(); i++)
          {
            sol.get(i).eulerRichardson(solmid.get(i),t);

            // If the user wanted an output file, the x and y positions for
            // each body is added to a string
            if(! filename.equals("nooutput")&&(iNum % f == 0))
              {
                sol.get(i).setPositionData();
              }
          }

          // Calculates the final energy and angular momentum of the system and
          // the difference between the intial and final values
          calcConservation();

          // Adds the conservation of energy and angular momentum to the
          // appropiate string, every iteration, and the adds a new line to the
          // position data string for each iteration
          if(! filename.equals("nooutput")&&(iNum % f == 0))
            {
              conservationEData += iNum + "\t" + diffE + "\n";
              conservationLData += iNum + "\t" + diffL.magnitude() + "\n";
            }

          tott += t; // Increases the time elasped by the time-step

        }while(tott<=d);
        // Runs for the duration specified

        // If the user chose to output data, the collected data from the
        // simulation is sent to the appropiate file
        if(! filename.equals("nooutput"))
          {
            dataOutput(conservationEData,filename + "_Energy");
            dataOutput(conservationLData,filename + "_L");
          }
        for(int i=0; i<sol.size(); i++)
          {
            dataOutput(sol.get(i).getPositionData(),filename + "_"
            + sol.get(i).getName() + "_Position");
          }
    }

  /**
   * Runs the Verlet algorithm on the entire system by a time-step for a duration.
   * It also calculates intial and final mechanical energy for every iteration
   * and formats them as strings to be printed to output files.
   *
   * @param t Time-step of each iteration
   * @param d Duration of the simulation
   * @param filename name of the output files
   * @param f Number of outputs to file
   *
   * @throws IOException Throws exception if a problem occurs writing to a file
   *
   */
  public void runVerlet(double t, double d, int f, String filename)
  throws IOException
    {
      double tott = 0; // Total time elasped
      int iNum = 0; // Iteration number

      // String to hold the x and y positions of each body, every iteration
      String conservationEData = "";
      // String to hold the conservation of mechanical energy for the system
      // every iteration
      String conservationLData = "";
      // String to hold the conservation of angular momentum for the system
      // every iteration

      // First calculates the intial energy and angular momentum of the system
      calcIntialEL();

      do{
        iNum++; // Increases iteration number every iteration

        // Calculates the acceleration of each body at the midpoint
        calcTotSystemAcc(sol);

        // Creates an array of PhysicsVectors to store the intial accelerations
        PhysicsVector[] intialTotA = new PhysicsVector[sol.size()];

        // Sets the entries of intialTotA to have the total accelerations for
        // each body of sol
        for(int i=0; i<sol.size(); i++)
          {
            intialTotA[i] = new PhysicsVector(sol.get(i).getTotAcc());
          }

        // Now each body gets moved forward by using the first half of the
        // Verlet algorithm
        for(int i=0; i<sol.size(); i++)
          {
            sol.get(i).verletPtOne(t);
          }

        // Now the acceleration of each body is calculated again but now at the
        // end of the time-step
        calcTotSystemAcc(sol);

        // The average acceleration is then calculated to find the velocities
        // of each body at the end of the time-step using the second half of the
        // Verlet algorithm
        for(int i=0; i<sol.size(); i++)
          {
            sol.get(i).verletPtTwo(intialTotA[i],t);

            // If the user wanted an output file, the x and y positions for
            // each body is added to a string
            if(! filename.equals("nooutput")&&(iNum % f == 0))
              {
                sol.get(i).setPositionData();
              }
          }

        // Calculates the final energy and angular momentum of the system and
        // the difference between the intial and final values
        calcConservation();

        // Adds the conservation of energy and angular momentum to the
        // appropiate string, every iteration, and the adds a new line to the
        // position data string for each iteration
        if(! filename.equals("nooutput")&&(iNum % f == 0))
          {
            conservationEData += iNum + "\t" + diffE + "\n";
            conservationLData += iNum + "\t" + diffL.magnitude() + "\n";
          }

        tott += t; // Increases the time elasped by the time-step
      }while(tott<=d);
      // Runs for the duration specified

      // If the user chose to output data, the collected data from the
      // simulation is sent to the appropiate file
      if(! filename.equals("nooutput"))
        {
          dataOutput(conservationEData,filename + "_Energy");
          dataOutput(conservationLData,filename + "_L");
        }
      for(int i=0; i<sol.size(); i++)
        {
          dataOutput(sol.get(i).getPositionData(),filename + "_"
          + sol.get(i).getName() + "_Position");
        }
    }

  /**
   * Runs the Beeman algorithm on the entire system by a time-step for a duration.
   * It also calculates intial and final mechanical energy for every iteration
   * and formats them as strings to be printed to output files.
   *
   * @param t Time-step of each iteration
   * @param d Duration of the simulation
   * @param filename name of the output files
   * @param f Number of outputs to file
   *
   * @throws IOException Throws exception if a problem occurs writing to a file
   *
   */
  public void runBeeman(double t, double d, int f, String filename)
  throws IOException
    {
      double tott = 0; // Total time elasped
      int iNum = 0; // Iteration number

      // String to hold the x and y positions of each body, every iteration
      String conservationEData = "";
      // String to hold the conservation of mechanical energy for the system
      // every iteration
      String conservationLData = "";
      // String to hold the conservation of angular momentum for the system
      // every iteration

      // First calculates the intial energy and angular momentum of the system
      calcIntialEL();

      // Creates two arrays of PhysicsVectors to hold the accelerations of each
      // body at the start of the last iteration (aBack) and at the start of
      // the current iteration.
      PhysicsVector[] aBack = new PhysicsVector[sol.size()];
      PhysicsVector[] aIntial = new PhysicsVector[sol.size()];

      // For the first iteration, the Beeman algorithm cannot be used as there
      // is no last iteration to use for the aBack
      if(iNum == 0)
        {
          // Calculates the acceleration of each body
          calcTotSystemAcc(sol);

          // aBack for the next iteration is set to be the current acceleration
          // of each body and aIntial is intialised for future use.
          for(int i=0; i<sol.size(); i++)
            {
              aBack[i] = new PhysicsVector(sol.get(i).getTotAcc());
              aIntial[i] = new PhysicsVector();
            }
        }

      // Begins the Beeman iterations
      do{
        iNum++; // Increases iteration number every iteration

        if(iNum == 1)
          {
            // For the first iteration, the system is moved using Euler-Cramer
            // as there is no aBack to use for Beeman
            for(int i=0; i<sol.size(); i++)
              {
                sol.get(i).eulerCramer(t);
              }
          }

        // For all other iterations, Beeman is used
        if(iNum > 1)
          {
            // Calculates the acceleration of each body
            calcTotSystemAcc(sol);

            // First sets the intial accelerations of each body to be stored
            for(int i=0; i<sol.size(); i++)
              {
                aIntial[i] = new PhysicsVector(sol.get(i).getTotAcc());
              }

            // Moves each sol body forward by a time-step using their accelerations
            // at the start of the iteration and the at the end from solback,
            // using the Beeman algorithm
            for(int i=0; i<sol.size(); i++)
              {
                sol.get(i).beemanPtOne(aBack[i],t);
              }

            // Accelerations at the end of the iteration are calculated to use
            // to calculate the end velocities
            calcTotSystemAcc(sol);

            // The end velocities are then calculated using the 2nd half of
            // Beeman and the accelerations of each body at the start of the
            // last iteration, the beginning of this one, and the end of the
            // current iteration.
            for(int i=0; i<sol.size(); i++)
              {
                sol.get(i).beemanPtTwo(aBack[i],aIntial[i],t);
                aBack[i].setVector(aIntial[i]);
              }
          }

        // If the user wanted an output file, the x and y positions for
        // each body is added to a string
        for(int i=0; i<sol.size(); i++)
          {
            if(! filename.equals("nooutput")&&(iNum % f == 0))
              {
                sol.get(i).setPositionData();
              }
          }

        // Calculates the final energy and angular momentum of the system and
        // the difference between the intial and final values
        calcConservation();

        // Adds the conservation of energy and angular momentum to the
        // appropiate string, every iteration, and the adds a new line to the
        // position data string for each iteration
        if(! filename.equals("nooutput")&&(iNum % f == 0))
          {
            conservationEData += iNum + "\t" + diffE + "\n";
            conservationLData += iNum + "\t" + diffL.magnitude() + "\n";
          }

        tott += t; // Increases the time elasped by the time-step
      }while(tott<=d);
      // Runs for the duration specified

      // If the user chose to output data, the collected data from the
      // simulation is sent to the appropiate file
      if(! filename.equals("nooutput"))
        {
          dataOutput(conservationEData,filename + "_Energy");
          dataOutput(conservationLData,filename + "_L");
        }
      for(int i=0; i<sol.size(); i++)
        {
          dataOutput(sol.get(i).getPositionData(),filename + "_"
          + sol.get(i).getName() + "_Position");
        }
    }

  /**
   * Outputs strings to be written to a file using the DataOutput class.
   *
   * @param data String to be outputted
   * @param filename Name of file to output to
   *
   * @throws IOException Throws exception if a problem occurs writing to a file
   *
   */
  public void dataOutput(String data, String filename) throws IOException
    {
      // Creates an instance of DataOutput to use to output data to a file
      DataOutput output = new DataOutput();
      DataOutput.dataToFile(data,filename + ".txt");
    }

  /**
   * Calculates the total kinetic energy of the system by calculating the
   * kinetic energy of each body and summing them up.
   *
   */
  public void calcTotKE()
    {
      // Sets totKE to 0 so that succsesive calculations do not accluminate
      // energy
      totKE = 0;
      for(int i=0; i<sol.size(); i++)
        {
          sol.get(i).setKE();
          totKE += sol.get(i).getKE();
        }
    }

  /**
   * Calculates the total gravitational potential energy of the system by
   * calculating the GPE of each body and summing them up.
   *
   */
  public void calcTotGPE()
    {
      // Sets totGPE to 0 so that succsesive calculations do not accluminate
      // energy
      totGPE = 0;
      for(int j=0; j<sol.size(); j++)
        {
          for(int i=0; i<sol.size(); i++)
            {
              // Makes sure that GPE is not counted more than once
              if(j<i)
                {
                  sol.get(j).setGPE(sol.get(i));
                  totGPE += sol.get(j).getGPE();
                }
            }
        }
    }

  /**
   * Calculates the total energy of the system by using the calcTotKE and
   * calcTotGPE methods.
   *
   */
  public void calcTotEnergy()
    {
      calcTotKE();
      calcTotGPE();
      totE = totKE + totGPE;
    }

  /**
   * Calculates the total angular momentum of the system by calculating the
   * angular momentum of each body and summing togther.
   *
   */
  public void calcTotAngularMomentum()
    {
      // Sets angular momentum to 0 so that succsesive calculations do not
      // accluminate angular momentum
      totL.setVector(0,0,0);

      for(int i=0; i<sol.size(); i++)
        {
          sol.get(i).setAngularMomentum();
          totL.increaseBy(sol.get(i).getAngularMomentum());
        }
    }

  /**
   * Calculates the intial energy and angular momentum of the system
   *
   */
  public void calcIntialEL()
    {
      calcTotEnergy();
      calcTotAngularMomentum();
      iTotE = totE;
      iTotL.setVector(totL);
    }

  /**
   * Calculates the conservation of mechanical energy and angular momentum of
   * the system
   *
   */
  public void calcConservation()
    {
      calcTotEnergy();
      calcTotAngularMomentum();
      diffE = totE - iTotE;
      diffL.setVector(PhysicsVector.subtract(totL,iTotL));
    }

  /**
   * Calculates the total acceleration of the system due to each of the bodies
   * gravitational fields. Each body has its acceleration due to each other
   * body's gravity, calculated and summed up to its total acceleration.
   *
   * @param bodyArray ArrayList of GravBodys to have their accelerations calculated
   *
   */
  public void calcTotSystemAcc(ArrayList<GravBody> bodyArray)
    {
      for(int j=0; j<bodyArray.size(); j++)
        {
          // Sets total acceleration to 0 so that succsesive calculations of
          // total acceleration do not accluminate
          bodyArray.get(j).setTotAcc(0,0,0);
          for(int i=0; i<bodyArray.size(); i++)
            {
              // Makes sure that acceleration due to gravity is not calculated
              // from the body itself
              if(j!=i)
                {
                  bodyArray.get(j).calcTotBodyAcc(bodyArray.get(i));
                }
            }
        }
    }

  /**
   * Returns the magnitude of the total angular momentum of the system
   *
   * @return Returns the magnitude of the total angular momentum of the system
   *
   */
  public double getTotLMag()
    {
      return totL.magnitude();
    }

  /**
   * Returns the total kinetic energy of the system
   *
   * @return Returns the total kinetic energy of the system
   *
   */
  public double getTotKE()
    {
      return totKE;
    }

  /**
   * Returns the total gravitational potential energy of the system
   *
   * @return Returns the total gravitational potential energy of the system
   *
   */
  public double getTotGPE()
    {
      return totGPE;
    }

  /**
   * Returns the total mechanical energy of the system
   *
   * @return Returns the total mechanical energy of the system
   *
   */
  public double getTotE()
    {
      return totE;
    }

  /**
   * Returns the magnitude of the difference between the initial and final
   * angular momentum of the system.
   *
   * @return Returns magnitude of diffL
   *
   */
  public double getDiffLMag()
    {
      return diffL.magnitude();
    }

  /**
   * Returns the difference between the initial and final mechanical energy of
   * the System
   *
   * @return Returns diffE
   *
   */
  public double getDiffE()
    {
      return diffE;
    }
  }
