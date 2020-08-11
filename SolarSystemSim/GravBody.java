/**
 * Name: GravBody
 * Purpose: To model a gravitational body that has mass, radius, position,
 * velocity, a name and can be acted upon by other GravBodys
 *
 * @author Harry Baker
 * @version 2.2
 * Date: 11.12.2017
 *
 */
public class GravBody
  {
    private String name; // Name of body
    private PhysicsVector r; // Position of the body as a 3D vector
    private PhysicsVector v; // Velocity of the body as a 3D vector
    private double m; // Mass of body
    private double R; // Radius of body
    private PhysicsVector rBody;
    // Vector form of radius of body so surface gravity can be determined
    private GravField gBody; // Gravitational field of the body
    private PhysicsVector totala; // Total acceleration of the body
    private double kE; // Kinetic Energy of the body
    private double gPE; // Gravitational Potential Energy of the body
    private PhysicsVector l; // Angular Momentum of body
    private String positionData;

    /**
     * Default constructor of GravBody. Sets the position and velocity to 0
     * and the mass and radius to 1. Names the body "Body".
     *
     */
    public GravBody()
      {
        name = new String();
        name = "Body";
        r = new PhysicsVector(0,0,0);
        v = new PhysicsVector(0,0,0);
        m = 1;
        R = 1;
        rBody = new PhysicsVector(0,R,0);
        gBody = new GravField(rBody,m);
        totala = new PhysicsVector(0,0,0);
        kE = 0.5*m*Math.pow(v.magnitude(),2);
        gPE = 0;
        l = new PhysicsVector(PhysicsVector.vectorProduct(r,PhysicsVector.scale(m,v)));
        positionData = new String();
      }

    /**
     * Constructor of GravBody that sets every component seperately.
     * Calculates the surface gravity and kE. Sets gPE and totala to 0 as
     * this requires other GravBodys to calculate this.
     *
     * @param a Set to the name of the body
     * @param x Set to the x-component of the position of the body
     * @param y Set to the y-component of the position of the body
     * @param z Set to the z-component of the position of the body
     * @param i Set to the x-component of the velocity of the body
     * @param j Set to the y-component of the velocity of the body
     * @param k Set to the z-component of the velocity of the body
     * @param M Set to the mass of the body
     * @param d Set to the radius of the body
     *
     */
    public GravBody(String a, double x, double y, double z, double i, double j, double k, double M, double d)
      {
        name = a;
        r = new PhysicsVector(x,y,z);
        v = new PhysicsVector(i,j,k);
        m = M;
        R = d;
        rBody = new PhysicsVector(0,R,0);
        gBody = new GravField(rBody,m);
        totala = new PhysicsVector(0,0,0);
        kE = 0.5*m*Math.pow(v.magnitude(),2);
        gPE = 0;
        l = new PhysicsVector(PhysicsVector.vectorProduct(r,PhysicsVector.scale(m,v)));
        positionData = new String();
        positionData = name + " X" + "\t" + name + " Y" + "\n";
      }

    /**
     * Constructor of GravBody that sets the position and velocity using
     * PhysicsVectors. Calculates the surface gravity and kE. Sets gPE and
     * totala to 0 as this requires other GravBodys to calculate this.
     *
     * @param a Set to the name of the body
     * @param p Set to the position of the body
     * @param u Set to the velocity of the body
     * @param M Set to the mass of the body
     * @param d Set to the radius of the body
     *
     */
    public GravBody(String a, PhysicsVector p, PhysicsVector u, double M, double d)
      {
        name = a;
        r = new PhysicsVector(p);
        v = new PhysicsVector(u);
        m = M;
        R = d;
        rBody = new PhysicsVector(0,R,0);
        gBody = new GravField(rBody,m);
        totala = new PhysicsVector(0,0,0);
        kE = 0.5*m*Math.pow(v.magnitude(),2);
        gPE = 0;
        l = new PhysicsVector(1,1,1);
        l.setVector(PhysicsVector.vectorProduct(r,PhysicsVector.scale(m,v)));
        positionData = new String();
        positionData = name + " X" + "\t" + name + " Y" + "\n";
      }

    /**
     * Constructor of GravBody that copies a GravBody by setting every compenent
     * to be the same as the GravBody to be copied.
     *
     * @param planet GravBody to be copied
     *
     */
    public GravBody(GravBody planet)
      {
        name = new String();
        name = planet.name;
        r = new PhysicsVector(planet.r);
        v = new PhysicsVector(planet.v);
        m = planet.m;
        R = planet.R;
        rBody = new PhysicsVector(0,R,0);
        gBody = new GravField(rBody,m);
        totala = new PhysicsVector(planet.totala);
        kE = planet.kE;
        gPE = planet.gPE;
        l = new PhysicsVector(planet.l);
        positionData = new String();
        positionData = name + " X" + "\t" + name + " Y" + "\n";
      }

    /**
     * Sets the body's position and velocity components seperately
     *
     * @param x Set to the x-component of the position of the body
     * @param y Set to the y-component of the position of the body
     * @param z Set to the z-component of the position of the body
     * @param i Set to the x-component of the velocity of the body
     * @param j Set to the y-component of the velocity of the body
     * @param k Set to the z-component of the velocity of the body
     *
     */
    public void setBody(double x, double y, double z, double i, double j, double k)
      {
        r.setVector(x,y,z);
        v.setVector(i,j,k);
      }

    /**
     * Sets the body's position and velocity using PhysicsVectors
     *
     * @param p Set to the position of the body
     * @param u Set to the velocity of the body
     *
     */
    public void setBody(PhysicsVector p, PhysicsVector u)
      {
        r.setVector(p);
        v.setVector(u);
      }

    /**
     * Sets a GravBody's parameters to another GravBody's
     *
     * @param planet GravBody to be used to set this body to
     *
     */
    public void setBody(GravBody planet)
      {
        name = new String(planet.name);
        r = new PhysicsVector(planet.r);
        v = new PhysicsVector(planet.v);
        m = planet.m;
        R = planet.R;
        rBody = new PhysicsVector(0,R,0);
        gBody = new GravField(rBody,m);
        totala.setVector(planet.totala);
        kE = planet.kE;
        gPE = planet.gPE;
        l = new PhysicsVector(planet.l);
        positionData = name + " X" + "\t" + name + " Y" + "\n";
      }

    /**
     * Sets the body's position components seperately
     *
     * @param x Set to the x-component of the position of the body
     * @param y Set to the y-component of the position of the body
     * @param z Set to the z-component of the position of the body
     *
     */
    public void setPosition(double x, double y, double z)
      {
        r.setVector(x,y,z);
      }

    /**
     * Sets the body's position using a PhysicsVector
     *
     * @param p New position of the body
     *
     */
    public void setPosition(PhysicsVector p)
      {
        r.setVector(p);
      }

    /**
     * Sets the body's velocity components seperately
     *
     * @param i Set to the x-component of the velocity of the body
     * @param j Set to the y-component of the velocity of the body
     * @param k Set to the z-component of the velocity of the body
     *
     */
    public void setVelocity(double i, double j, double k)
      {
        v.setVector(i,j,k);
      }

    /**
     * Sets the body's velocity using a PhysicsVector
     *
     * @param u New velocity of the body
     *
     */
    public void setVelocity(PhysicsVector u)
      {
        v.setVector(u);
      }

    /**
     * Sets the angular momentum of the body using L = r x mv
     *
     */
    public void setAngularMomentum()
      {
        l.setVector(PhysicsVector.vectorProduct(r,PhysicsVector.scale(m,v)));
      }

    /**
     * Sets the total acceleration components of the body seperately
     *
     * @param a Set to the x-component of the total acceleration of the body
     * @param b Set to the y-component of the total acceleration of the body
     * @param c Set to the z-component of the total acceleration of the body
     *
     */
    public void setTotAcc(double a, double b, double c)
      {
        totala.setVector(a,b,c);
      }

    /**
     * Sets the total acceleration of the body using a PhysicsVector
     *
     * @param a New total acceleration
     *
     */
    public void setTotAcc(PhysicsVector a)
      {
        totala.setVector(a);
      }

    /**
     * Returns the gravitational attraction of one body onto this body, using
     * g = (Gm/r^2)r^ where g is the acceleration due to gravity, G is the
     * Gravitational Constant, m is the mass of the other body, r is the
     * displacement vector between the bodies, and r^ is the unit vector of
     * this displacement vector
     *
     * @param q GravBody effecting this GravBody
     *
     * @return Acceleration due to gravity on this body from body q, a
     *
     */
    public PhysicsVector calcGrav(GravBody q)
      {
        PhysicsVector d = new PhysicsVector();
        PhysicsVector a = new PhysicsVector();
        d.setVector(PhysicsVector.subtract(r,q.getPosition()));
        a.setVector(PhysicsVector.scale((((-gBody.getG())*q.getMass())/(Math.pow(d.magnitude(),2))),d.getUnitVector()));
        return a;
      }

    /**
     * Sets the kinetic energy of the body using KE = 0.5*m*v^2
     *
     */
    public void setKE()
      {
        kE = 0.5*m*(Math.pow(v.magnitude(),2));
      }

    /**
     * Sets the GPE of the body with respect to another body using
     * GPE = -GMm/r
     * Where G is the gravitational constant, M is the mass of the other body
     * m is the mass of this body, r is the displacement vector between them.
     *
     * @param q Body GPE is being calculated with respect to
     *
     */
    public void setGPE(GravBody q)
      {
        double d = PhysicsVector.subtract(r,q.getPosition()).magnitude();
        gPE = -1*(gBody.getG()*m*q.getMass())/(d);
      }

    /**
     * Formats the positionData string for easy plotting of a GravBody's trajectory
     *
     */
    public void setPositionData()
      {
        positionData += r.getX() + "\t" + r.getY() + "\n";
      }

    /**
     * Increases the total acceleration by the acceleration resulting from the
     * gravitational attraction from the other body, using calcGrav.
     *
     * @param q GravBody attracting this GravBody
     *
     */
    public void calcTotBodyAcc(GravBody q)
      {
        totala.increaseBy(this.calcGrav(q));
      }

    /**
     * Increases the total acceleration of the body by a PhysicsVector
     *
     * @param a Increases the total acceleration by this PhysicsVector
     *
     */
    public void increaseTotAccBy(PhysicsVector a)
      {
        totala.increaseBy(a);
      }

    /**
     * Uses the Euler alogrithm to move a body foward by a time step
     * r(t+dt) = r(t) + v(t)dt
     * v(t+dt) = v(t) + a(t)dt
     * Where dt is the time step, t is the intial time of the iteration
     *
     * @param t Time step of the iteration
     *
     */
    public void euler(double t)
      {
        r.increaseBy(PhysicsVector.scale(t,v));
        v.increaseBy(PhysicsVector.scale(t,totala));
      }

    /**
     * Uses the Euler-Cramer alogrithm to move a body foward by a time step
     * v(t+dt) = v(t) + a(t)dt
     * r(t+dt) = r(t) + v(t+dt)dt
     * Where dt is the time step, t is the intial time of the iteration
     *
     * @param t Time step of the iteration
     *
     */
    public void eulerCramer(double t)
      {
        v.increaseBy(PhysicsVector.scale(t,totala));
        r.increaseBy(PhysicsVector.scale(t,v));
      }

    /**
     * Uses the Euler-Cramer algorithm with the velocity and acceleration from
     * the mid-point of the iteration
     * v(t+dt) = v(t) + a(t+0.5t)dt
     * r(t+dt) = r(t) + v(t+0.5t)dt
     * Where dt is the time step, t is the initial time of the iteration
     *
     * @param bodymid Copy of the body at the mid-point of the iteration
     * @param t Time step of the iteration
     *
     */
    public void eulerRichardson(GravBody bodymid, double t)
      {
        v.increaseBy(PhysicsVector.scale(t,bodymid.totala));
        r.increaseBy(PhysicsVector.scale(t,bodymid.v));
      }

    /**
     * Implements the first part of the Verlet alogrithm to move a body foward
     * by a time step.
     * r(t+dt) = r(t) + v(t)dt + 0.5a(t)(dt)^2
     * Where dt is the time step, t is the intial time of the iteration
     *
     * @param t Time step of the iteration
     *
     */
    public void verletPtOne(double t)
      {
        r.increaseBy(PhysicsVector.add(PhysicsVector.scale(t,v),
        PhysicsVector.scale(0.5*t*t,totala)));
      }

    /**
     * Implements the last part of the Verlet algorithm to move a body foward
     * by a time step. a_n+1 has to be calculated through SolarSystem
     * v(t+dt) = v(t) + 0.5*(a(t+dt) + a(t))dt
     * Where dt is the time step, t is the intial time of the iteration
     *
     * @param t Time step of the iteration
     * @param intialTotA Average acceleration of body over time-step
     *
     *
     */
    public void verletPtTwo(PhysicsVector intialTotA, double t)
      {
        // Calculates average acceleration across the time-step for the body
        PhysicsVector aAvg = new PhysicsVector();
        aAvg.setVector(PhysicsVector.scale(
        0.5,PhysicsVector.add(totala,intialTotA)));

        // Sets the velocity of the body at v(t+dt)
        v.increaseBy(PhysicsVector.scale(t,aAvg));
      }

    /**
     * Uses the 1st half of the Beeman algorithm to move a body forward by a
     * time-step dt.
     * r(t+dt) = x(t) + v(t)dt + (2/3)*a(t)*(dt)^2 - (1/6)*a(t-dt)*(dt)^2
     * Where dt is the time-step, t is the intial time of the iteration
     *
     * @param aback Acceleration on body at time t-dt
     * @param t Time-step of iteration
     *
     */
    public void beemanPtOne(PhysicsVector aback, double t)
      {
        r.increaseBy(PhysicsVector.subtract(PhysicsVector.add(PhysicsVector.scale(t,v),
        PhysicsVector.scale((2.0/3.0)*t*t,totala)),
        PhysicsVector.scale((1.0/6.0)*t*t,aback)));
      }

    /**
     * Uses the 2nd half of the Beeman algorithm to calculate a body's velocity
     * after it has been moved forward by a time-step dt.
     * v(t+dt) = v(t) + (5/12)*a(t+dt)dt + (2/3)*a(t)dt - (1/12)*a(t-dt)dt
     * Where dt is the time-step, t is the intial time of the iteration
     *
     * @param aback Acceleration on body at time t-dt
     * @param aIntial Acceleration on body at start of iteration
     * @param t Time-step of iteration
     *
     */
    public void beemanPtTwo(PhysicsVector aback, PhysicsVector aIntial, double t)
      {
        v.increaseBy(PhysicsVector.subtract(PhysicsVector.add(
        PhysicsVector.scale((2.0/3.0)*t,aIntial),
        PhysicsVector.scale((5.0/12.0)*t,totala)),
        PhysicsVector.scale((1.0/12.0)*t,aback)));
      }

    /**
     * Uses the Adams-Moulton version of the Beeman algorithm.
     * v(t+dt) = v(t) + (5/12)*a(t+dt)dt + (8/12)*a(t)dt - (1/12)*a(t-dt)dt
     *
     * @param aback Acceleration on body at time t-dt
     * @param aIntial Acceleration on body at start of iteration
     * @param t Time-step of iteration
     *
     */
    public void adamMoulton(PhysicsVector aback, PhysicsVector aIntial, double t)
      {
        v.increaseBy(PhysicsVector.subtract(PhysicsVector.add(
        PhysicsVector.scale((5.0/12.0)*t,totala),
        PhysicsVector.scale((3.0/4.0)*t,aIntial)),
        PhysicsVector.scale((1.0/12.0)*t,aback)));
      }

    /**
     * Returns the name of the body
     *
     * @return Returns the name of the body as a string
     *
     */
    public String getName()
      {
        return name;
      }

    /**
     * Returns the position of the body
     *
     * @return Returns the position of the body as a PhysicsVector
     *
     */
    public PhysicsVector getPosition()
      {
        return new PhysicsVector(r);
      }

    /**
     * Returns the x-component of the position of the body
     *
     * @return Returns the x-component of the position of the body as a double
     *
     */
    public double getPositionX()
      {
        return r.getX();
      }

    /**
     * Returns the y-component of the position of the body
     *
     * @return Returns the y-component of the position of the body as a double
     *
     */
    public double getPositionY()
      {
        return r.getY();
      }

    /**
     * Returns the z-component of the position of the body
     *
     * @return Returns the z-component of the position of the body as a double
     *
     */
    public double getPositionZ()
      {
        return r.getZ();
      }

    /**
     * Returns the velocity of the body
     *
     * @return Returns the velocity of the body as a PhysicsVector
     *
     */
    public PhysicsVector getVelocity()
      {
        return new PhysicsVector(v);
      }

    /**
     * Returns the x-component of the velocity of the body
     *
     * @return Returns the x-component of the velocity of the body as a double
     *
     */
    public double getVelocityX()
      {
        return v.getX();
      }

    /**
     * Returns the y-component of the velocity of the body
     *
     * @return Returns the y-component of the velocity of the body as a double
     *
     */
    public double getVelocityY()
      {
        return v.getY();
      }

    /**
     * Returns the z-component of the velocity of the body
     *
     * @return Returns the z-component of the velocity of the body as a double
     *
     */
    public double getVelocityZ()
      {
        return v.getZ();
      }

    /**
     * Returns the mass of the body
     *
     * @return Returns the mass of the body as a double
     *
     */
    public double getMass()
      {
        return m;
      }

    /**
     * Returns the radius of the body
     *
     * @return Returns the radius of the body as a double
     *
     */
    public double getRadius()
      {
        return R;
      }

    /**
     * Returns the GravField component of the body
     *
     * @return Returns the GravField of the body
     *
     */
    public GravField getgBody()
      {
        return new GravField(gBody);
      }

    /**
     * Returns the surface gravity of the body
     *
     * @return Returns the surface gravity of the body as a PhysicsVector
     *
     */
    public PhysicsVector getg()
      {
        return gBody.getg();
      }

    /**
     * Returns the total acceleration of the body
     *
     * @return Returns the total acceleration of the body as a PhysicsVector
     *
     */
    public PhysicsVector getTotAcc()
      {
        return new PhysicsVector(totala);
      }

    /**
     * Returns the kinetic energy of the body
     *
     * @return Returns the kinetic energy of the body as a double
     *
     */
    public double getKE()
      {
        return kE;
      }

    /**
     * Returns the GPE of the body
     *
     * @return Returns the GPE of the body as a double
     *
     */
    public double getGPE()
      {
        return gPE;
      }

    /**
     * Returns the angular momentum of the body
     *
     * @return Returns the angular momentum of the body as a PhysicsVector
     *
     */
    public PhysicsVector getAngularMomentum()
      {
        return new PhysicsVector(l);
      }

    /**
     * Returns the magnitude of the angular momentum of the body
     *
     * @return Returns the magnitude of the angular momentum of the body as a
     * double
     *
     */
    public double getAngularMomentumMag()
      {
        return l.magnitude();
      }

    /**
     * Returns the string holding the position data of the body
     *
     * @return Returns the String positionData
     *
     */
    public String getPositionData()
      {
        return positionData;
      }

    /**
     * Prints the characteristics of the body
     *
     */
    public void printBodyChar()
      {
        System.out.println();
        System.out.println("Body Name:" + name);
        System.out.println("Mass: " + m + "kg");
        System.out.println("Radius: " + R + "m");
        System.out.print("Position: "); r.print();
        System.out.print("Velocity: "); v.print();
        System.out.println("Surface Gravity: " + gBody.getgmag() + "m/s*s");
        System.out.println("Kinnetic Energy: " + kE + "J");
        System.out.println("Angular Momentum: " + l.magnitude() + "kgm/s");
      }

    /**
     * Prints the position and velocity of the body
     *
     */
    public void printBody()
      {
        System.out.println();
        System.out.println("Body Name:" + name);
        System.out.print("Position: "); r.print();
        System.out.print("Velocity: "); v.print();
      }
  }
