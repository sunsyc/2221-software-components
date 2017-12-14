import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple Q3a program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class Q3f {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private Q3f() {
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
        out.println("Enter number: ");
        String number = in.nextLine();
        int sum = 0;
        for (int i = 0; i <= number.length() - 1; i += 2) {
            /**
             * to calculate the sum of all digits at odd positions
             * (left-to-right starting at 1 as the left-most digit) of a numeric
             * input
             **/
            sum += Character.getNumericValue((number.charAt(i)));
            /**
             * character.getNumericValue converts the character at
             * number.charAt(i) to integer type
             **/
        }
        out.println(+sum);
        in.close();
        out.close();
    }

}
