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
public final class Q3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q3() {
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
        int[] a = { 1, 2, 3, 4, 5, 4, 3, 2, 1, -5, 0, 100 };
        int max = a[0], min = a[0];
        /**
         * initializing the maximum & minimum values with any array element.
         **/
        for (int i = 0; i <= a.length - 1; i++) {
            if (a[i] >= max) {
                max = a[i];
            }
            if (a[i] <= min) {
                min = a[i];
            }
        }
        out.println(max + " " + min);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
