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
public final class swapNN1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private swapNN1() {
    }

    /**
     * Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNN(NaturalNumber n1, NaturalNumber n2) {
        SimpleWriter out = new SimpleWriter1L();
        NaturalNumber tmp = n1.newInstance();
        tmp.copyFrom(n1);
        out.println(n1);
        n1.copyFrom(n2);
        n2.copyFrom(tmp);
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
        NaturalNumber num1 = new NaturalNumber2(4);
        NaturalNumber num2 = new NaturalNumber2(13);
        swapNN(num1, num2);
        out.println(num1 + " " + num2);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
