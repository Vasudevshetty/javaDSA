package dsa.trees.binaryTrees;

import dsa.queue.Queue;
import dsa.stack.StackLL;

public class TraversalGenerator<E> {
    public static <E> String preOrder(BinaryTree<E> tree) {
        StackLL<TreeNode<E>> stack = new StackLL<>();
        TreeNode<E> temp = tree.getRoot();
        StringBuilder traversal = new StringBuilder();

        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                traversal.append(temp.getData());
                stack.push(temp);
                temp = temp.getLeftChild();
            } else {
                temp = stack.pop();
                temp = temp.getRightChild();
            }
        }
        return traversal.toString();
    }

    public static <E> String postOrder(BinaryTree<E> tree) {
        StackLL<TreeNode<E>> stack = new StackLL<>();
        StackLL<E> data = new StackLL<>();
        StringBuilder traversal = new StringBuilder();

        stack.push(tree.getRoot());
        while (!stack.isEmpty()) {
            TreeNode<E> temp = stack.pop();
            data.push(temp.getData());
            if (temp.getLeftChild() != null)
                stack.push(temp.getLeftChild());
            if (temp.getRightChild() != null)
                stack.push(temp.getRightChild());
        }
        while (!data.isEmpty())
            traversal.append(data.pop());

        return traversal.toString();
    }

    public static <E> String inOrder(BinaryTree<E> tree) {
        StackLL<TreeNode<E>> stack = new StackLL<>();
        TreeNode<E> temp = tree.getRoot();
        StringBuilder traversal = new StringBuilder();

        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.getLeftChild();
            } else {
                temp = stack.pop();
                traversal.append(temp.getData());
                temp = temp.getRightChild();
            }
        }
        return traversal.toString();
    }

    public static <E> String levelOrder(BinaryTree<E> tree) {
        StringBuilder traversal = new StringBuilder();
        Queue<TreeNode<E>> queue = new Queue<>();
        TreeNode<E> temp = tree.getRoot();

        queue.enqueue(temp);
        while (!queue.isEmpty()) {
            temp = queue.dequeue();
            traversal.append(temp.getData());

            if (temp.getLeftChild() != null)
                queue.enqueue(temp.getLeftChild());
            if (temp.getRightChild() != null)
                queue.enqueue(temp.getRightChild());
        }
        return traversal.toString();
    }
}
