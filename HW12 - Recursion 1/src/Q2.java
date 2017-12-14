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
public final class Q2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q2() {
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static int sumOfDigits(NaturalNumber n) {
        int remainder = n.divideBy10();
        if (!n.isZero()) {
            remainder += sumOfDigits(n);
        }
        return remainder;
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
        out.print(sumOfDigits(n));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
