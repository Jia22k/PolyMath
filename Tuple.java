package PolyMath;

/**
 * This class contains tuples, two integers in an ordered pair.
 * @author Jiana Kambo
 */
public class Tuple {
    /** Field defining the first half of the tuple */
    private double u;

    /** Field defining the second half of the tuple */
    private double v;

    /**
     * Getter method for the u, one part of the tuple
     * @return the value fo u
     */
    public double getU() {
        return u;
    }

    /**
     * getter method for v, one part of the tuple
     * @return the value of v
     */
    public double getV() {
        return v;
    }

    /**
     * setter method for u, one part of the tuple
     * @param u, the value to set u too
     */
    public void setU(double u) {
        this.u = u;
    }

    /**
     * setter method for v, one part of the tuple
     * @param v, the value for v
     */
    public void setV(double v) {
        this.v = v;
    }

    /**
     * Contructor for tuple
     * @param u, one part of the tuple
     * @param v, other part of the tuple
     */
    public Tuple(double u, double v) {
        this.u = u;
        this.v = v;
    }
    /**
     * Overriding the method to show tuple as an ordered pair
     * @return String showing the tuple as an ordered pair
     */
    public String toString(){
        return "(" + getU() + "," + getV() + ")" ;
    }
}
