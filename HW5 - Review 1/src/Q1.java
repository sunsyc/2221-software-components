import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Q1.
 *
 * @author Shiny
 */
public final class Q1 {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private Q1() {
        // no code needed here
    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {
        String s = in.nextLine();
        /** reads the string from the user **/
        int positiveInt = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            /** checks if each character of the string is a number **/
            if (Character.isDigit(s.charAt(i))) {
                int n = Integer.parseInt(s);
                /** converts the string to number **/
                if (n > 0) {
                    /** checks if number is positive **/
                    positiveInt = n;
                }
            }
        }
        return positiveInt;
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
        out.println("Enter n: ");
        out.print((getPositiveInteger(in, out)));
        in.close();
        out.close();
    }

}
