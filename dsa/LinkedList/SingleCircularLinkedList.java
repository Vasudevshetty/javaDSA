package dsa.LinkedList;

public class SingleCircularLinkedList<E> extends NodeSingle<E> implements LinkedList<E>, CircularLinkedList<E> {
    private NodeSingle<E> head;
    int length;

    public SingleCircularLinkedList(){
        super();
    }
    public NodeSingle<E> getHead(){return this.head;}
    public void setHead(NodeSingle<E> head){this.head = head;}
    public int getLength(){return this.length;}

    public boolean isEmpty(){
        return (head == null && length == 0);
    }
}
