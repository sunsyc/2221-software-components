import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @param <T>
 *            T is data type
 *
 * @author Shiny Patel.
 *
 */
public final class Q4<T> extends Queue1L<T> {

    /**
     * Public constructor so this utility class cannot be instantiated.
     */
    public Q4() {
        super();
    }

    @Override
    /**
     *
     * Reverses ("flips") {@code this}.
     *
     * @param q
     *            the queue to be flipped
     * @updates this
     * @ensures this = rev(#this)
     */
    public static void flip(Queue<T> q) {
        //initialize integer array of queue length
        int[] array = new int[q.length() - 1];
        // remove each element of queue and store in array[i]
        for (int i = 0; i < q.length(); i++) {
            array[i] = q.dequeue();
        }
        // add each array element starting from last index in queue
        for (int i = q.length() - 1; i >= 0; i--) {
            array[i] = q.enqueue();
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
        Queue<Integer> q = new Queue1L<>();
        int i = 1;
        q.enqueue(i);
        int j = 2;
        q.enqueue(j);
        int k = 3;
        q.enqueue(k);
        this.flip(q);
        out.print(q);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
