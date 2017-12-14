import java.util.Comparator;

import components.queue.Queue;
import components.queue.Queue1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Layered implementations of secondary method {@code sort} for {@code Queue
 * <String>}.
 */
public final class Queue1LSort1 extends Queue1L<String> {

    /**
     * No-argument constructor.
     */
    public Queue1LSort1() {
        super();
    }

    /**
     * Removes and returns the minimum value from {@code q} according to the
     * ordering provided by the {@code compare} method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to compare entries
     * @return the minimum value from {@code q}
     * @updates q
     * @requires
     *
     *           <pre>
     * q /= empty_string  and
     *  [the relation computed by order.compare is a total preorder]
     *           </pre>
     *
     * @ensures
     *
     *          <pre>
     * (q * <removeMin>) is permutation of #q  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     *          </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {
        assert q != null : "Violation of: q is not null";
        assert order != null : "Violation of: order is not null";
        SimpleWriter out = new SimpleWriter1L();
        // out.println("original" + q.length());
        String min = q.dequeue();
        // out.println("1st deq" + q.length());
        for (int i = 0; i < q.length(); i++) {
            String s = q.dequeue();
            // out.println("2nd de" + q.length());
            if (order.compare(s, min) < 0) {
                q.enqueue(min);
                //   out.println("if" + q.length());
                min = s;
            } else {
                q.enqueue(s);
                // out.println("else" + q.length());
            }
        }
        return min;
    }

    @Override
    public void sort(Comparator<String> order) {
        assert order != null : "Violation of: order is not null";
        Queue<String> tmp = new Queue1L<>();
        tmp.transferFrom(this);
        while (tmp.length() != 0) {
            String s = removeMin(tmp, order);
            this.enqueue(s);
        }
    }

}