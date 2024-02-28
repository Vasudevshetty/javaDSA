package dsa.trees.binaryTrees;

import dsa.queue.Queue;
import dsa.stack.StackLL;
import java.util.ArrayList;

public class TraversalGenerator<E> {
    public static <E> ArrayList<E> preOrder(BinaryTree<E> tree) {
        StackLL<TreeNode<E>> stack = new StackLL<>();
        TreeNode<E> temp = tree.getRoot();
        ArrayList<E> traversal = new ArrayList<>();

        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                traversal.add(temp.getData());
                stack.push(temp);
                temp = temp.getLeftChild();
            } else {
                temp = stack.pop();
                temp = temp.getRightChild();
            }
        }
        return traversal;
    }

    public static <E> ArrayList<E> postOrder(BinaryTree<E> tree) {
        StackLL<TreeNode<E>> stack = new StackLL<>();
        StackLL<E> data = new StackLL<>();
        ArrayList<E> traversal = new ArrayList<>();

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
            traversal.add(data.pop());

        return traversal;
    }

    public static <E> ArrayList<E> inOrder(BinaryTree<E> tree) {
        StackLL<TreeNode<E>> stack = new StackLL<>();
        TreeNode<E> temp = tree.getRoot();
        ArrayList<E> traversal = new ArrayList<>();

        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.getLeftChild();
            } else {
                temp = stack.pop();
                traversal.add(temp.getData());
                temp = temp.getRightChild();
            }
        }
        return traversal;
    }

    public static <E> ArrayList<E> levelOrder(BinaryTree<E> tree) {
        ArrayList<E> traversal = new ArrayList<>();
        Queue<TreeNode<E>> queue = new Queue<>();
        TreeNode<E> temp = tree.getRoot();

        queue.enqueue(temp);
        while (!queue.isEmpty()) {
            temp = queue.dequeue();
            traversal.add(temp.getData());

            if (temp.getLeftChild() != null)
                queue.enqueue(temp.getLeftChild());
            if (temp.getRightChild() != null)
                queue.enqueue(temp.getRightChild());
        }
        return traversal;
    }
}
