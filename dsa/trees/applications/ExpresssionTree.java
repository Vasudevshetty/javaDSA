package dsa.trees.applications;

import dsa.trees.binaryTrees.BinaryTree;
import dsa.trees.binaryTrees.TreeNode;
import dsa.stack.StackLL;

public class ExpresssionTree extends BinaryTree<String> {
    public enum Notation {
        prefix, postfix, infix
    };

    public ExpresssionTree(String expresssion, Notation notation) {
        this.root = constructExpressionTree(expresssion, notation);
    }

    private boolean isOperand(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isOperator(final char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

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
