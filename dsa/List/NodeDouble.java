package dsa.list;

public class NodeDouble<E> implements Node<E>{
    private E data;
    private NodeDouble<E> next;
    private NodeDouble<E> prev;

    public NodeDouble(){}

    // constructor for the node(initalisation.)
    public NodeDouble(E data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // constructor for circular list.
    public NodeDouble(E data, boolean isCircular){
        this.data = data;
        if(isCircular){
            this.next = this;
            this.prev = this;
        }else{
            this.next = null;
            this.prev = null;
        }
    }

    // getters and setters of the members.
    @Override
    public E getData(){return this.data;}
    @Override
    public void setData(E data){this.data =data;}
    public NodeDouble<E> getNext(){return this.next;}
    public NodeDouble<E> getPrev(){return this.prev;}
    public void setNext(NodeDouble<E> next){this.next = next;}
    public void setPrev(NodeDouble<E> prev){this.prev = prev;}
}   
