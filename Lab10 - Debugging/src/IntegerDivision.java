import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class IntegerDivision {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private IntegerDivision() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        final double microsPerDay = 24 * 60 * 60 * 1000 * 1000;
        final double millisPerDay = 24 * 60 * 60 * 1000;
        out.println(microsPerDay / millisPerDay);
        out.close();
    }
}