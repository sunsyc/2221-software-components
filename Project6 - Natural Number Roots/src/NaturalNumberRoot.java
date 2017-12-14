import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program with implementation of {@code NaturalNumber} secondary operation
 * {@code root} implemented as static method.
 *
 * @author Shiny Patel
 *
 */
public final class NaturalNumberRoot {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private NaturalNumberRoot() {
    }

    /**
     * Updates {@code n} to the {@code r}-th root of its incoming value.
     *
     * @param n
     *            the number whose root to compute
     * @param r
     *            root
     * @updates n
     * @requires r >= 2
     * @ensures n ^ (r) <= #n < (n + 1) ^ (r)
     */
    public static void root(NaturalNumber n, int r) {
        assert n != null : "Violation of: n is  not null";
        assert r >= 2 : "Violation of: r >= 2";
        /**
         * create the lower limit of interval, lowEnough
         **/
        NaturalNumber lowEnough = new NaturalNumber2(0);
        /**
         * create the upper limit of interval, tooHigh
         **/
        NaturalNumber tooHigh = new NaturalNumber2(n);
        /**
         * create object exactRoot to find the rth root of n
         **/
        NaturalNumber exactRoot = new NaturalNumber2(n);
        /**
         * create constants one and two to use for calculations
         **/
        final NaturalNumber one = new NaturalNumber2(1);
        final NaturalNumber two = new NaturalNumber2(2);
        /**
         * add 1 to the upper limit of interval
         **/
        tooHigh.add(one);
        /**
         * find rth root of n
         **/
        exactRoot.root(r);
        /**
         * create intervalAverage to find average of lower and upper limits of
         * interval
         **/
        NaturalNumber intervalAverage = new NaturalNumber2(lowEnough);
        intervalAverage.add(tooHigh);
        intervalAverage.divide(two);
        for (;;) {
            /**
             * if rth root of n is equal to intervalAverage exit the loop
             **/
            if (exactRoot.compareTo(intervalAverage) == 0) {
                break;
            } else if (exactRoot.compareTo(intervalAverage) < 0) {
                /**
                 * if rth root of n is less than intervalAverage execute this
                 * block
                 **/
                tooHigh.copyFrom(intervalAverage);
                intervalAverage.clear();
                /**
                 * clear value of intervalAverage and set it to zero
                 **/
                intervalAverage.add(tooHigh);
                intervalAverage.add(lowEnough);
                intervalAverage.divide(two);
            } else {
                /**
                 * if rth root of n is greater than intervalAverage execute this
                 * block
                 **/
                lowEnough.copyFrom(intervalAverage);
                intervalAverage.clear();
                intervalAverage.add(tooHigh);
                intervalAverage.add(lowEnough);
                intervalAverage.divide(two);
            }
        }
        n.copyFrom(intervalAverage);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        final int[] numbers = { 0, 1, 13, 1024, 189943527, 0, 1, 13, 4096,
                189943527, 0, 1, 13, 1024, 189943527, 82, 82, 82, 82, 82, 9, 27,
                81, 243, 143489073 };
        final int[] roots = { 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 15, 15, 15, 15, 15,
                2, 3, 4, 5, 15, 2, 3, 4, 5, 15 };
        final int[] results = { 0, 1, 3, 32, 13782, 0, 1, 2, 16, 574, 0, 1, 1,
                1, 3, 9, 4, 3, 2, 1, 3, 3, 3, 3, 3 };
        for (int i = 0; i < numbers.length; i++) {
            NaturalNumber n = new NaturalNumber2(numbers[i]);
            NaturalNumber r = new NaturalNumber2(results[i]);
            root(n, roots[i]);
            if (n.equals(r)) {
                out.println("Test " + (i + 1) + " passed: root(" + numbers[i]
                        + ", " + roots[i] + ") = " + results[i]);
            } else {
                out.println("*** Test " + (i + 1) + " failed: root("
                        + numbers[i] + ", " + roots[i] + ") expected <"
                        + results[i] + "> but was <" + n + ">");
            }
        }
        out.close();
    }
}
