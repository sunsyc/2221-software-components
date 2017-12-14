import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
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
public final class Q3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Q3() {
    }

    /**
     * Reports whether the given tag appears in the given {@code XMLTree}.
     *
     * @param xml
     *            the {@code XMLTree}
     * @param tag
     *            the tag name
     * @return true if the given tag appears in the given {@code XMLTree}, false
     *         otherwise
     * @ensures
     *
     *          <pre>
     * findTag =
     *    [true if the given tag appears in the given
    {@code XMLTree}, false otherwise]
     *          </pre>
     */
    private static boolean findTag(XMLTree xml, String tag) {
        boolean result = false;
        if (xml.isTag()) {
            /**
             * check if label of xml matches tag
             **/
            if (xml.label().equals(tag)) {
                result = true;
            } else {
                for (int i = 0; i < xml.numberOfChildren() && !result; i++) {
                    /**
                     * execute if number of children of xml > 0 and if result is
                     * false
                     **/
                    result = findTag(xml.child(i), tag);
                }
            }
        }
        return result;
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
        XMLTree xml = new XMLTree1("http://news.yahoo.com/rss/");
        //out.print("Enter tag name:");
        // String tag = in.nextLine();
        //xml.display();
        out.print(findTag(xml, "i"));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
