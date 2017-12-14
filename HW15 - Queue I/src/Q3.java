import components.queue.Queue;
import components.queue.Queue1L;
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
public final class Q3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q3() {
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures
     *
     *          <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     *  for all x: integer
     *      where (x in in entries(q))
     *    (minAndMax[0] <= x <= minAndMax[1])
     *          </pre>
     */
    private static int[] minAndMax(Queue<Integer> q) {
        // initialize first array element as min
        int min = q.front();
        int max = 0;
        for (int i = 0; i < q.length(); i++) {
            // take first element from array
            int n1 = q.dequeue();
            int n2 = q.dequeue();
            // compare 2 elements first with each other than with max and min
            if (n1 > n2) {
                if (min > n2) {
                    min = n2;
                }
                if (n1 > max) {
                    max = n1;
                }
            } else if (n2 > n1) {
                if (min > n1) {
                    min = n1;
                }
                if (n2 > max) {
                    max = n2;
                }
            } else {
                if (min > n1) {
                    min = n1;
                }
                if (n1 > max) {
                    max = n1;
                }
            }
        }
        // store max and min in array
        int[] array = { min, max };
        return array;
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
        Queue<Integer> qi = new Queue1L<>();
        int k = 21;
        qi.enqueue(k);
        int l = 21;
        qi.enqueue(l);
        out.println(qi);
        int[] array = minAndMax(qi);
        for (int i = 0; i < array.length; i++) {
            out.print(array[i] + " ");
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
