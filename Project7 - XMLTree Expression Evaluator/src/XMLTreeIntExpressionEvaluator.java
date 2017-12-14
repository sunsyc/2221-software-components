import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires
     *
     *           <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     *           </pre>
     *
     * @ensures evaluate = [the value of the expression]
     */
    private static int evaluate(XMLTree exp) {
        //SimpleWriter out = new SimpleWriter1L();
        assert exp != null : "Violation of: exp is not null";
        //out.println(exp.label());
        int ans = 0, num1 = 0, num2 = 0;
        int num3 = 0, num4 = 0;
        /**
         * check if the children contain operands
         **/
        if (exp.child(0).label().equals("number")
                && exp.child(1).label().equals("number")) {
            /**
             * convert the string stored in attribute into number
             **/
            num1 = Integer.parseInt(exp.child(0).attributeValue("value"));
            num2 = Integer.parseInt(exp.child(1).attributeValue("value"));
        } else if (exp.child(0).label().equals("number")) {
            /**
             * if both the children do not contain operands then check if the
             * 1st child contains operand
             **/
            num3 = Integer.parseInt(exp.child(0).attributeValue("value"));
            /**
             * adds the return value of method call to answer
             **/
            ans += evaluate(exp.child(1));
        } else if (exp.child(1).label().equals("number")) {
            /**
             * if both the children do not contain operands then check if the
             * 2nd child contains operand
             **/
            num4 = Integer.parseInt(exp.child(1).attributeValue("value"));
            ans += evaluate(exp.child(0));
        }
        if (num3 != 0) {
            /**
             * if num3 is not zero then the method underwent recursion. the
             * first child of tree passed in method, had an operand and the
             * value of previous method call is stored in ans hence perform
             * calculations using ans and num3
             **/
            if (exp.label().equals("times")) {
                ans = num3 * ans;
            } else if (exp.label().equals("divide")) {
                ans = num3 / ans;
            } else if (exp.label().equals("plus")) {
                ans = num3 + ans;
            } else if (exp.label().equals("minus")) {
                ans = num3 - ans;
            }
        } else if (num4 != 0) {
            /**
             * if num4 is not zero then the method underwent recursion. the
             * second child of tree passed in method, had an operand and the
             * value of previous method call is stored in ans hence perform
             * calculations using ans and num4
             **/
            if (exp.label().equals("times")) {
                ans = ans * num4;
            } else if (exp.label().equals("divide")) {
                ans = ans / num4;
            } else if (exp.label().equals("plus")) {
                ans = ans + num4;
            } else if (exp.label().equals("minus")) {
                ans = ans - num4;
            }
        } else {
            /**
             * the method contains a simple expression and did not undergo
             * recursion. perform operations on num1 and num2
             **/
            if (exp.label().equals("times")) {
                ans = num1 * num2;
            } else if (exp.label().equals("divide")) {
                ans = num1 / num2;
            } else if (exp.label().equals("plus")) {
                ans = num1 + num2;
            } else if (exp.label().equals("minus")) {
                ans = num1 - num2;
            }
        }
        return ans;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
