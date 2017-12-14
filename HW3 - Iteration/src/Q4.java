import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Q4.
 *
 * @author Shiny Patel
 *
 */
public final class Q4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q4() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        output.print("Enter the value of n: ");
        int n = input.nextInteger();
        int counter = 0;
        final int constant = 4;
        // initializing constant '4' found in formula of Gregory-Leibniz series
        double pi = 0;
        while (counter < n) {
            double x = (Math.pow((-1), counter) / ((2 * counter) + 1));
            counter++;
            pi += x;
            // pi = pi + x, adding the value of x for each value of (counter < n) in pi
        }
        pi *= constant; // pi = pi * 4
        System.out.print(pi);
        input.close();
        output.close();
    }

}
