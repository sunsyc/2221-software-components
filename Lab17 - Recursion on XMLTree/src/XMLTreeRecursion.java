import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeRecursion {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeRecursion() {
    }

    /**
     * Returns the number of occurrences of the given tag in the given
     * {@code XMLTree}.
     *
     * @param xml
     *            the {@code XMLTree}
     * @param tag
     *            the tag name
     * @return the number of occurrences of the given tag in the given
     *         {@code XMLTree}
     * @ensures
     *
     *          <pre>
     * tagCount =
     *    [the number of occurrences of the given tag in the given
    {@code XMLTree}]
     *          </pre>
     */
    private static int tagCount(XMLTree xml, String tag) {
        int count = 0;
        if (xml.isTag()) {
            for (int k = 0; k < xml.numberOfChildren(); k++) {
                if (xml.child(k).label().equals(tag)) {
                    count++;
                }
                count += tagCount(xml.child(k), tag);
            }
        }
        return count;
    }

    /**
     * Outputs the text nodes in the given {@code XMLTree} on separate lines.
     *
     * @param xml
     *            the {@code XMLTree}
     * @param out
     *            the output stream
     * @updates out.content
     * @requires out.is_open
     * @ensures
     *
     *          <pre>
     * out.content = #out.content * [the text nodes of xml on separate lines]
     *          </pre>
     */
    private static void outputTextNodes(XMLTree xml, SimpleWriter out) {
        if (xml.isTag()) {
            for (int k = 0; k < xml.numberOfChildren(); k++) {
                outputTextNodes(xml.child(k), out);
            }
        } else {
            out.println(xml);
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        XMLTree rss = new XMLTree1("http://news.yahoo.com/rss/");
        //rss.display();
        out.println(tagCount(rss, "item"));
        outputTextNodes(rss, out);
        /*
         * Close input and output streams
         */
        out.close();
    }

}
