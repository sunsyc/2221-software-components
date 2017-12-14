import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
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
public final class Q1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q1() {
    }

    /**
     * Returns the number of digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to count
     * @return the number of digits of {@code n}
     * @ensures numberOfDigits = [number of digits of n]
     */
    private static int numberOfDigits(NaturalNumber n) {
        int count = 0;
        n.divideBy10();
        if (!n.isZero()) {
            count += numberOfDigits(n);
        }
        count++;
        return count;
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
        final int no = 1234;
        NaturalNumber n = new NaturalNumber2(no);
        out.print(numberOfDigits(n));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
