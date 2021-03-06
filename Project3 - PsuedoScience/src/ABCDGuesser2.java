import java.text.DecimalFormat;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 * @author Shiny Patel.
 *
 */
public final class ABCDGuesser2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser2() {
    }

    /**
     * @param difference
     *            the original difference
     *
     * @param newDifference
     *            the new difference
     *
     * @return checks if the newDifference is less than the difference & returns
     *         true if it is
     **/
    private static boolean checkDifference(double difference,
            double newDifference) {
        return (newDifference < difference);
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
        final int percentageConstant = 100;
        out.println("Enter a constant value that you want approximized: ");
        double u = in.nextDouble();
        out.println("Enter the values of x, y, z & w: ");
        double x = in.nextDouble(), y = in.nextDouble(), z = in.nextDouble(),
                w = in.nextDouble();
        /**
         * initializing the array to store the values of constants used to
         * calculate the approximation closest to u.
         **/
        double[] store = { 0, 0, 0, 0 };
        final int indexofStore = 3;
        double[] exponents = { -5, -4, -3, -2, -1, -1 / 2, -1 / 3, -1 / 4, 0,
                1 / 4, 1 / 3, 1 / 2, 1, 2, 3, 4, 5 };
        /**
         * product = x^a * y^b * z^c * w^d & 'answer' to store the final approx.
         * of number
         **/
        double product = 0.0, answer = 0.0;
        /**
         * initializing the initial value of difference as the number itself.
         **/
        double difference = u;
        for (int a = 0; a <= exponents.length - 1; a++) {
            for (int b = 0; b <= exponents.length - 1; b++) {
                for (int c = 0; c <= exponents.length - 1; c++) {
                    for (int d = 0; d <= exponents.length - 1; d++) {
                        /**
                         * de Jager formula
                         **/
                        product = Math.pow(x, exponents[a])
                                * Math.pow(y, exponents[b])
                                * Math.pow(z, exponents[c])
                                * Math.pow(w, exponents[d]);
                        /**
                         * calculate the difference between the value of product
                         * and u for each of the 83521 iterations.
                         **/
                        double newDifference = Math.abs(u - product);
                        if (checkDifference(difference, newDifference)) {
                            /**
                             * if method checkDifference returns true, then
                             * overwrite in difference, the value of
                             * newDifference.
                             **/
                            difference = newDifference;
                            /**
                             * store the value of product in answer for which
                             * the method checkDifference returns true.
                             **/
                            answer = product;
                            /**
                             * store the values of constants used in calculation
                             * in array
                             **/
                            store[0] = exponents[a];
                            store[1] = exponents[b];
                            store[2] = exponents[c];
                            store[indexofStore] = exponents[d];
                        }
                    }
                }
            }
        }
        double error = (Math.abs(u - answer) / u) * percentageConstant;
        out.println("The values of the exponents a,b,c & d are: " + store[0]
                + ", " + store[1] + ", " + store[2] + " & "
                + store[indexofStore]);
        /**
         * to round error to the 100th place of 1%.
         **/
        DecimalFormat hundrethPlace = new DecimalFormat("#.##");
        out.println("Relative error is: "
                + Double.valueOf(hundrethPlace.format(error)) + "%");
        out.println("Approximation is: " + answer);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
