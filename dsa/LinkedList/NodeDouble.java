package dsa.LinkedList;

public class NodeDouble<E> {
    private E data;
    private NodeDouble<E> next;
    private NodeDouble<E> prev;

    // constructor for the node(initalisation.)
    public NodeDouble(E data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // getters and setters of the members.
    public E getData(){return this.data;}
    public void setData(E data){this.data =data;}
    public NodeDouble<E> getNext(){return this.next;}
    public NodeDouble<E> getPrev(){return this.prev;}
    public void setNext(NodeDouble<E> next){this.next = next;}
    public void setPrev(NodeDouble<E> prev){this.next = prev;}
}   
