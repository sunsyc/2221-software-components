import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * This program inputs an XML RSS (version 2.0) feed from a given URL and
 * outputs various elements of the feed to the console.
 *
 * @author Shiny Patel
 *
 */
public final class RSSProcessing {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RSSProcessing() {
    }

    /**
     * Finds the first occurrence of the given tag among the children of the
     * given {@code XMLTree} and return its index; returns -1 if not found.
     *
     * @param xml
     *            the {@code XMLTree} to search
     * @param tag
     *            the tag to look for
     * @return the index of the first child of the {@code XMLTree} matching the
     *         given tag or -1 if not found
     * @requires [the label of the root of xml is a tag]
     * @ensures
     *
     *          <pre>
     * getChildElement =
     *  [the index of the first child of the {@code XMLTree} matching the
     *   given tag or -1 if not found]
     *          </pre>
     */
    private static int getChildElement(XMLTree xml, String tag) {
        assert xml != null : "Violation of: xml is not null";
        assert tag != null : "Violation of: tag is not null";
        assert xml.isTag() : "Violation of: the label root of xml is a tag";
        /** let initial index be assumed -1 i.e. j = -1 **/
        int j = -1;
        int i = 0;
        while (i <= xml.numberOfChildren() - 1) {
            /**
             * search for a child among xml's children whose label name matches
             * with tag
             **/
            if (xml.child(i).label().equals(tag)) {
                /** if condition true, j=i **/
                j = i;
                break;
            }
            /**
             * increment to check the if condition for all the children of xml
             **/
            i++;
        }
        /**
         * returns the index of xml's child whose label name matches with tag.
         * If not, returns -1.
         **/
        return j;
    }

    /**
     * Processes one news item and outputs the title, or the description if the
     * title is not present, and the link (if available) with appropriate
     * labels.
     *
     * @param item
     *            the news item
     * @param out
     *            the output stream
     * @requires
     *
     *           <pre>
     * [the label of the root of item is an <item> tag] and out.is_open
     *           </pre>
     *
     * @ensures
     *
     *          <pre>
     * out.content = #out.content * [the title (or description) and
     * link]
     *          </pre>
     */
    private static void processItem(XMLTree item, SimpleWriter out) {
        assert item != null : "Violation of: item is not null";
        assert out != null : "Violation of: out is not null";
        assert item.isTag() && item.label().equals("item") : ""
                + "Violation of: the label root of item is an <item> tag";
        assert out.isOpen() : "Violation of: out.is_open";
        int indexOfTitle = getChildElement(item, "title");
        if (indexOfTitle != -1) {
            out.println("Title: " + item.child(indexOfTitle).child(0));
        } else {
            out.println("No title available");
        }
        int indexOfDescription = getChildElement(item, "description");
        if (indexOfDescription != -1) {
            out.println(
                    "Description: " + item.child(indexOfDescription).child(0));
        } else {
            out.println("No description available");
        }
        int indexOfLink = getChildElement(item, "link");
        if (indexOfLink != -1) {
            out.println("Link: " + item.child(indexOfLink).child(0));
        } else {
            out.println("No link available");
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        /*
         * Open I/O streams.
         */
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Input the source URL.
         */
        XMLTree xml = new XMLTree1("http://news.yahoo.com/rss");
        /*
         * Extract <channel> element.
         */
        xml.display();
        XMLTree channel = xml.child(0);
        for (int indexNumber = 0; indexNumber <= channel.numberOfChildren()
                - 1; indexNumber++) {
            /**
             * if label of channel's child matches with item, pass the index of
             * that child to method call processItem
             **/
            if (channel.child(indexNumber).label().equals("item")) {
                processItem(channel.child(indexNumber), out);
            }
        }
        /*
         * Close I/O streams.
         */
        in.close();
        out.close();
    }

}