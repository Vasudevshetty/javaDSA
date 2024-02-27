package dsa.trees;

import dsa.trees.binaryTrees.BinaryTree;
import dsa.trees.binaryTrees.TreeNode;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    public void insert(E data) {
        this.root = insertR(root, data);
    }

    private TreeNode<E> insertR(TreeNode<E> root, E data) {
        if (root == null) {
            root = new TreeNode<E>(data);
            return root;
        }

        if (data.compareTo(root.getData()) < 0)
            root.setLeftChild(insertR(root.getLeftChild(), data));
        else if (data.compareTo(root.getData()) > 0)
            root.setRightChild(insertR(root.getRightChild(), data));

        return root;
    }
}
