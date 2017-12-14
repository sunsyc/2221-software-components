import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Shiny Patel.
 *
 */
public final class Hailstone1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone1() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * {@code NaturalNumber}.
     *
     * @param n
     *            the starting natural number
     * @param out
     *            the output stream
     * @updates out.content
     * @requires n > 0 and out.is_open
     * @ensures out.content = #out.content * [the Hailstone series starting with
     *          n]
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {
        out.print(n);
        NaturalNumber copy = new NaturalNumber2(n);
        NaturalNumber divBy2 = new NaturalNumber2(2);
        NaturalNumber mulBy3 = new NaturalNumber2(3);
        NaturalNumber add1 = new NaturalNumber2(1);
        while (copy.compareTo(add1) > 0) {
            NaturalNumber quotient = new NaturalNumber2(copy);
            NaturalNumber remainder = quotient.divide(divBy2);
            if (remainder.isZero()) {
                copy.divide(divBy2);
                out.print(" " + copy);
            } else {
                copy.multiply(mulBy3);
                copy.add(add1);
                out.print(" " + copy);
            }
        }
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
            out.println("Enter number: ");
            int m = in.nextInteger();
            NaturalNumber n = new NaturalNumber2(m);
            generateSeries(n, out);
            out.println(
                    "\nDo you wish to calculate another series. Enter y or n.");
            ans = in.nextLine();
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
