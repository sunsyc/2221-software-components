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
public final class Q1e {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q1e() {
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
            if (upper.charAt(i) == 'a' || upper.charAt(i) == 'e'
                    || upper.charAt(i) == 'i' || upper.charAt(i) == 'o'
                    || upper.charAt(i) == 'u' || upper.charAt(i) == 'A'
                    || upper.charAt(i) == 'E' || upper.charAt(i) == 'I'
                    || upper.charAt(i) == 'O' || upper.charAt(i) == 'U') {
                /**
                 * prints the positions of all vowels in the String
                 **/
                out.print(i + 1 + " ");
            }
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
