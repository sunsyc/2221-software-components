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
public final class Q4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q4() {
    }

    /**
     * Divides {@code n} by 2.
     *
     * @param n
     *            {@code NaturalNumber} to be divided
     * @updates n
     * @ensures 2 * n <= #n < 2 * (n + 1)
     */
    private static void divideBy2(NaturalNumber n) {
        final NaturalNumber two = new NaturalNumber2(2);
        SimpleWriter out = new SimpleWriter1L();
        int remainder = n.divideBy10();
        remainder /= 2;
        n.multiplyBy10(0);
        n.divide(two);
        NaturalNumber remain = new NaturalNumber2(remainder);
        remain.multiplyBy10(0);
        remain.add(n);
        out.print(remain);
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
        divideBy2(n);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
