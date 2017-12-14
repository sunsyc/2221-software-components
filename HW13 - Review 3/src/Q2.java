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
     * Reports the value of {@code n} as an {@code int}, when {@code n} is small
     * enough.
     *
     * @param n
     *            the given {@code NaturalNumber}
     * @return the value
     * @requires n <= Integer.MAX_VALUE
     * @ensures toInt = n
     */
    private static int toInt(NaturalNumber n) {
        int result = 0;
        /**
         * divide n by 10, store the integer remainder in variable remainder and
         * the quotient in n
         **/
        int remainder = n.divideBy10();
        /**
         * if n is not zero call method again and store return value in result
         **/
        if (!n.isZero()) {
            result = toInt(n);
        }
        result = result * 10 + remainder;
        // restore value of n
        n.multiplyBy10(remainder);
        return result;
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
        NaturalNumber n = new NaturalNumber2(123456789);
        int no = toInt(n);
        out.print(no);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
