import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Create a glossary of input file.
 *
 * @author Shiny Patel
 *
 */
public final class Glossary {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Glossary() {
    }

    /**
     * Separates each term and its definition and stores the pair of them in Map
     * 'pairs'. Also, stores all the terms in queue 'random' to sort in
     * lexicographical order.
     *
     * @param input
     *            the input stream
     * @param pairs
     *            the map to store pairs of terms and their definition
     * @param random
     *            to store all the terms for sorting them in lexicographical
     *            order
     *
     * @updates input
     * @updates pairs
     * @updates random
     * @requires
     *
     *           <pre>
     * input.is_open and
     * [input.content begins with a word
     *  (something defined in pairs) on the first line, followed
     *  by its definition (something defined in pairs)
     *  of one or more lines, followed by an empty line and
     *  key is not in DOMAIN(this) for map
     *           </pre>
     *
     * @ensures
     *
     *          <pre>
     *          input.is_open
     *          </pre>
     */
    public static void getOneTerm(SimpleReader input, Map<String, String> pairs,
            Queue<String> random) {
        assert input != null : "Violation of: input is not null";
        assert input.isOpen() : "Violation of: input.is_open";
        // read 1st line which is a term
        String term = input.nextLine();
        // read next line which is its definition
        String definition = input.nextLine();
        // read line after that
        // if that line is not empty, concatenate that line to the end of previous line.
        String temp = input.nextLine();
        while (!temp.equals("")) {
            definition = definition.concat(temp);
            // continue reading till empty line is encountered
            temp = input.nextLine();
        }
        // add each term and its definition in map and all the terms in queue.
        if (!pairs.hasKey(term)) {
            pairs.add(term, definition);
        }
        random.enqueue(term);
    }

    /**
     * Compare {@code String}s in lexicographic order.
     */
    private static class StringLT implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * print a list of terms in lexicographical order on index.html.
     *
     * @param output
     *            the output stream. Prints in index.html
     * @param pairs
     *            contains pairs of terms and their definition
     * @param random
     *            contains all the terms in random order
     * @param outputName
     *            the name of output folder specified by user
     *
     * @updates output
     * @requires
     *
     *           <pre>
     *           output.is_open and pairs and random are not empty
     *           </pre>
     *
     * @ensures
     *
     *          <pre>
     *          output.is_open
     *          </pre>
     */
    public static void printInOrder(Queue<String> random,
            Map<String, String> pairs, SimpleWriter output, String outputName) {
        assert output != null : "Violation of: output is not null";
        assert output.isOpen() : "Violation of: output.is_open";
        assert pairs != null : "Violation of: pairs is not null";
        assert random != null : "Violation of: random is not null";
        // define comparator for sorting terms.
        Comparator<String> lexo = new StringLT();
        // sorts all the terms in random
        random.sort(lexo);
        // for each terms in random, find its corresponding definition from map 'pairs'
        for (String term : random) {
            String definition = pairs.value(term);
            // define out to print in 'term.html in specified output folder'
            SimpleWriter out = new SimpleWriter1L(
                    outputName.concat("/".concat(term.concat(".html"))));
            // method call to check for any terms in definition itself
            printDefLinks(out, definition, term, random);
            // print a list terms on index.html
            output.println("<li><a href=\"" + term.concat(".html") + "\">"
                    + term + "</a></li>");
        }
    }

    /**
     * check the definition of each term for words that have their own
     * definition and if they do, print them with links.
     *
     * @param out
     *            the output stream. Prints in corresponding term.html
     * @param random
     *            contains all the terms in random order
     * @param definition
     *            the definition of the term
     * @param term
     *            the term whose definition is printed
     *
     * @updates out
     * @requires
     *
     *           <pre>
     *           out.is_open
     *           </pre>
     *
     * @ensures
     *
     *          <pre>
     *          out.is_open
     *          </pre>
     */
    private static void printDefLinks(SimpleWriter out, String definition,
            String term, Queue<String> random) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";
        assert random != null : "Violation of: random is not null";
        assert definition != null : "Violation of: definition is not null";
        assert term != null : "Violation of: term is not null";
        // print the term in red, bold, italic font on term.html
        out.println("<html><head><title>" + term
                + "</title></head><body><h2><b><i><font color=red>" + term
                + "</font></i></b></h2>");
        // define and add separators to separator set
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        separators.add(',');
        // define queue defWords to store individual words in the string of definition
        Queue<String> defWords = new Queue1L<>();
        // start separation of words from definition from index 0
        int position = 0;
        while (position < definition.length()) {
            // method call to get words
            String words = nextWord(definition, position, separators);
            // add the words returned by method in defWords in the same order as received
            defWords.enqueue(words);
            position += words.length();
        }
        // check for each word in definition
        for (String word : defWords) {
            boolean check = false;
            // compare each word in definition with list of terms in random
            for (String def : random) {
                // if any word matches any term
                if (def.equals(word)) {
                    // print that word with link to its own definition
                    out.print("<a href=\"" + def.concat(".html") + "\">" + def
                            + "</a>");
                    check = true;
                }
            }
            // execute if word does not have its own definition
            if (!check) {
                out.print(word + " ");
            }
        }
        out.println("</body></html>");
        out.close();
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
    public static String nextWord(String text, int position,
            Set<Character> separators) {
        assert text != null : "Violation of: text is not null";
        assert separators != null : "Violation of: separators is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";
        int i = position;
        // run if character at i is not in separator set
        while (i < text.length() && !separators.contains(text.charAt(i))) {
            i++;
        }
        String s = text.substring(position, i);
        // run if s is not empty
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
        out.println("Enter the name of input file: ");
        String inputFile = in.nextLine();
        SimpleReader input = new SimpleReader1L(inputFile);
        out.println("Enter the name of output folder name: ");
        String outputName = in.nextLine();
        SimpleWriter output = new SimpleWriter1L(
                outputName.concat("/index.html"));
        // print header
        output.println(
                "<html><head><title>Glossary</title><h2>Glossary</h2></head>");
        output.println("<body><h3>Index</h3>");
        output.println("<ul>");
        // to store terms and their corresponding definitions
        Map<String, String> pairs = new Map1L<String, String>();
        // queue to store all terms in index.html to sort them in lexicographical order
        Queue<String> random = new Queue1L<>();
        // get each term of input file.
        // store term and its corresponding definition in pairs
        // store all terms in random
        while (!input.atEOS()) {
            getOneTerm(input, pairs, random);
        }
        // call method to print terms in input file in lexicographical order in index.html
        printInOrder(random, pairs, output, outputName);
        // close html tags
        output.println("</ul></body></html>");
        /*
         * Close input and output streams
         */
        input.close();
        output.close();
        in.close();
        out.close();
    }
}
