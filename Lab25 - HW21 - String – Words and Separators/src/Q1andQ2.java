import components.set.Set;
import components.set.Set1L;
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
public final class Q1andQ2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q1andQ2() {
    }

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param strSet
     *            the {@code Set} to be replaced
     * @replaces strSet
     * @ensures strSet = entries(str)
     */
    private static void generateElements(String str, Set<Character> strSet) {
        for (int i = 0; i < str.length(); i++) {
            strSet.add(str.charAt(i));
        }
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures
     *
     *          <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     *          </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        // initialize empty string
        String s = "";
        int i = position;
        // run if character at i is not in separator set
        while (i < text.length() && !separators.contains(text.charAt(i))) {
            i++;
        }
        s = text.substring(position, i);
        // run only if s is not empty and run till characters are in separator set
        if (s.equals("")) {
            while (i < text.length() && separators.contains(text.charAt(i))) {
                i++;
            }
            s = text.substring(position, i);
        }
        return s;
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
        String str = " \t, ";
        Set<Character> strSet = new Set1L<>();
        generateElements(str, strSet);
        out.println(str);
        out.println(strSet);
        int position = 2;
        // Set<Character> sep = new Set1L<>();
        // sep.add(' ');
        // sep.add(',');
        // out.println(nextWordOrSeparator(str, position, sep));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
