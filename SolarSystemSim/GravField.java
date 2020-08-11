import java.lang.Math;

/**
 * Name: GravField
 * Purpose: To simulate the gravitational field of a body
 *
 * @author Harry Baker
 * @version 1.0
 * Date: 27.11.2017
 *
 */
public class GravField
  {
    private static final double G = 6.67408e-11; // Gravitational constant
    private double mBody; // Mass of body
    private double R; // Radius of body
    private PhysicsVector rBody; // Radius of body as a vector
    private PhysicsVector g; // Acceleration due to gravity
    private double c; // Scalar part of equation for g

    /**
     * Default constructor of GravField that calculates g at the surface of a
     * body with mass of 1, radius of 1, using:
     * g = (GM/r^2)r^
     * Where r^ is the unit vector of r which is the displacement from the centre
     * of the body to the point where g is to be calculated
     *
     */
    public GravField()
      {
        R = 1;
        mBody = 1;
        rBody = new PhysicsVector(0,R);
        c = (-1*G*mBody)/(Math.pow((rBody.magnitude()),2));
        g = new PhysicsVector(PhysicsVector.scale(c,rBody.getUnitVector()));
      }

    /**
     * Produces a GravField of a body with mass M and radius R, and a g at the
     * surface of the body, using:
     * g = (GM/r^2)r^
     * Where r^ is the unit vector of r which is the displacement from the centre
     * of the body to the point where g is to be calculated
     *
     * @param M Mass of the body
     * @param R Radius of the body
     *
     */
    public GravField(double M, double R)
      {
        mBody = M;
        rBody = new PhysicsVector(0,R);
        c = (-1*G*mBody)/(Math.pow((rBody.magnitude()),2));
        g = new PhysicsVector(PhysicsVector.scale(c,rBody.getUnitVector()));
      }

    /**
     * Constructs a GravField of a body with mass M and radius R and a g at a
     * distance from the surface of r, using:
     * g = (GM/r^2)r^
     * Where r^ is the unit vector of r which is the displacement from the centre
     * of the body to the point where g is to be calculated
     *
     * @param M Mass of the body
     * @param R Radius of the body
     * @param r Displacement from the body's surface
     *
     */
    public GravField(double M, double R, PhysicsVector r)
      {
        mBody = M;
        rBody = new PhysicsVector(0,R);
        c = (-1*G*mBody)/(Math.pow(((PhysicsVector.add(r,rBody)).magnitude()),2));
        g = new PhysicsVector(PhysicsVector.scale(c,
        (PhysicsVector.add(r,rBody)).getUnitVector()));
      }

    /**
     * Constructs a GravField of a point object with mass m, with g calculated
     * at a distance r, using
     * g = (GM/r^2)r^
     * Where r^ is the unit vector of r which is the displacement from the centre
     * of the body to the point where g is to be calculated
     *
     * @param r Displacement from object
     * @param m Mass of object
     *
     */
    public GravField(PhysicsVector r, double m)
      {
        g = new PhysicsVector(PhysicsVector.scale(((-G*m)/(Math.pow(r.magnitude(),2))),
        r.getUnitVector()));
      }

    /**
     * Constructs a new GravField as a copy of an exsisting one, using:
     * g = (GM/r^2)r^
     * Where r^ is the unit vector of r which is the displacement from the centre
     * of the body to the point where g is to be calculated
     *
     * @param gBody GravField to be copied
     *
     */
    public GravField(GravField gBody)
      {
        mBody = gBody.mBody;
        rBody = new PhysicsVector(gBody.rBody);
        c = (-1*G*mBody)/(Math.pow((rBody.magnitude()),2));
        g = new PhysicsVector(PhysicsVector.scale(c,rBody.getUnitVector()));
      }

    /**
     * Calculates the acceleration due to gravity at a point r from the surface
     * of a body using
     * g = (GM/r^2)r^
     * Where r^ is the unit vector of r which is the displacement from the centre
     * of the body to the point where g is to be calculated
     *
     * @param r Displacement to point where g is to be calculated
     *
     */
    public void setGrav(PhysicsVector r)
      {
        c = (-1*G*mBody)/(Math.pow(((PhysicsVector.add(r,rBody)).magnitude()),2));
        g.setVector(PhysicsVector.scale(c,((PhysicsVector.add(r,rBody)).getUnitVector())));
      }

    /**
     * Gets the vector form of the acceleration due to gravity at a point
     *
     * @return Returns the g as a PhysicsVector
     *
     */
    public PhysicsVector getg()
      {
        return g;
      }

    /**
     * Gets the scalar form of the acceleration due to gravity at a point
     *
     * @return Returns g as a double
     *
     */
    public double getgmag()
      {
        return g.magnitude();
      }

    /**
     * Gets the Gravitational Constant
     *
     * @return Returns G
     *
     */
    public double getG()
      {
        return G;
      }

    /**
     * Prints the vector form of g to the screen
     *
     */
    public void printGravField()
      {
        g.print();
      }
  }
