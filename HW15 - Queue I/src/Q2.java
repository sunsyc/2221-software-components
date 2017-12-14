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
public final class Q2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q2() {
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
        // define comparator
        Comparator<Integer> ci = new IntegerLT();
        // sort array elements in ascending order
        q.sort(ci);
        // store min value in min
        int min = q.front();
        // flip the order of elements
        q.flip();
        // store max value in max
        int max = q.front();
        int[] array = { min, max };
        return array;
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
