package dsa.trees.binaryTrees;

/* 
* This class is support class for the binary trees constructed, 
* this is the basic outline of how trees is made up of.
* The node consists atmost 2 children .{0, 1, 2}. and a data feild.
* No setter is allowed and the members are kept protected to give some access.
*/

/**
 * The Tree's node structure, it contains a data field, and two refernce members
 * to it's left and right child.
 * 
 * @author VasudevShetty
 * @param <E> the type of data field.
 */
public class TreeNode<E> {
    /** Data feild of the node */
    protected E data;
    /** Reference to the left child. */
    protected TreeNode<E> leftChild;
    /** Reference to the right child. */
    protected TreeNode<E> rightChild;

    /**
     * The contructor for the tree node, which takes in a data field, sets the
     * leftchild, rightchild to null.(points to none)
     * 
     * @param data field to be added
     */
    public TreeNode(E data) {
        this.data = data;
        this.leftChild = this.rightChild = null;
    }

    /**
     * The fucntion is getter method for data field.
     * 
     * @return the data field.
     */
    public E getData() {
        return this.data;
    }

    /**
     * The fucntion is getter method for left child
     * 
     * @return the left child's reference
     */
    public TreeNode<E> getLeftChild() {
        return this.leftChild;
    }

    /**
     * The fucntion is getter method for right child
     * 
     * @return the right child's refernce
     */
    public TreeNode<E> getRightChild() {
        return this.rightChild;
    }
}
