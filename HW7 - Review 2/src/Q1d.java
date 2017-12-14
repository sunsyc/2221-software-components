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
public final class Q1d {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q1d() {
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
        int count = 0;
        for (int i = 0; i <= upper.length() - 1; i++) {
            if (upper.charAt(i) == 'a' || upper.charAt(i) == 'e'
                    || upper.charAt(i) == 'i' || upper.charAt(i) == 'o'
                    || upper.charAt(i) == 'u' || upper.charAt(i) == 'A'
                    || upper.charAt(i) == 'E' || upper.charAt(i) == 'I'
                    || upper.charAt(i) == 'O' || upper.charAt(i) == 'U') {
                /**
                 * counts and prints the number of vowels in the String
                 **/
                count++;
            }
        }
        out.print(count);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
