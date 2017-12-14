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
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        boolean isOrdered = true;
        int[] a = { 0, -9 };
        for (int i = 0; i <= a.length - 2; i++) {
            /**
             * enters the conditional block only if isOrdered is true
             **/
            if (a[i] < a[i + 1] && isOrdered == true) {
                /**
                 * checks if array element is less than the next array element.
                 * If condition is true, exit the conditional block.
                 **/
            } else {
                /**
                 * if condition is false, isOrdered=false
                 **/
                isOrdered = false;
            }
        }
        out.println(isOrdered);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
