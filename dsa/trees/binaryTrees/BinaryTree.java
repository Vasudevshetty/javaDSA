package dsa.trees.binaryTrees;

/**
 * The abstract class for binary trees, the tree which containing atmost 2
 * children i.e -> {0, 1, 2} children.
 * 
 * @author Vasudevshetty
 * @param <E> the type of data field.
 */
public abstract class BinaryTree<E> {
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
        return this.height;
    }

    /**
     * Getter method for the nodes count of the binary tree.
     * 
     * @return The nodes count of the binary tree.
     */
    public int getNodeCount() {
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
     * Funciton to insert a node to the binary tree.
     * 
     * @param data to be added
     */
    public abstract void insert(E data);

    /**
     * Function to delete a node from the binary tree.
     * 
     * @param data to be deleted.
     * @return true if deleted else false
     */
    public abstract boolean delete(E data);

    /**
     * Function to serach for a node in the binary tree.
     * 
     * @param data to be searched.
     * @return true if found else false
     */
    public abstract boolean search(E data);

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

}
