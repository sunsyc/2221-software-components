import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class HailstoneSeries {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HailstoneSeries() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        out.print(n + " ");
        int count = 0, max = n;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (3 * n) + 1;
            }
            if (n > max) {
                max = n;
            }
            out.print(n + " ");
            count++;
        }
        out.println("\nLength is: " + (count + 1) + "\nMax is: " + max);
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
        String ans = "y";
        while (ans.contains("y")) {
            out.print("Enter number: ");
            int n = in.nextInteger();
            generateSeries(n, out);
            out.println(
                    "Do you wish to calculate another series. Enter y or n.");
            ans = in.nextLine();
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
