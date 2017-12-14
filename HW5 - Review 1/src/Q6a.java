import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Q.6 a.
 *
 * @author Shiny Patel
 *
 */
public final class Q6a {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q6a() {
    }

    /**
     *
     * @param x
     *            integer
     * @param y
     *            integer
     * @param z
     *            integer
     * @return returning true if the arguments are all same
     */
    private static boolean allTheSame(int x, int y, int z) {
        return x == y && y == z;
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
        out.println("Enter x, y & z: ");
        int x = in.nextInteger();
        int y = in.nextInteger();
        int z = in.nextInteger();
        out.println(allTheSame(x, y, z));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
