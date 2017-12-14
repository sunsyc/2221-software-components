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
public final class square {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private square() {
    }

    /**
     * Squares a given {@code NaturalNumber}.
     *
     * @param n
     *            the number to square
     * @updates n
     * @ensures n = #n * #n
     */
    private static void square(NaturalNumber n) {
        NaturalNumber tmp = new NaturalNumber2();
        tmp.copyFrom(n);
        n.multiply(tmp); //n*=tmp
        // or use n.power(2);
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
        NaturalNumber num = new NaturalNumber2(4);
        square(num);
        out.println(num);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
