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
public final class RootMethod {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RootMethod() {
    }

    /**
     * Returns the {@code r}-th root of {@code n}.
     *
     * @param n
     *            the number to which we want to apply the root
     * @param r
     *            the root
     * @return the root of the number
     * @requires n >= 0 and r > 0
     * @ensures root ^ (r) <= n < (root + 1) ^ (r)
     */
    private static int RootMethod(int n, int r) {
        double lowEnough = 0;
        double tooHigh = n + 1;
        double exactRoot = Math.pow(n, (1.0 / r));
        double intervalAverage = (lowEnough + tooHigh) / 2;
        for (;; intervalAverage = (tooHigh + lowEnough) / 2) {
            if (exactRoot < intervalAverage) {
                tooHigh = intervalAverage;
            } else if (exactRoot > intervalAverage) {
                lowEnough = intervalAverage;
            } else {
                break;
            }
        }
        return (int) intervalAverage;
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
        out.println("Enter n & r: ");
        int n = in.nextInteger();
        int r = in.nextInteger();
        out.println(RootMethod(n, r));
        in.close();
        out.close();
    }

}
