import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Q1-b.
 *
 * @author Shiny Patel
 *
 */
public final class Q1b {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q1b() {
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
        int counter = 1;
        final int constant = 10;
        // initializing constant to check if number is divisible by 10
        while (counter < n) {
            // checks the first condition i.e. if number is less than n
            if (counter % constant == 0) {
                // checks if number is divisible by 10
                System.out.print(counter + " ");
            }
            counter++;
        }
        input.close();
        output.close();
    }

}
