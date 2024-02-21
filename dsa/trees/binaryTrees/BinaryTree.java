package dsa.trees.binaryTrees;

import dsa.queue.Queue;

/**
 * The class for binary trees, the tree which containing atmost 2
 * children i.e -> {0, 1, 2} children.
 * 
 * @author Vasudevshetty
 * @param <E> the type of data field.
 */
public class BinaryTree<E> {
    /** Root of the tree */
    protected TreeNode<E> root;
    /** Height of the binary tree. */
    protected int height;
    /** Count of nodes of the binary tree. */
    protected int nodeCount;

    
    // the necessity of creating a default constructor is not needed ig. (since all
    // the members are assinged to corresponding nulls)

    // getter methods.
    /**
     * Getter method for the height of the binary tree.
     * 
     * @return The hieght of the binary tree.
     */
    public int getHeight() {
        this.height = calculateHeight(this.root);
        return this.height;
    }

    /**
     * Getter method for the nodes count of the binary tree.
     * 
     * @return The nodes count of the binary tree.
     */
    public int getNodeCount() {
        this.nodeCount = countNodes(this.root);
        return this.nodeCount;
    }

    /**
     * Getter method for the root of the binary tree.
     * 
     * @return the root refernce of the binary tree.
     */
    public TreeNode<E> getRoot() {
        return this.root;
    }

    /**
     * The recuresive functin to calculate the height of the binary tree.
     * 
     * @param node reference to the root.
     * @return height of the tree
     */
    private int calculateHeight(TreeNode<E> node) {
        if (node == null)
            return -1;
        int heightLeftSubTree = calculateHeight(node.getLeftChild());
        int heightRightSubTree = calculateHeight(node.getRightChild());
        return 1 + Math.max(heightLeftSubTree, heightRightSubTree);
    }

    /**
     * The recursive functin to calcualte the count of nodes of binary tree.
     * 
     * @param node refernce to root
     * @return the count of the nodes.
     */
    private int countNodes(TreeNode<E> node) {
        if (node == null)
            return 0;
        return 1 + countNodes(node.getLeftChild()) + countNodes(node.getRightChild());
    }

    /** Inorder traversal of the binary tree. */
    public void inOrder() {
        inorder(this.root);
    }

    /** Preorder traversal of the binary tree. */
    public void preOrder() {
        preorder(this.root);
    }

    /** Postorder traversal of the binary tree. */
    public void postOrder() {
        postorder(this.root);
    }

    /**
     * Function to recursively generate the inorder traversal of the given binary
     * tree.
     * 
     * @param node refernce to the root of the binary tree.
     */
    private void inorder(TreeNode<E> node) {
        if (node == null)
            return;
        inorder(node.getLeftChild());
        System.out.print(node.getData() + " ");
        inorder(node.getRightChild());
    }

    /**
     * Function to recursively generate the preorder traversal of the given binary
     * tree.
     * 
     * @param node refernce to the root of the binary tree.
     */
    private void preorder(TreeNode<E> node) {
        if (node == null)
            return;
        System.out.print(node.getData() + " ");
        preorder(node.getLeftChild());
        preorder(node.getRightChild());
    }

    /**
     * Function to recursively generate the postorder traversal of the given binary
     * tree.
     * 
     * @param node refernce to the root of the binary tree.
     */
    private void postorder(TreeNode<E> node) {
        if (node == null)
            return;
        postorder(node.getLeftChild());
        postorder(node.getRightChild());
        System.out.print(node.getData() + " ");
    }

    public void levelOrder() {
        TreeNode<E> temp = this.root;
        Queue<TreeNode<E>> queue = new Queue<>();
        queue.enqueue(temp);
        while (!queue.isEmpty()) {
            temp = queue.dequeue();
            System.out.print(temp.getData() + " ");
            if (temp.getLeftChild() != null)
                queue.enqueue(temp.getLeftChild());
            if (temp.getRightChild() != null)
                queue.enqueue(temp.getRightChild());
        }
    }
}
