import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Count the change with the least no. of coins.
 *
 * @author Shiny Patel
 *
 */
public final class CoinCount {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinCount() {
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
        out.print("Enter the change: ");
        int change = in.nextInteger();
        int[] coinCount = new int[6];
        int totalNumberOfCoins = 0;
        for (int i = 0; i < coinCount.length; i++) {
            if (i == 0) {
                coinCount[i] = change / 100;
                change -= (coinCount[i] * 100);
                out.println("No of dollar coins " + coinCount[i]);
            } else if (i == 1) {
                coinCount[i] = change / 50;
                change -= (coinCount[i] * 50);
                out.println("No of half-dollar coins: " + coinCount[i]);
            } else if (i == 2) {
                coinCount[i] = change / 25;
                change -= (coinCount[i] * 25);
                out.println("No of quarters: " + coinCount[i]);
            } else if (i == 3) {
                coinCount[i] = change / 10;
                change -= (coinCount[i] * 10);
                out.println("No of dimes: " + coinCount[i]);
            } else if (i == 4) {
                coinCount[i] = change / 5;
                change -= (coinCount[i] * 5);
                out.println("No of nickels: " + coinCount[i]);
            } else {
                coinCount[i] = change;
                out.println("No of pennies: " + coinCount[i]);
            }
            totalNumberOfCoins += coinCount[i];
        }
        out.println("Total number of coins: " + totalNumberOfCoins);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
