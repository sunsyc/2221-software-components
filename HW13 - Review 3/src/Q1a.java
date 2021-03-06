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
public final class Q1a {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q1a() {
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @clears n
     * @ensures productOfDigits1 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits1(NaturalNumber n) {
        NaturalNumber remain = n.newInstance();
        NaturalNumber product = new NaturalNumber2(1);
        int remainder = n.divideBy10();
        /**
         * convert the integer remainder into natural number and store it in
         * remain
         **/
        remain.setFromInt(remainder);
        product.multiply(remain);
        /**
         * if quotient!=0, call method again with the new value of n. multiply
         * the result from each method call with the variable product
         **/
        if (!n.isZero()) {
            product.multiply(productOfDigits1(n));
        } else {
            product.multiply(remain);
        }
        return product;
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
        NaturalNumber n = new NaturalNumber2(12345);
        out.print(productOfDigits1(n));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
