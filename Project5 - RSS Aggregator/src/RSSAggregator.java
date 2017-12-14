import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to convert an XML RSS (version 2.0) feed from a given URL into the
 * corresponding HTML output file.
 *
 * @author Shiny Patel.
 *
 */
public final class RSSAggregator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RSSAggregator() {
    }

    /**
     * Outputs the "opening" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * <html> <head> <title>the channel tag title as the page
     * title</title> </head> <body>
     * <h1>the page title inside a link to the <channel> link</h1>
     * <p>
     * the channel description
     * </p>
     * <table>
     * <tr>
     * <th>Date</th>
     * <th>Source</th>
     * <th>News</th>
     * </tr>
     *
     * @param channel
     *            the channel element XMLTree
     * @param out
     *            the output stream
     * @updates out.content
     * @requires [the root of channel is a <channel> tag] and out.is_open
     * @ensures out.content = #out.content * [the HTML "opening" tags]
     */
    private static void outputHeader(XMLTree channel, SimpleWriter out) {
        assert channel != null : "Violation of: channel is not null";
        assert out != null : "Violation of: out is not null";
        assert channel.isTag() && channel.label().equals("channel") : ""
                + "Violation of: the label root of channel is a <channel> tag";
        assert out.isOpen() : "Violation of: out.is_open";
        /**
         * method call to search for a child named title among channel's
         * children
         **/
        int titleCheck = getChildElement(channel, "title");
        if (titleCheck != -1) {
            out.println(
                    "<html><head><title>" + channel.child(titleCheck).child(0)
                            + "</title></head><body>");
        } else {
            out.println("Empty Title");
        }
        /**
         * method call to search for children named title & link among channel's
         * children
         **/
        out.println(
                "<h1><a href=\""
                        + channel.child(getChildElement(channel, "link")).child(
                                0)
                        + "\">"
                        + channel.child(getChildElement(channel, "title"))
                                .child(0)
                        + "</a></h1>");
        /**
         * method call to search for a child named description among channel's
         * children
         */
        int descriptionCheck = getChildElement(channel, "description");
        /**
         * check if the number of children of description tag is not zero
         **/
        if (descriptionCheck != -1
                && channel.child(descriptionCheck).numberOfChildren() != 0) {
            out.println(
                    "<p>" + channel.child(descriptionCheck).child(0) + "</p>");
        } else {
            out.println("No description");
        }
        /**
         * print the first row of table with table headings to the file
         */
        out.println(
                "<table border=\"1\"><tr><th>Date</th><th>Source</th><th>News</th></tr>");
    }

    /**
     * for loop to count number of channel's children with tag label 'item' and
     * call method processItem for each of them.
     *
     * @param channel
     *            the channel element XMLTree
     *
     * @param out
     *            the output stream
     **/
    private static void findLabel(XMLTree channel, SimpleWriter out) {
        for (int indexNumber = 0; indexNumber <= channel.numberOfChildren()
                - 1; indexNumber++) {
            /**
             * if label of channel's child matches with item, pass the index of
             * that child to method call processItem
             **/
            if (channel.child(indexNumber).label() == "item") {
                processItem(channel.child(indexNumber), out);
            }
        }

    }

    /**
     * Outputs the "closing" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * </table>
     * </body> </html>
     *
     * @param out
     *            the output stream
     * @updates out.contents
     * @requires out.is_open
     * @ensures out.content = #out.content * [the HTML "closing" tags]
     */
    private static void outputFooter(SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";
        /** print the closing tags to the user-named file **/
        out.println("</table></body></html>");
    }

    /**
     * Finds the first occurrence of the given tag among the children of the
     * given {@code XMLTree} and return its index; returns -1 if not found.
     *
     * @param xml
     *            the {@code XMLTree} to search
     * @param tag
     *            the tag to look for
     * @return the index of the first child of type tag of the {@code XMLTree}
     *         or -1 if not found
     * @requires [the label of the root of xml is a tag]
     * @ensures
     *
     *          <pre>
     * getChildElement =
     *  [the index of the first child of type tag of the {@code XMLTree} or
     *   -1 if not found]
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
     * Processes one news item and outputs one table row. The row contains three
     * elements: the publication date, the source, and the title (or
     * description) of the item.
     *
     * @param item
     *            the news item
     * @param out
     *            the output stream
     * @updates out.content
     * @requires
     *
     *           <pre>
     * [the label of the root of item is an <item> tag] and out.is_open
     *           </pre>
     *
     * @ensures
     *
     *          <pre>
     * out.content = #out.content *
     *   [an HTML table row with publication date, source, and title of news item]
     *          </pre>
     */
    private static void processItem(XMLTree item, SimpleWriter out) {
        assert item != null : "Violation of: item is not null";
        assert out != null : "Violation of: out is not null";
        assert item.isTag() && item.label().equals("item") : ""
                + "Violation of: the label root of item is an <item> tag";
        assert out.isOpen() : "Violation of: out.is_open";
        /**
         * method call to find index of child with label 'pubDate' among item's
         * children
         **/
        int indexOfDate = getChildElement(item, "pubDate");
        if (indexOfDate != -1) {
            out.println(
                    "<tr><td>" + item.child(indexOfDate).child(0) + "</td>");
        } else {
            out.println("<tr><td>No date available</td>");
        }
        /**
         * method call to find index of child with label 'source' among item's
         * children
         **/
        int indexOfSource = getChildElement(item, "source");
        if (indexOfSource != -1) {
            out.println("<td><a href=\""
                    + item.child(indexOfSource).attributeValue("url") + "\">"
                    + item.child(indexOfSource).child(0) + "</a></td>");
        } else {
            out.println("<td>No source available</td>");
        }
        /**
         * method call to find index of child with label 'title' or
         * 'description' among item's children
         **/
        int indexOfTitle = getChildElement(item, "title");
        if (indexOfTitle != -1) {
            out.println("<td><a href=\""
                    + item.child(getChildElement(item, "link")).child(0) + "\">"
                    + item.child(indexOfTitle).child(0) + "</a></td></tr>");
        } else if (indexOfTitle == -1) {
            indexOfTitle = getChildElement(item, "description");
            if (indexOfTitle != -1) {
                out.println("<td><a href=\""
                        + item.child(getChildElement(item, "link")).child(0)
                        + "\">" + item.child(indexOfTitle).child(0)
                        + "</a></td></tr>");
            } else {
                out.println("<td><a href=\""
                        + item.child(getChildElement(item, "link")).child(0)
                        + "\">No title or description available</a></td></tr>");
            }
        }
    }

    /**
     * Processes one XML RSS (version 2.0) feed from a given URL converting it
     * into the corresponding HTML output file.
     *
     * @param url
     *            the URL of the RSS feed
     * @param file
     *            the name of the HTML output file
     * @param out
     *            the output stream to report progress or errors
     * @updates out.content
     * @requires out.is_open
     * @ensures
     *
     *          <pre>
     * [reads RSS feed from url, saves HTML document with table of news items
     *   to file, appends to out.content any needed messages]
     *          </pre>
     */
    private static void processFeed(String url, String file, SimpleWriter out) {
        /**
         * new SimpleWriter object to create html page for each rss feed
         **/
        SimpleWriter outToFile = new SimpleWriter1L(file);
        XMLTree rss = new XMLTree1(url);
        String version = "2.0";
        String label = "rss";
        /**
         * check that root label is rss and check version of rss
         **/
        if (rss.attributeValue("version").equals(version)
                && rss.label().equals(label)) {
            /**
             * pass the child of rss i.e. channel & SimpleWriter object
             * 'outToFile' to outputHeader
             **/
            outputHeader(rss.child(0), outToFile);
            findLabel(rss.child(0), outToFile);
            /** method call to print closing tags to the html file **/
            outputFooter(outToFile);
        } else {
            out.println(
                    "Feed does not contain tag rss or rss version is not compatible.");
        }
        outToFile.close();
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.println("Enter url of an XML file containing a list of URLs for RSS"
                + " v2.0 feeds: ");
        String url = in.nextLine();
        XMLTree xml = new XMLTree1(url);
        out.println("Enter filename: ");
        /** user-input for the name of output file **/
        String filename = in.nextLine();
        /**
         * new SimpleWriter object to print to the user-named output file
         **/
        SimpleWriter outToFileName = new SimpleWriter1L(filename);
        outToFileName.println("<html><head><title>"
                + xml.attributeValue("title") + "</title></head><body>");
        outToFileName
                .println("<h1>" + xml.attributeValue("title") + "</h1><ul>");
        int count = 0;
        while (count <= xml.numberOfChildren() - 1) {
            processFeed(xml.child(count).attributeValue("url"),
                    xml.child(count).attributeValue("file"), out);
            /**
             * create a list item on the html page for each of the given
             * children of xml url
             **/
            outToFileName.println("<li><a href=\""
                    + xml.child(count).attributeValue("file") + "\">"
                    + xml.child(count).attributeValue("name") + "</a></li>");
            count++;
        }
        outToFileName.println("</ul></body></html>");
        in.close();
        out.close();
        outToFileName.close();
    }
}
