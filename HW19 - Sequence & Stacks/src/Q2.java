import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * @param <T>
 *            <T> is data type.
 *
 * @author Put your name here
 *
 */
public final class Q2<T> extends Sequence1L<T> {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q2() {
        super();
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    @Override
    public void flip() {
        // define variable type same as that of this
        T tmp;
        Sequence<T> s = new Sequence1L<>();
        // while length of this is not zero, remove the 1t element of this, each
        // iteration and add in s
        while (this.length() != 0) {
            int i = 0;
            tmp = this.remove(i);
            s.add(i, tmp);
        }
        // transfer reversed value of this from s in this
        this.transferFrom(s);
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
        // int tmp;
        //   Sequence<Integer> s = new Sequence1L<>();
        Sequence<Integer> t = new Sequence1L<>();
        t.add(0, 1);
        t.add(1, 2);
        out.println(t);
        t.flip();
        // while (t.length() != 0) {
        //   int i = 0;
        // tmp = t.remove(i);
        // s.add(i, tmp);
        // }
        //t.transferFrom(s);
        out.println(t);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
