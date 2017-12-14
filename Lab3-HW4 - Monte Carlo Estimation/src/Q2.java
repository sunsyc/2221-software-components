import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 * @author Shiny Patel.
 *
 */
abstract class Q2 {
    /**
     * Generates n pseudo-random points in the [0.0,2.0) x [0.0,2.0) square and
     * returns the number that fall in the circle of radius 1.0 centered at the
     * point (1.0, 1.0).
     *
     * @param n
     *            the number of points to generate
     * @return the number of points that fall in the circle
     */
    private static int numberOfPointsInCircle(int n) {
        int counter = 0, pointsFallInCircle = 0;
        /*
         * Create pseudo-random number generator
         */
        Random rnd = new Random1L();
        while (counter < n) {
            /*
             * Generate n pseudo-random co-ordinates in [0.0,2.0) interval
             */
            double x = rnd.nextDouble() * 2;
            double y = rnd.nextDouble() * 2;
            boolean result = pointIsInCircle(x, y);
            /*
             * method call to check if n pseudo-random co-ordinates fall in the
             * circle of radius 1.0 centered at the point (1.0, 1.0).
             */
            if (result) {
                pointsFallInCircle++;
                /*
                 * if n pseudo-random co-ordinates fall in circle of radius 1.0
                 * centered at (1.0,1.0), increment pointsFallInCircle
                 */
            }
            counter++;
        }
        return pointsFallInCircle;
    }

    /**
     * Checks whether the given point (xCoord, yCoord) is inside the circle of
     * radius 1.0 centered at the point (1.0, 1.0).
     *
     * @param xCoord
     *            the x coordinate of the point
     * @param yCoord
     *            the y coordinate of the point
     * @return true if the point is inside the circle, false otherwise
     */

    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        boolean result = false;
        /*
         * Check if the points fall in the circle of radius 1 centered at
         * (1.0,1.0)
         */
        if ((xCoord - 1) * (xCoord - 1) + (yCoord - 1) * (yCoord - 1) <= 1) {
            result = true;
        }
        return result;
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
        int pointsFallInCircle = numberOfPointsInCircle(n);
        output.print(
                "n pseudo-random points that fall in the circle of radius 1.0 : "
                        + pointsFallInCircle);
        input.close();
        output.close();
    }
}
