import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple Q3a program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class Q3b {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private Q3b() {
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
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            /**
             * to calculate the sum of all squares between 1 and 100
             **/
            sum += (i * i);
        }
        out.println(+sum);
        out.close();
    }

}
