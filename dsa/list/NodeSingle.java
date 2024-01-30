package dsa.list;

/**
 * The class for singly connected nodes.
 */
public class NodeSingle<E> implements Node<E> {
    private E data;
    private NodeSingle<E> next;

    public NodeSingle() {
    }

    // constructor for initalisation of the node.
    /**
     * The constructor to set the data to new singly connected node.
     * 
     * @param data the data to be set on.
     */
    public NodeSingle(E data) {
        this.data = data;
        this.next = null;
    }

    // constructor for cicular list.
    /**
     * The contructor to set the data to new singly connected cicular node.
     * 
     * @param data       the data to be set on.
     * @param isCircular whether the list is circualr or not.
     */
    public NodeSingle(E data, boolean isCircular) {
        this.data = data;
        if (isCircular) {
            this.next = this;
        } else
            this.next = null;
    }

    // getters and setters of the members.
    @Override
    public E getData() {
        return this.data;
    }

    @Override
    public void setData(E data) {
        this.data = data;
    }

    /**
     * The function to get or fetch the next node's refernce.
     * 
     * @return the refernce to next node.
     */
    public NodeSingle<E> getNext() {
        return this.next;
    }

    /**
     * The function to set or manipulate the next node's refernce.
     * 
     * @param next the refernce to new next node.
     */
    public void setNext(NodeSingle<E> next) {
        this.next = next;
    }
}
