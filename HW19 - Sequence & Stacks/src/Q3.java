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
public final class Q3<T> extends Sequence1L<T> {

    /**
     * Public constructor so this utility class cannot be instantiated.
     */
    public Q3() {
        super();
    }

    @Override
    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flip() {
        // define variable type same as that of this
        T tmp;
        Sequence<T> s = new Sequence1L<>();
        // if length of this is not zero, remove the 1t element of this
        // and add in s
        if (this.length() != 0) {
            int i = 0;
            tmp = this.remove(i);
            // method call
            this.flip();
            s.add(i, tmp);
        }
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
        //  int tmp;
        //  Sequence<Integer> s = new Sequence1L<>();
        Sequence<Integer> t = new Sequence1L<>();
        t.add(0, 1);
        t.add(1, 2);
        out.println(t);
        t.flip();
        out.print(t);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
