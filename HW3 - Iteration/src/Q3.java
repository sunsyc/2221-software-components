/**
 * Q3.
 *
 * @author Shiny Patel
 */
public final class Q3 {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private Q3() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        int s = 0, i = 1;
        final int constant = 10;
        // initializing constant to check if i<=10
        while (i <= constant) {
            s += i;
            i++;
            System.out.print(s + " ");
        }
    }

}
