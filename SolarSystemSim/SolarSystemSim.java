import java.util.Scanner;
import java.util.*;
import java.io.*;
/**
 * Name: Solar System Simulator
 * Purpose: Driver to simulate the solar system in a user defined way
 *
 * @author Harry Baker
 * @version 5.3
 * Date: 12.12.2017
 *
 */
public class SolarSystemSim
  {
    private static Scanner scanner = new Scanner(System.in);
    // To scan in user inputs

  /**
   * Gives the user the option to print the intial characteristics of the Solar
   * System by entering in a string.
   *
   * @param s Model of the Solar System
   *
   */
  public static void printIntialSystem(SolarSystem s)
    {
      String choice; //String to be used to determine the user's choice

      do{
        System.out.println("\n" + "Print Solar System Intial Data? (Y/N)");
        choice = scanner.next(); // Scans in user's choice

        if(choice.equals("Y"))
          {
            // Prints out the solar system if the user inputted Y
            System.out.println("\n" + "Printing Solar System... " + "\n");
            s.printSystemChar();
          }
        if((! choice.equals("Y"))&&(! choice.equals("N")))
          {
              // Informs the user to re-enter their choice if they did not intput
              // Y or N
              System.out.println("\n" + "Input does not match menu options");
              System.out.println("Please re-enter" + "\n");
          }
      }while((! choice.equals("Y"))&&(! choice.equals("N")));
      // Loop will keep running till the user enters a valid option

      return;
    }

  /**
   * Gives the user the choice to print the final positions and velocities of
   * the bodies in the simulation
   *
   * @param s Model of the Solar System
   *
   */
  public static void printFinalSystem(SolarSystem s)
    {
      String choice; //String to determine the user's choice

      do{
        System.out.println("\n" + "Print final Solar System kinematics? (Y/N)");
        choice = scanner.next(); // Scans the user's choice

        if(choice.equals("Y"))
          {
            // Prints the kinematics of the system if the user entered Y
            System.out.println("\n" + "Printing Solar System kinematics... " + "\n");
            s.printSystem();
          }
        if((! choice.equals("Y"))&&(! choice.equals("N")))
          {
              // Informs the user to re-enter their choice if they did not
              // input Y or N
              System.out.println("\n" + "Input does not match menu options");
              System.out.println("Please re-enter" + "\n");
          }
      }while((! choice.equals("Y"))&&(! choice.equals("N")));
      // Loop will keep running until the user enters a valid option

      return;
    }

  /**
   * Gives the user the option to print the intial energy and angular momentum
   * of the system.
   *
   * @param s Model of the Solar System
   *
   */
  public static void printIntialEnergyAndL(SolarSystem s)
    {
      String choice; // String to be used to determine the user's choice

      do{
        System.out.println("\n" + "Print Solar System Intial Energy and Angular Momentum? (Y/N)");
        choice = scanner.next(); // Scans the user's choice

        if(choice.equals("Y"))
          {
            // Prints the intial energy and angular momentum if the user entered Y
            System.out.println("\n" + "Intial properties:");
            s.printEnergyAndL();
          }
        if((! choice.equals("Y"))&&(! choice.equals("N")))
          {
            // Informs the user they will have to re-enter their input as it
            // not Y or N
            System.out.println("\n" + "Input does not match menu options");
            System.out.println("Please re-enter" + "\n");
          }
      }while((! choice.equals("Y"))&&(! choice.equals("N")));
      // Loop will keep running until the user enters a valid option

      return;
    }

  /**
   * Gives the user the option to print the final enery and angular momentum
   * and the conservation of these properties, of the system
   *
   * @param s Model of the Solar System
   *
   */
  public static void printFinalEnergyAndL(SolarSystem s)
    {
      String choice; // String to be used to determine the user's choice

      do{
        System.out.println("\n" + "Print Solar System Final Energy and Angular Momentum? (Y/N)");
        choice = scanner.next(); // Scans the user's choice

        if(choice.equals("Y"))
          {
            // Prints out the desired data if the user entered Y
            System.out.println("\n" + "Final properties:");
            s.printEnergyAndL();
            System.out.println();
            s.printConservation();
          }
        if((! choice.equals("Y"))&&(! choice.equals("N")))
          {
            // Informs the user that they will have to re-enter their choice
            // if they did not input Y or N
            System.out.println("\n" + "Input does not match menu options");
            System.out.println("Please re-enter" + "\n");
          }
      }while((! choice.equals("Y"))&&(! choice.equals("N")));
      // Loop will keep running until the user enters a valid option

      return;
    }

  /**
   * Gives the user the choice to enter a custom body into the simulation
   *
   * @param s Model of the Solar System
   *
   */
  public static void addBody(SolarSystem s)
    {
      String choice = "Y"; // String to used to determined the user's choice
      do{
        System.out.println("\n" + "Add a new body to the simulation? (Y/N)");
        choice = scanner.next(); // Scans in the user's choice

        if(choice.equals("Y"))
          {
            // If the user entered Y, begins the process of entering the
            // parameters of the custom body

            // User names the body
            System.out.print("\n" + "Name of body: ");
            String name = scanner.next();

            // User defines mass
            double m = 100; // Default mass of body
            do{
              System.out.println("\n" + "Enter mass of body (in kg) ");
              try{
                System.out.print("m: "); m = scanner.nextDouble();
                // Scans in mass user entered
              }catch(InputMismatchException e)
                {
                  // If user input was not a double, throws and catches the
                  // InputMismatchException which is printed
                  System.out.println("\n" + "Input mismatch exception: " + e);
                  System.out.println("Setting to default: m = 100kg");
                  // Then the user is told that mass has been set to default
                  // of 100kg. This is set before the loop so the program now
                  // continues
                }

              if(m<=0)
                {
                  // If the user enters a negative or 0 mass (which of course is
                  // impossible), informs the user that they will have to re
                  // -enter
                  System.out.println("\n" + "Mass cannot be less than or equal to 0");
                  System.out.println("Please re-enter");
                }
              }while(m<=0);
              // Loops as long as the mass the user enters is less than or equal
              // to 0

            // User defines the radius
            double radius = 1; // Default radius
            do{
              System.out.println("\n" + "Enter radius of body (in m) ");
              try{
                System.out.print("R: "); radius = scanner.nextDouble();
                // Scans in radius user entered
              }catch(InputMismatchException e)
                {
                  // If user input was not a double, throws and catches the
                  // InputMismatchException which is printed
                  System.out.println("\n" + "Input mismatch exception: " + e);
                  System.out.println("Setting to default: R = 1m");
                  // Then the user is told that the radius has been set to default
                  // of 1m. This is set before the loop so the program now
                  // continues
                }

              if(radius<=0)
                {
                  // If the user enters a negative or 0 radius (which of course
                  // is impossible), informs the user that they will have to re
                  // -enter
                  System.out.println("\n" + "Radius cannot be less than or equal to 0");
                  System.out.println("Please re-enter");
                }
              }while(radius<=0);
              // Loops as long as the radius the user enters is less than or equal
              // to 0

            // User defines the position of the body
            PhysicsVector position = new PhysicsVector();
            double x = 3e11; double y = 3e11; double z = 0;
            // Default parameters of the position

            System.out.println("\n" + "Enter position of body (in m) ");
            try{
              // Prompts user to enter the x,y,z co-ordinates of the body
              System.out.print("x: "); x = scanner.nextDouble();
              System.out.print("y: "); y = scanner.nextDouble();
              System.out.print("z: "); z = scanner.nextDouble();
            }catch(InputMismatchException e)
              {
                // If user input was not a double, throws and catches the
                // InputMismatchException which is printed
                System.out.println("\n" + "Input mismatch exception: " + e);
                System.out.println("Setting to default of body in Main Belt");
                // Then the user is told that the position has been set to the
                // default of a body in the Main Belt. This is set before the
                // loop so the program now continues
              }

            position.setVector(x,y,z);
            // Sets the position of the body to the user defined parameters
            // (or default)

            // User defines the velocity of the body
            PhysicsVector velocity = new PhysicsVector();
            double i = 1e3; double j = 1e3; double k = 0;
            // Default velocity of the body

            System.out.println("\n" + "Enter velocity of body (in m/s) ");
            try{
              // Prompts user to enter the x,y,z components of the body's velocity
              System.out.print("i: "); i = scanner.nextDouble();
              System.out.print("j: "); j = scanner.nextDouble();
              System.out.print("k: "); k = scanner.nextDouble();
            }catch(InputMismatchException e)
              {
                // If user input was not a double, throws and catches the
                // InputMismatchException which is printed
                System.out.println("\n" + "Input mismatch exception: " + e);
                System.out.println("Setting to default of body in Main Belt");
                // Then the user is told that the velocity has been set to the
                // default of a body in the Main Belt. This is set before the
                // loop so the program now continues
              }

            velocity.setVector(i,j,k);
            // Sets the body's velocity to the user defined parameters
            // (or default)

            // Creates the body using the user defined parameters
            GravBody body = new GravBody(name,position,velocity,m,radius);

            // Adds the body to the SolarSystem s (i.e to the simulation)
            s.addBody(body);

            // Informs the user that the body has been added
            System.out.println("\n" + "Body added");
          }

        if((! choice.equals("Y"))&&(! choice.equals("N")))
          {
            // Asks the user re-enter their choice if they entered something
            // other than Y or N
            System.out.println("\n" + "Input does not match menu options");
            System.out.println("Please re-enter" + "\n");
          }

      }while(choice.equals("Y"));
      // Runs as long as the user wishes to keep adding bodies to the simulation

      return;
    }

  /**
   * Prompts user to choose which algorithm to use in the simulation
   *
   * @param M Integer representing a algorithm that the user chooses
   * @return Returns the number corresponding to which algorithm the user picked
   *
   */
  public static int chooseAlgorithm(int M)
    {
      do{
        try{
            // Prompts the user to choose a algorithm
            System.out.println("\n" + "Choose algorithm:");
            System.out.println("Euler             (1)");
            System.out.println("Euler-Cramer      (2)");
            System.out.println("Euler-Richardson  (3)");
            System.out.println("Verlet            (4)");
            System.out.println("Beeman            (5)");
            M = scanner.nextInt(); // Scans user choice
        }catch(InputMismatchException e)
          {
            // If user input was not a int, throws and catches the
            // InputMismatchException which is printed
            System.out.println("\n" + "Input mismatch exception: " + e);
            System.out.println("Setting default: Using Euler");
            M = 1;
            // Algorithm choice is set to 1 (Euler) by default
          }

          if((M!=1)&&(M!=2)&&(M!=3)&&(M!=4)&&(M!=5))
            {
              // If user enters an int other than a menu option, they are
              // informed they will have to re-enter their choice
              System.out.println("\n" + "Input does not match menu options");
              System.out.println("Please re-enter" + "\n");
            }
        }while((M!=1)&&(M!=2)&&(M!=3)&&(M!=4)&&(M!=5));
        // Runs as long as the user does enter a valid menu option

      return M;
    }

  /**
   * Prompts the user to enter the time-step of the simulation
   *
   * @param t Time-step of the simulation
   * @return Returns the user defined time-step
   *
   */
  public static double enterTimeStep(double t)
    {
      do{
        // Prompts user to enter time-step
        System.out.println("\n" + "Enter time interval (in s): ");
        try{
          System.out.print("t: "); t = scanner.nextDouble();
          // Scans in user entered time-step
        }catch(InputMismatchException e)
          {
            // If user input was not a double, throws and catches the
            // InputMismatchException which is printed
            System.out.println("\n" + "Input mismatch exception: " + e);
            System.out.println("Setting to default t = 60s");
            t = 60;
            // Then the user is told that the time-step has been set to default
            // of 60s. Program can now continue
          }

        if(t<=0)
          {
            // If the user enters a negative or 0 time-step (which is not
            // compatible with this simulation), informs the user that they will
            // have to re-enter
            System.out.println("\n" + "Time-step cannot be less than or equal to 0");
            System.out.println("Please re-enter");
          }
        }while(t<=0);
        // Loop runs until user enters a valid time-step

      return t;
    }

  /**
   * Prompts the user to define the durartion of the simulation
   *
   * @param d Duration of the simulation
   * @return Returns the user defined duration of the simulation
   *
   */
  public static double enterDuration(double d)
    {
      do{
        // Prompts user to input the duration of the simulation
        System.out.println("\n" + "Enter duration of simulation (in s): ");
        try{
          System.out.print("Total time: "); d = scanner.nextDouble();
          // Scans the user entered duration
        }catch(InputMismatchException e)
          {
            // If user input was not a double, throws and catches the
            // InputMismatchException which is printed
            System.out.println("\n" + "Input mismatch exception: " + e);
            System.out.println("Setting to default d = 86400s (1 day)");
            d = 86400;
            // Then the user is told that the duration has been set to default
            // of 86400s (1 day). Program can now continue
          }

        if(d<=0)
          {
            // If the user enters a negative or 0 duration (which is not
            // compatible with this simulation), informs the user that they will
            // have to re-enter
            System.out.println("\n" + "Duration cannot be less than or equal to 0");
            System.out.println("Please re-enter");
          }
        }while(d<=0);
        // Loop runs until user enters a valid duration

      return d;
    }

  /**
   * Gives the user the choice to output the data from the simulation to a
   * family of text files, named by the user.
   *
   * @param filename Name of the text files
   * @return Returns the user defined filename or "nooutput" if user chose not to output data
   *
   */
  public static String enterOutputFile(String filename)
    {
      String choice = ""; // String to be used to determine user choice
      do{
        System.out.println("\n" + "Create output files? (Y/N)");
        choice = scanner.next(); // Scans the user's choice

        if(choice.equals("Y"))
          {
            // If user enters Y, they are then prompted to enter the name of the
            // text files
            System.out.println("\n" + "Enter family of files name (without .txt appended)" + "\n");
            filename = scanner.next(); // Scans in user-defined filename
          }
        else if(choice.equals("N"))
          {
            // If user entered N, the filename is set to "nooutput".
            // The implications of this are discussed in SolarSystem
            System.out.println("\n" + "No output files will be created");
            filename = "nooutput";
          }
        else
          {
            // If the user enters something other than Y or N, they are informed
            // that they will have to re-enter
            System.out.println("\n" + "Input does not match menu options");
            System.out.println("Please re-enter" + "\n");
          }
      }while((! choice.equals("Y"))&&(! choice.equals("N")));
      // Loop will keep running until the user enters either Y or N

      return filename;
    }
  /**
   * Prompts user to input the frequency of outputs the simulation will write to file
   *
   * @param f Frequency of outputs to be chosen by the user
   * @return Returns the frequency of outputs the user requested
   *
   */
  public static int enterFrequencyOfOutputs(int f)
    {
      do{
        // Prompts user to input the number of outputs to file
        System.out.println("\n" + "Enter frequency of outputs to file during the simulation: ");
        try{
          System.out.print("Output every: "); f = scanner.nextInt();
          // Scans the user entered number of outputs
        }catch(InputMismatchException e)
          {
            // If user input was not an int, throws and catches the
            // InputMismatchException which is printed
            System.out.println("\n" + "Input mismatch exception: " + e);
            System.out.println("Setting to default frequency = 1000");
            f = 1000;
            // Then the user is told that the frequency has been set to
            // default of 1. Program can now continue
          }

        if(f<=0)
          {
            // If the user enters a negative or 0 frequency of outputs (which is not
            // compatible with this simulation), informs the user that they will
            // have to re-enter
            System.out.println("\n" + "Frequency of outputs cannot be less than or equal to 0");
            System.out.println("Please re-enter");
          }
        }while(f<=0);
        // Loop runs until user enters a valid frequency of outputs

      return f;
    }

  /**
   * Runs the simulation using the user defined parameters
   *
   * @param s Model of the Solar System
   * @param M The algorithm chosen by the user to use in the simulation
   * @param t The time-step chosen by the user to use in the simulation
   * @param d The duration chosen by the user to use in the simulation
   * @param filename The filename to output data to (if user wished this)
   * @param f The frequency of outputs to file
   *
   * @throws IOException Throws exception if a problem occurs writing to a file
   *
   */
  public static void runAlgorithm(SolarSystem s ,int M, double t, double d, int f, String filename)
  throws IOException
    {
      if(M==1)
      {
        // Runs simulation using Euler algorithm and user defined parameters
        // Also prints what the user defined
        System.out.println("\n" + "Running simulation for " + d + "s" + ",");
        System.out.println("using the Euler algorithm, every " + t + "s:");
        s.runEular(t,d,f,filename);
        System.out.println("\n" + "Calculation complete!");
        // Informs user the task has been excecuted
      }
      if(M==2)
      {
        // Runs simulation using Euler-Cramer algorithm and user defined parameters
        // Also prints what the user defined
        System.out.println("\n" + "Running simulation for " + d + "s" + ",");
        System.out.println("using the Euler-Cramer algorithm, every " + t + "s:");
        s.runCramer(t,d,f,filename);
        System.out.println("\n" + "Calculation complete!");
        // Informs user the task has been excecuted
      }
      if(M==3)
      {
        // Runs simulation using Euler-Richardson algorithm and user defined
        // parameters. Also prints what the user defined
        System.out.println("\n" + "Running simulation for " + d + "s" + ",");
        System.out.println("using the Euler-Richardson algorithm, every " + t + "s:");
        s.runRichardson(t,d,f,filename);
        System.out.println("\n" + "Calculation complete!");
        // Informs user the task has been excecuted
      }
      if(M==4)
      {
        // Runs simulation using Verlet algorithm and user defined parameters
        // Also prints what the user defined
        System.out.println("\n" + "Running simulation for " + d + "s" + ",");
        System.out.println("using the Verlet algorithm, every " + t + "s:");
        s.runVerlet(t,d,f,filename);
        System.out.println("\n" + "Calculation complete!");
        // Informs user the task has been excecuted
      }
      if(M==5)
      {
        // Runs simulation using Beeman algorithm and user defined parameters
        // Also prints what the user defined
        System.out.println("\n" + "Running simulation for " + d + "s" + ",");
        System.out.println("using the Beeman algorithm, every " + t + "s:");
        s.runBeeman(t,d,f,filename);
        System.out.println("\n" + "Calculation complete!");
        // Informs user the task has been excecuted
      }

      return;
    }

  /**
   * Runs the standard simulator when called by the main
   *
   * @throws IOException Throws exception if a problem occurs writing to a file
   *
   */
  public static void run() throws IOException
    {
      SolarSystem s = new SolarSystem();
      // Creates an instance of the Solar System

      System.out.print("\n"+"This simulator models the following bodies using");
      System.out.print(" n-body gravitational calculations and data from JPL,");
      System.out.print(" starting at an epoch of the 22nd November 2017.");
      System.out.println("\n" + "The bodies modelled are (Going out from the Sun):" + "\n");
      s.printSystemBodyNames(); // Prints the names of all the bodies in SolarSystem

      System.out.println("\n" + "This program contains basic data on the Solar System");
      printIntialSystem(s);
      // Gives the user the choice to print the intial system

      printIntialEnergyAndL(s);
      // Gives the user the choice to print the intial energy and angular momentum

      addBody(s);
      // Allows the user to input a custom body into the simulation

      System.out.print("\n" + "This simulation can use several different algorithms");
      System.out.print(" to calculate the properties of the solar system");

      int M = 0; // Algorithm number
      M = chooseAlgorithm(M);
      // Prompts user to choose the algorithm to the run the simulation with

      double t = 0; // Time-step of the simulation
      t = enterTimeStep(t);
      // Prompts the user to enter the time-step of the simulation

      double d = 0; // Duration of the simulation
      d = enterDuration(d);
      // Prompts the user to enter the duration of the simulation

      String filename = ""; // Name of the family of files to output data to
      filename = enterOutputFile(filename);
      // Gives the user the option of whether to output the simulation data
      // to a family of text files which the user can define the name of

      int f = 1000;
      if(! filename.equals("nooutput"))
        {
          f = enterFrequencyOfOutputs(f);
        }

      runAlgorithm(s,M,t,d,f,filename);
      // Runs the simulation with the parameters the user had defined

      printFinalSystem(s);
      // Gives the user the option to print the final kinematics of the system

      printFinalEnergyAndL(s);
      // Gives the user the option to print the final energy and angular
      // momentum of the system and the conservation of these properties

      return;
    }

  /**
   * Runs an alternative simulator with increasing time-step
   *
   * @throws IOException Throws exception if a problem occurs writing to a file
   *
   */
  public static void run2() throws IOException
    {
      System.out.print("\n"+"This simulator models the following bodies using");
      System.out.print(" n-body gravitational calculations and data from JPL,");
      System.out.print(" starting at an epoch of the 22nd November 2017.");
      System.out.println("\n" + "The bodies modelled are (Going out from the Sun):" + "\n");

      System.out.print("\n" + "This simulation can use several different algorithms");
      System.out.print(" to calculate the properties of the solar system");

      int M = 0; // Algorithm number
      M = chooseAlgorithm(M);
      // Prompts user to choose the algorithm to the run the simulation with

      double t = 0; // Time-step of the simulation
      t = enterTimeStep(t);
      // Prompts the user to enter the time-step of the simulation

      double d = 0; // Duration of the simulation
      d = enterDuration(d);
      // Prompts the user to enter the duration of the simulation

      String filename = "nooutput";

      String datafile = ""; // Name of two files to output data to
      datafile = enterOutputFile(datafile);

      String dataL = "Time-step" + "\t" + "Difference in L" + "\n";
      String dataE = "Time-step" + "\t" + "Difference in E" + "\n";
      // Strings to store data on conservation of E and L

      int f = 1000; //Arbitary f to send to SolarSystem

      // Runs the simulation with the parameters the user had defined
      do{
        System.out.println("\n" + "Time step: " + t + "s");
        SolarSystem s = new SolarSystem();
        runAlgorithm(s,M,t,d,f,filename);

        dataL += t + "\t" + s.getDiffLMag() + "\n";
        dataE += t + "\t" + s.getDiffE() + "\n";

        t = 1.5*t;
      }while(t < d/10.0);

      System.out.println("\n" + "Operation complete!");

      DataOutput outputL = new DataOutput();
      DataOutput.dataToFile(dataL,datafile + "_L.txt");
      DataOutput outputE = new DataOutput();
      DataOutput.dataToFile(dataE,datafile + "_E.txt");

      return;
    }

  public static void main(String [] Args) throws IOException
    {
      // Prints welcome message
      System.out.println("\n" + "Welcome to Solar System Simulator");
      System.out.println("Version: 5.3");
      System.out.println("Created by Harry Baker");
      System.out.println("\n" + "Please read the README file located in this");
      System.out.print(" directory, before first use");

      int simChoice; // Integer to hold user choice
      do{
        System.out.println("\n" + "********************Main Menu******************");
        System.out.println("\n" + "Choose type of simulation to run:");
        System.out.println("Standard Simulator with custom parameters (1)");
        System.out.println("Simulator with increasing time-step       (2)");
        System.out.println("Exit Solar System Sim                     (3)");

        try{
          simChoice = scanner.nextInt();
        }catch(InputMismatchException e)
          {
            // If user input was not a int, throws and catches the
            // InputMismatchException which is printed
            System.out.println("\n" + "Input mismatch exception: " + e);
            System.out.println("Setting to default of Standard Simulator");
            simChoice = 1;
            // Then the user is told that the standard simulator has been chosen
            // by default. Program can now continue
          }

        if(simChoice == 1)
          {
            run();
            simChoice = 0;
            // Runs the simulation parameter entering and then runs the chosen sim
          }

        else if(simChoice == 2)
          {
            run2();
            simChoice = 0;
            // Runs the simulation parameter entering and then runs the chosen sim
          }

        else if(simChoice == 3)
          {
            continue;
            // Exiting loop so goodbye message can be printed then ends program
          }

        else
          {
            // If user does not enter a menu option, they will have to re-enter
            System.out.println("\n" + "Input does not match menu options!");
            System.out.println("Please re-enter menu option!");
          }
      }while((simChoice != 1)&&(simChoice != 2)&&(simChoice != 3));
      // Runs simulation until user enters a valid option

      // Goodbye message
      System.out.println("\n" + "Output files can be found in the parent directory");
      System.out.println("Thank you for using Solar System Simulator!");
      System.out.println("Goodbye :)");
    }
  }
//End Program
