import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Q3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q3() {
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static NaturalNumber sumOfDigits(NaturalNumber n) {
        int remainder = n.divideBy10();
        NaturalNumber remain = new NaturalNumber2(remainder);
        NaturalNumber sum = new NaturalNumber2(0);
        sum.add(remain);
        if (!n.isZero()) {
            sum.add(sumOfDigits(n));
        }
        // int remainder = n.divideBy10();
        //NaturalNumber sum = new NaturalNumber2();
        //sum.setFromInt(remainder);
        //if (!n.isZero()) {
        //  sum.add(sumOfDigits(n));
        //}
        return sum;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        final int no = 1234;
        NaturalNumber n = new NaturalNumber2(no);
        out.print(sumOfDigits(n));
        /*
         * Close input and output streams
         */
        out.close();
    }

}
