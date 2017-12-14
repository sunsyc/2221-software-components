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
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error given by
     * user.
     *
     * @param x
     *            number greater than or equal to zero to compute square root of
     * @param error
     *            user entered value of error
     * @return estimate of square root
     */
    private static double sqrt(double x, double error) {
        double r = x;
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
        out.println("Enter the value of error: ");
        double error = in.nextDouble();
        out.println("Calculate square-root? Enter y or n: ");
        String answer = in.nextLine();
        /*
         * initializing variable 'condition' for do-while loop
         */
        double condition = 0;
        /*
         * do-while loop to repeatedly ask user to enter a new number for
         * calculating it's square-root
         */
        do {
            /*
             * If the response is "y", then the program will proceed; if it is
             * anything else, then the program will quit.
             */
            if (answer.equals("y")) {
                out.println(
                        "Enter a positive number greater than or equal to zero: ");
                double number = in.nextDouble();
                condition = number;
                if (number >= 0) {
                    /* method call */
                    out.println("Square-root is: " + sqrt(number, error));
                } else {
                    out.println("Invalid number.");
                }
            }
            /*
             * If number is not greater than or equal to zero the program will
             * terminate
             */
        } while (condition >= 0);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
