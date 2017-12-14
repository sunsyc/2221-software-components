import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 * @param <T>
 *            <T> is data type.
 *
 * @author Put your name here
 *
 */
public final class Q1<T> extends Stack1L<T> {

    /**
     * Public constructor so this utility class cannot be instantiated.
     */
    public Q1() {
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
        Stack<T> s = new Stack1L<>();
        // while length of this is not zero, remove the 1t element of this, each
        // iteration and add in s
        while (this.length() != 0) {
            tmp = this.pop();
            s.push(tmp);
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
        // Stack<Integer> s = new Stack1L<>();
        Stack<Integer> t = new Stack1L<>();
        t.push(1);
        t.push(2);
        out.println(t);
        t.flip();
        //  while (t.length() != 0) {
        //    tmp = t.pop();
        //  s.push(tmp);
        // }
        //  t.transferFrom(s);
        out.println(t);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
