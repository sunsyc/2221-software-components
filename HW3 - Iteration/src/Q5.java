import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Q5.
 *
 * @author Shiny Patel
 *
 */
public final class Q5 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q5() {
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
        output.print("Enter the value of areaBound: ");
        int areaBound = input.nextInteger();
        int sum, n = 1, m = 1;
        /*
         * initialize n = 1 & m = 1 to satisfy the first condition that n & m
         * are at least 1
         */
        while (n * n < areaBound && m * m < areaBound) {
            // check the second & third condition that n^2 & m^2 are less than areaBound
            sum = n * n + m * m;
            // if condition is true, evaluate the expression for sum
            System.out.print(sum + " ");
            n++;
            m++;
        }
        input.close();
        output.close();
    }

}
