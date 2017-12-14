import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple Q3a program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class Q3d {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private Q3d() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.println("Enter a & b: ");
        int a = in.nextInteger();
        int b = in.nextInteger();
        int sum = 0;
        for (int i = a; i <= b; i++) {
            /**
             * to calculate the sum of all odd numbers between a and b
             * (inclusive), where a and b are integer variables with a less than
             * b
             **/

            if (i % 2 == 0) {
                i++;
                out.println(i);
                sum += i;
            } else {
                sum += i;
            }
        }
        out.println(+sum);
        in.close();
        out.close();
    }

}
