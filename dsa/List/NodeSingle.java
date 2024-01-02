package dsa.List;

public class NodeSingle<E> implements Node<E>{
    private E data;
    private NodeSingle<E> next;

    public NodeSingle(){}

    // constructor for initalisation of the node.
    public NodeSingle(E data){
        this.data = data;
        this.next = null;
    }

    // constructor for cicular list.
    public NodeSingle(E data, boolean isCircular){
        this.data = data;
        if(isCircular){
            this.next = this;
        }else this.next = null;
    }

    // getters and setters of the members.
    @Override
    public E getData(){return this.data;}
    @Override
    public void setData(E data){this.data = data;}
    public NodeSingle<E> getNext(){return this.next;}
    public void setNext(NodeSingle<E> next){this.next = next;}
}
