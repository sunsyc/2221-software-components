import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * XMLTreeExploration.
 *
 * @author Shiny Patel.
 *
 */
public final class XMLTreeExploration {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeExploration() {
    }

    /**
     * Output information about the middle child of the given {@code XMLTree}.
     *
     * @param xt
     *            the {@code XMLTree} whose middle child is to be printed
     * @param out
     *            the output stream
     * @updates out.content
     * @requires
     *
     *           <pre>
     * [the label of the root of xt is a tag]  and
     * [xt has at least one child]  and  out.is_open
     *           </pre>
     *
     * @ensures
     *
     *          <pre>
     * out.content = #out.content * [the label of the middle child
     *  of xt, whether the root of the middle child is a tag or text,
     *  and if it is a tag, the number of children of the middle child]
     *          </pre>
     */
    private static void printMiddleNode(XMLTree xt, SimpleWriter out) {
        out.println(xt.child(6).label());
        out.println(xt.child(6).isTag());
        out.println(xt.child(6).numberOfChildren());
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
        XMLTree xml = new XMLTree1(
                "http://xml.weather.yahoo.com/forecastrss/43210.xml");
        xml.display();
        out.println(xml.label());
        out.println(xml.isTag());
        XMLTree channel = xml.child(0);
        out.println(channel.numberOfChildren());
        XMLTree title = channel.child(0);
        XMLTree titleText = title.child(0);
        out.println(titleText.label());
        out.println(xml.child(0).child(0).child(0).label());
        XMLTree astronomy = channel.child(10);
        out.println(astronomy.hasAttribute("sunset"));
        out.println(astronomy.hasAttribute("midday"));
        out.println(astronomy.attributeValue("sunset"));
        out.println(astronomy.attributeValue("midday"));
        out.println(channel.numberOfChildren());
        printMiddleNode(channel, out);
        //out.println(xml.toString());
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
