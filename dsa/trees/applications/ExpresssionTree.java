package dsa.trees.applications;

import dsa.trees.binaryTrees.BinaryTree;
import dsa.trees.binaryTrees.TreeNode;
import dsa.stack.StackLL;

/**
 * The utility class for expresssion tree, This class contains few of the
 * methods(operations) on Expression trees.
 * Since expression tree is also a binary tree, it extends the binary tree
 * class.
 * 
 * @author Vasudevshetty
 */
public class ExpresssionTree extends BinaryTree<String> {
    /**
     * The Notation datatype, i.e the epxresssion's notation (prefix, infix or
     * postfix).
     */
    public enum Notation {
        prefix, postfix, infix
    };

    /**
     * The expression tree is constructed based on the expression passed to, upon
     * recieveing the expression the tree gets ready
     * 
     * @param expresssion to be converted as tree.
     * @param notation    followed in the expresssion
     */
    public ExpresssionTree(String expresssion, Notation notation) {
        this.root = constructExpressionTree(expresssion, notation);
        this.getNodeCount();
        this.getHeight();
    }

    /**
     * Suport function to check whether the token is operand or not
     * @param c the character to be checked.
     * @return true if yes else no.
     */
    private boolean isOperand(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    /**
     * Suport function to check whether the token is operator or not
     * @param c the character to be checked.
     * @return true if yes else no.
     */
    private boolean isOperator(final char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * The function to construct a Expresssion tree based on the expression recieved.
     * @param expresssion to be constructed as experssion tree.
     * @param notation type followed in the expression
     * @return Reference to the hence constructed expression tree.
     */
    private TreeNode<String> constructExpressionTree(final String expresssion, Notation notation) {
        StackLL<TreeNode<String>> stack = new StackLL<>();
        int i = 0, len = expresssion.length();
        while (i < len) {
            char token = notation == Notation.postfix ? expresssion.charAt(i) : expresssion.charAt(len - i - 1);
            if (isOperand(token))
                stack.push(new TreeNode<String>(String.valueOf(token)));
            else if (isOperator(token)) {
                TreeNode<String> operand2 = stack.pop();
                TreeNode<String> operand1 = stack.pop();

                TreeNode<String> subExpression = new TreeNode<String>(String.valueOf(token));
                subExpression.setLeftChild(notation == Notation.postfix ? operand1 : operand2);
                subExpression.setRightChild(notation == Notation.postfix ? operand2 : operand1);

                stack.push(subExpression);
            }
            i++;
        }
        return stack.pop();
    }
}
