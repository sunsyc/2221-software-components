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
public final class Q5 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q5() {
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
        /*
         * Initialize an array of NaturalNumbers with values 1 through 5.
         */
        NaturalNumber[] array = new NaturalNumber[5];
        NaturalNumber count = new NaturalNumber2(1);
        for (int i = 0; i < array.length; i++) {
            NaturalNumber copy = new NaturalNumber2(count);
            array[i] = copy;
            count.increment();
        }
        for (int i = 0; i < array.length; i++) {
            out.print(array[i]);
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
