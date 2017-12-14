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
public final class Q1a {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q1a() {
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
        out.println("Enter a string: ");
        String upper = in.nextLine();
        for (int i = 0; i <= upper.length() - 1; i++) {
            if (Character.isUpperCase(upper.charAt(i))) {
                /**
                 * checks if the character in string is an uppercase alphabet
                 * and prints it, if it is
                 **/
                out.print(upper.charAt(i));
            }
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
