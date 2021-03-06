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
public final class Q2g {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q2g() {
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
        int[] a = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
        int i = 0;
        while (i < 5) {
            a[i + 5] = a[i];
            i++;
        }
        for (int j = 0; j < a.length - 1; j++) {
            out.print(a[j] + ", ");
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
