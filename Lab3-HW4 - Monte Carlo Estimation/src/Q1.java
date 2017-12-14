import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 * @author Shiny Patel.
 *
 */
abstract class Q1 {
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
         * Ask user for the x & y coordinate of the point.
         */
        output.print("x coordinate of the point: ");
        double x = input.nextDouble();
        output.print("y coordinate of the point: ");
        double y = input.nextDouble();
        boolean result = pointIsInCircle(x, y);
        output.print("Result: " + result);
        input.close();
        output.close();
    }
}
