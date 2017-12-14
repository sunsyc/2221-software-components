import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
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
    private static NaturalNumber evaluate(XMLTree exp) {
        //SimpleWriter out = new SimpleWriter1L();
        assert exp != null : "Violation of: exp is not null";
        //out.println(exp.label());
        NaturalNumber ans = new NaturalNumber2(0);
        NaturalNumber num1 = new NaturalNumber2(0);
        NaturalNumber num2 = new NaturalNumber2(0);
        NaturalNumber num3 = new NaturalNumber2(0);
        NaturalNumber num4 = new NaturalNumber2(0);
        NaturalNumber zero = new NaturalNumber2(0);
        /**
         * check if the children contain operands
         **/
        if (exp.child(0).label().equals("number")
                && exp.child(1).label().equals("number")) {
            /**
             * convert the string stored in attribute into number
             **/
            int n1 = Integer.parseInt(exp.child(0).attributeValue("value"));
            /**
             * condition check, give error if n1<0
             **/
            if (n1 < 0) {
                Reporter.fatalErrorToConsole("Fatal Error");
            }
            num1.setFromInt(n1);
            int n2 = Integer.parseInt(exp.child(1).attributeValue("value"));
            if (n2 < 0) {
                Reporter.fatalErrorToConsole("Fatal Error");
            }
            num2.setFromInt(n2);
        } else if (exp.child(0).label().equals("number")) {
            /**
             * if both the children do not contain operands then check if the
             * 1st child contains operand
             **/
            int n3 = Integer.parseInt(exp.child(0).attributeValue("value"));
            if (n3 < 0) {
                Reporter.fatalErrorToConsole("Fatal Error");
            }
            num3.setFromInt(n3);
            /**
             * adds the return value of method call to answer
             **/
            ans.add(evaluate(exp.child(1)));
        } else if (exp.child(1).label().equals("number")) {
            /**
             * if both the children do not contain operands then check if the
             * 2nd child contains operand
             **/
            int n4 = Integer.parseInt(exp.child(1).attributeValue("value"));
            if (n4 < 0) {
                Reporter.fatalErrorToConsole("Fatal Error");
            }
            num4.setFromInt(n4);
            ans.add(evaluate(exp.child(0)));
        }
        if (!num3.isZero()) {
            /**
             * if num3 is not zero then the method underwent recursion. the
             * first child of tree passed in method, had an operand and the
             * value of previous method call is stored in ans hence perform
             * calculations using ans and num3
             **/
            if (exp.label().equals("times")) {
                ans.multiply(num3);
            } else if (exp.label().equals("divide")) {
                /**
                 * check if divisor is <=0
                 **/
                if (num3.compareTo(zero) <= 0) {
                    Reporter.fatalErrorToConsole("Fatal Error");
                }
                ans.divide(num3);
            } else if (exp.label().equals("plus")) {
                ans.add(num3);
            } else if (exp.label().equals("minus")) {
                /**
                 * check if number is not negative
                 **/
                if (ans.compareTo(num4) < 0) {
                    Reporter.fatalErrorToConsole("Fatal Error");
                }
                ans.subtract(num3);
            }
        } else if (!num4.isZero()) {
            /**
             * if num4 is not zero then the method underwent recursion. the
             * second child of tree passed in method, had an operand and the
             * value of previous method call is stored in ans hence perform
             * calculations using ans and num4
             **/
            if (exp.label().equals("times")) {
                ans.multiply(num4);
            } else if (exp.label().equals("divide")) {
                if (num4.compareTo(zero) <= 0) {
                    Reporter.fatalErrorToConsole("Fatal Error");
                }
                ans.divide(num4);
            } else if (exp.label().equals("plus")) {
                ans.add(num4);
            } else if (exp.label().equals("minus")) {
                if (ans.compareTo(num4) < 0) {
                    Reporter.fatalErrorToConsole("Fatal Error");
                }
                ans.subtract(num4);
            }
        } else {
            /**
             * the method contains a simple expression and did not undergo
             * recursion. perform operations on num1 and num2
             **/
            if (exp.label().equals("times")) {
                num1.multiply(num2);
                /**
                 * copy the value of num1 in ans
                 **/
                ans.copyFrom(num1);
            } else if (exp.label().equals("divide")) {
                if (num3.compareTo(zero) <= 0) {
                    Reporter.fatalErrorToConsole("Fatal Error");
                }
                num1.divide(num2);
                ans.copyFrom(num1);
            } else if (exp.label().equals("plus")) {
                num1.add(num2);
                ans.copyFrom(num1);
            } else if (exp.label().equals("minus")) {
                if (ans.compareTo(num4) < 0) {
                    Reporter.fatalErrorToConsole("Fatal Error");
                }
                num1.subtract(num2);
                ans.copyFrom(num1);
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
