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
public final class Q5 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q5() {
    }

    /**
     * Checks whether a {@code String} is a palindrome.
     *
     * @param s
     *            {@code String} to be checked
     * @return true if {@code s} is a palindrome, false otherwise
     * @ensures isPalindrome = (s = rev(s))
     */
    private static boolean isPalindrome(String s) {
        boolean result = false;
        if ((null == s) || (s.length() <= 1)) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            result = isPalindrome(s.substring(1, s.length() - 1));
        }
        return result;
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
        String s = "ee";
        out.print(isPalindrome(s));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
