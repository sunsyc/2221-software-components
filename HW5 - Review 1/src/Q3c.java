import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple Q3a program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class Q3c {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private Q3c() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        for (int i = 0; i <= 20; i++) {
            /**
             * to calculate all powers of 2 from 2^0 up to 2^20
             **/
            out.println(Math.pow(2, i));
        }
        out.close();
    }

}
