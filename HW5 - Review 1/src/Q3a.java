import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple Q3a program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class Q3a {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private Q3a() {
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
        for (int i = 2; i <= 100; i += 2) {
            /**
             * to calculate the sum of all even numbers between 2 and 100
             **/
            sum += i;
        }
        out.println(+sum);
        out.close();
    }

}
