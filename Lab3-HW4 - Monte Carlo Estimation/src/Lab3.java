import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Modify MonteCarlo.java so that it generates 2-dimensional points in the
 * [0.0,2.0) x [0.0,2.0) square and estimates the area of the circle of radius 1
 * centered at (1.0,1.0).
 */
public final class Lab3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Lab3() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        /*
         * Open input and output streams
         */
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        /*
         * Ask user for number of points to generate
         */
        output.print("Number of points: ");
        int n = input.nextInteger();
        /*
         * Declare counters and initialize them
         */
        int counter = 0, ptsInCircle = 0;
        /*
         * Create pseudo-random number generator
         */
        Random rnd = new Random1L();
        /*
         * Generate points and count how many fall in the area of the circle of
         * radius 1 centered at (1.0,1.0)
         */
        final double constant = 4.0;
        while (counter < n) {
            /*
             * Generate pseudo-random co-ordinates in [0.0,2.0) interval
             */
            double x = rnd.nextDouble() * 2;
            double y = rnd.nextDouble() * 2;
            /*
             * Increment total number of generated points
             */
            counter++;
            /*
             * Check if point is in the circle of radius 1 centered at (1.0,1.0)
             * and increment ptsInCircle if it is
             */
            if ((x - 1) * (x - 1) + (y - 1) * (y - 1) <= 1) {
                ptsInCircle++;
            }
        }
        /*
         * Estimate area(pi).
         */
        double estimate = (constant * ptsInCircle) / counter;
        output.println("Estimate for area(pi): " + estimate);
        /*
         * Close input and output streams
         */
        input.close();
        output.close();
    }

}
