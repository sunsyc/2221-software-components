import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Password Checker.
 *
 * @author Shiny Patel
 *
 */
public final class PasswordChecker {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private PasswordChecker() {
    }

    /**
     * Checks whether the given String satisfies the CSE department criteria for
     * a valid password. Prints an appropriate message to the given output
     * stream.
     *
     * @param s
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String s, SimpleWriter out) {
        final int constant = 6;
        if (s.length() < constant) {
            System.out.println("Password should be atleast 6 characters.");
        }
        if (!containsUpperCaseLetter(s) && !containsLowerCaseLetter(s)
                || !containsLowerCaseLetter(s) && !containsNumbers(s)
                || !containsNumbers(s) && !containsUpperCaseLetter(s)) {
            System.out.println("Password should satisfy atleast two criteria.");
        }

    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String s) {
        boolean result = false;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Checks if the given String contains an lower case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an lower case letter, false otherwise
     */
    private static boolean containsLowerCaseLetter(String s) {
        boolean result = false;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Checks if the given String contains a number.
     *
     * @param s
     *            the String to check
     * @return true if s contains a number, false otherwise
     */
    private static boolean containsNumbers(String s) {
        boolean result = false;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (Character.isDigit(s.charAt(i))) {
                result = true;
            }
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
        out.println("Password criteria: Atleast 6 characters in length \n"
                + "Atleast 1 upper-case letter \n"
                + "Atleast 1 lower-case letter \n" + "Atleast 1 digit.");
        out.print("Enter your password: ");
        String pass = in.nextLine();
        checkPassword(pass, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
