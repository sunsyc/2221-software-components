import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Calculate square-root of a number greater than or equal to zero, using Newton
 * Iteration.
 *
 * @author Shiny Patel.
 *
 */
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            number greater than or equal to zero to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double r = x;
        final double error = 0.0001;
        while ((Math.abs(r * r - x) / x) > error * error) {
            r = (r + x / r) / 2;
        }
        return r;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        String answer;
        /*
         * do-while loop to repeatedly ask user for calculating square-root
         */
        do {
            out.println("Calculate square-root? Enter y or n: ");
            answer = in.nextLine();
            /*
             * If the response is "y", then the program will proceed; if it is
             * anything else, then the program will quit.
             */
            if (answer.equals("y")) {
                out.println(
                        "Enter a positive number greater than or equal to zero: ");
                double number = in.nextDouble();
                if (number >= 0) {
                    /* method call */
                    out.println("Square-root is: " + sqrt(number));
                } else {
                    out.println("Invalid number.");
                }
            }
        } while (answer.equals("y"));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
