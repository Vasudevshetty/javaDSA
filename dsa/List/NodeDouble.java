package dsa.list;

/**
 * The nodedouble class is for double linked nodes.
 */
public class NodeDouble<E> implements Node<E> {
    private E data;
    private NodeDouble<E> next;
    private NodeDouble<E> prev;

    public NodeDouble() {
    }

    /**
     * The constructor where it constructs for double linked list.
     * 
     * @param data the data to be added to node.
     */
    // constructor for the node(initalisation.)
    public NodeDouble(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // constructor for circular list.
    /**
     * The contructor where it constructs for double circualr linekd list.
     * 
     * @param data       the data to be set.
     * @param isCircular whether it is circualr or not .
     */
    public NodeDouble(E data, boolean isCircular) {
        this.data = data;
        if (isCircular) {
            this.next = this;
            this.prev = this;
        } else {
            this.next = null;
            this.prev = null;
        }
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
    public NodeDouble<E> getNext() {
        return this.next;
    }

    /**
     * The function to get or fetch the previous node's refernce.
     * 
     * @return the refernce to previous node.
     */
    public NodeDouble<E> getPrev() {
        return this.prev;
    }

    /**
     * The function to set or manipulate the next node's refernce.
     * 
     * @param prev the refernce to next node.
     */
    public void setNext(NodeDouble<E> next) {
        this.next = next;
    }

    /**
     * The function to set or manipulate the previous node's refernce.
     * 
     * @param prev the refernce to previous node.
     */
    public void setPrev(NodeDouble<E> prev) {
        this.prev = prev;
    }
}
