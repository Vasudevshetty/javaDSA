package dsa.LinkedList;

public class NodeSingle<E> {
    private E data;
    private NodeSingle<E> next;

    public NodeSingle(){}

    // constructor for initalisation of the node.
    public NodeSingle(E data){
        this.data = data;
        this.next = null;
    }

    // getters and setters of the members.
    public E getData(){return this.data;}
    public void setData(E data){this.data = data;}
    public NodeSingle<E> getNext(){return this.next;}
    public void setNext(NodeSingle<E> next){this.next = next;}
}
