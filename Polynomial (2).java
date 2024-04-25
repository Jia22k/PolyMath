package PolyMath;
import java.util.*;

/**
 * A class that has the polynomial object coded into it
 * @author Jiana Kambo
 */
public class Polynomial {
    /** Field storing the array that is polynomial*/
    private Tuple[] polynomial;

    /** Constructor
     * @param  array of tuples
     */
    public Polynomial(Tuple... polynomial) {
        this.polynomial = polynomial;
    }
    /**
     * Getter method for the polynomial
     * @return polynomial
     */
    public Tuple[] getPolynomial() {
        return polynomial;
    }

    /**
     * Main method computing the definite integral based on user input.
     * @param args, the user inputs the polynomial they would like to evaluate
     */
    public static void main(String[] args) {

        /**Polynomial n = new Polynomial(new Tuple(-2, 3), new Tuple(-2, 3), new Tuple(-2, -3), new Tuple(2, -3));
        System.out.println(n.toString());
        Polynomial x = new Polynomial(new Tuple(2, 2));
        System.out.println(x.definiteIntegral(1, 1.5));
        System.out.println(x.eval(5)); */


        Tuple[] userPoly = new Tuple[args.length / 2];
        if (args.length < 2 || args.length % 2 !=0){
            System.out.println("Please enter all ordered pair properly to process polynomial power and coefficients");
         return;
        }
        try {
            for (int i = 0; i < args.length/2; i++) {
                double u = Double.parseDouble(args[2 * i]);
                double v = Double.parseDouble(args[2 * i+1]);
                userPoly[i] = new Tuple(u, v);
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid coefficient or power");
            return;
        }

        Polynomial inputPolynomial = new Polynomial(userPoly);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the lower bound: ");
        double a = sc.nextDouble();
        System.out.print("Enter the upper bound: ");
        double b = sc.nextDouble();

        if (a>b) {
            System.out.println("Lower bound has to be lower than the upper bound");
            return;
        }
        Tuple limits = new Tuple(a,b);

        long startTime = System.currentTimeMillis();
        double integralCalculated = inputPolynomial.definiteIntegral(a,b);
        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("The definite integral of polynomial" + inputPolynomial.toString() + " between " + limits.toString() + " is " + integralCalculated );
        System.out.println("The time elapsed is : "+elapsedTime);
    }

    /**
     * Setter method for the polynomial
     * @param polynomial
     */
    public void setPolynomial(Tuple[] polynomial) {
        this.polynomial = polynomial;
    }

    /**
     * Method that evaluates the value of the polynomial
     * @param x, the value at which we want to evaluate the polynomial
     * @return the value of the polynomial evaluated at x
     */
    public double eval(double x){

     double value = 0;
        for (Tuple y : getPolynomial()){
          value += y.getU() * Math.pow(x, y.getV());
     }
     return value;
    }

    /**
     * Overriding the method to display the polynomial in a mathematical form
     * @return a string displaying the polynimial in a mathematical form
     */
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (Tuple x : getPolynomial()) {
            if ((b.length() == 0) && (x.getV() > 1)) {
                b.append(x.getU() + "x^" + x.getV());
            }
            if ((b.length() == 0) && (x.getV() == 1)) {
                b.append(x.getU() + "x");
            }
            if ((b.length() == 0) && (x.getV() == 0)) {
                b.append(x.getU());
            }
            if ((b.length() == 0) && (x.getV() < 0)) {
                b.append(x.getU() + "/x^" + Math.abs(x.getV()));
            }
            if ((x.getU() > 0) && (x.getV() > 1)) {
                b.append("+" + x.getU() + "x^" + x.getV());
            }
            if ((x.getU() > 0) && (x.getV() == 1)) {
                b.append("+" + x.getU() + "x");
            }
            if ((x.getU() > 0) && (x.getV() == 0)) {
                b.append("+" + x.getU());
            }
            if ((x.getU() > 0) && (x.getV() < 0)) {
                b.append("+" + x.getU() + "/x^" + Math.abs(x.getV()));
            }
            if ((x.getU() < 0) && (x.getV() > 1)) {
                b.append(x.getU() + "x^" + x.getV());
            }
            if ((x.getU() < 0) && (x.getV() == 1)) {
                b.append(x.getU() + "x");
            }
            if ((x.getU() < 0) && (x.getV() == 0)) {
                b.append(x.getU());
            }
            if ((x.getU() < 0) && (x.getV() < 0)) {
                b.append(x.getU() + "/x^" + Math.abs(x.getV()));
            }
        }
        return b.toString();
    }

    /**
     * method evaluating the definite integral of the given polynomial
     * @param a lower limit to evaluate the polynomial on
     * @param b upper limit to evaluate the polynomial on
     * @return the value of the definite integral based on the limits
     */
    public double definiteIntegral(double a, double b){
        double integral = 0;
        for (double i = a+(b-a)/1000 ; i < b; i += ((b-a)/1000)){
            integral +=  0.5*(eval(i)+eval(i-((b-a)/1000)));
        }
        integral *= ((b-a)/1000);
        return integral;
    }
}
