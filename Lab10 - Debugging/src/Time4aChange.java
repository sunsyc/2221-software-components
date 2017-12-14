import java.math.BigDecimal;

import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Time4aChange {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Time4aChange() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        BigDecimal x = new BigDecimal(456.0);
        double i = 100.0;
        double j = 4.56;
        BigDecimal y = new BigDecimal(i * j);
        if (y != x) {
            out.println("equal");
            out.print(y);
        } else {
            out.println("not equal");
        }
        out.close();
    }
}