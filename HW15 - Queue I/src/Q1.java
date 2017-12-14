import java.util.Comparator;

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
public final class Q1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q1() {
    }

    /**
     * Reports the smallest integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return the smallest integer in the given queue
     * @requires q /= empty_string
     * @ensures
     *
     *          <pre>
     * min is in entries(q) and
     *  for all x: integer
     *      where (x is in entries(q))
     *    (min <= x)
     *          </pre>
     */
    private static int min(Queue<Integer> q) {
        // define comparator
        Comparator<Integer> ci = new IntegerLT();
        // sort array elements in ascending order
        q.sort(ci);
        // the first array element is minimum value
        int min = q.front();
        return min;
    }

    /**
     * Comparator.
     **/
    private static class IntegerLT implements Comparator<Integer> {
        @Override
        public int compare(Integer n1, Integer n2) {
            return n1.compareTo(n2);
        }
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
        int k = 2;
        qi.enqueue(k);
        int l = 1;
        qi.enqueue(l);
        out.println(qi);
        out.println(min(qi));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
