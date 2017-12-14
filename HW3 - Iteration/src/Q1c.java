import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Q1-c.
 *
 * @author Shiny Patel
 *
 */
public final class Q1c {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q1c() {
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
        int x = 2;
        final int constant = 2;
        output.print(1 + " ");
        // initializing constant to multiply it with x
        while (x < n) {
            output.print(x + " ");
            x *= constant; // x = x * 2
        }
        input.close();
        output.close();
    }

}
