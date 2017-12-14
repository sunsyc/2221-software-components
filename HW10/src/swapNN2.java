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
public final class swapNN2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private swapNN2() {
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
        NaturalNumber tmp = new NaturalNumber2();
        tmp.transferFrom(n1);
        out.println(n1);
        n1.transferFrom(n2);
        out.println(n2);
        n2.transferFrom(tmp);
        out.println(tmp);
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
        NaturalNumber num1 = new NaturalNumber2(0);
        NaturalNumber num2 = new NaturalNumber2(1);
        swapNN(num1, num2);
        out.println(num1 + " " + num2);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
