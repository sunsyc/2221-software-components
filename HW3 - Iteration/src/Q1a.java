import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Q1-a.
 *
 * @author Shiny Patel
 *
 */
public final class Q1a {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q1a() {
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
        int x = 0;
        while (x < n) {
            System.out.print(x + " ");
            //print the square of numbers less than n
            x = counter * counter;
            //squaring the number & storing the value in x
            counter++;
            //increment the number
        }
        input.close();
        output.close();
    }

}
