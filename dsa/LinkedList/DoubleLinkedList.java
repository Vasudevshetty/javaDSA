package dsa.LinkedList;

import dsa.LinkedList.Exception.EmptyLinkedListException;
import dsa.LinkedList.Exception.InvalidPositionException;
import dsa.LinkedList.Exception.KeyNotFoundException;

public class DoubleLinkedList<E> extends NodeDouble<E> implements LinkedList<E> {
    private NodeDouble<E> head;
    private NodeDouble<E> tail;
    private int length;

    public DoubleLinkedList() {
        super();
    }

    public NodeDouble<E> getHead() {
        return this.head;
    }

    public void setHead(NodeDouble<E> head) {
        this.head = head;
    }

    public NodeDouble<E> getTail() {
        return this.tail;
    }

    public void setTail(NodeDouble<E> tail) {
        this.tail = tail;
    }

    public int getLength() {
        return this.length;
    }

    public void insertHead(E data) {
        NodeDouble<E> newNode = new NodeDouble<>(data);

        if (this.head == null) {
            setHead(newNode);
            setTail(newNode);
        } else {
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            setHead(newNode);
        }
        this.length++;
    }

    public void insertRear(E data) {
        if (this.head == null) {
            insertHead(data);
            return;
        }

        NodeDouble<E> newNode = new NodeDouble<>(data);
        NodeDouble<E> temp = this.tail;

        temp.setNext(newNode);
        newNode.setPrev(temp);
        setTail(newNode);
        this.length++;
    }

    public void insert(E data, int position) throws InvalidPositionException {
        if (position < 0 || position > this.length)
            throw new InvalidPositionException("Invalid position, Insertion failed.\n" + position);

        if (position == 0) {
            insertHead(data);
            return;
        }
        if (position == this.length) {
            insertRear(data);
            return;
        }

        NodeDouble<E> newNode = new NodeDouble<>(data);
        NodeDouble<E> temp = this.head;

        for (int i = 0; i < position - 1; i++)
            temp = temp.getNext();

        newNode.setNext(temp.getNext());
        temp.getNext().setNext(newNode);
        temp.setNext(newNode);
        newNode.setPrev(temp);
        this.length++;
    }

    public E deleteHead() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("No elements to delete.\n");

        NodeDouble<E> toDelete = this.head;
        E data = toDelete.getData();

        setHead(toDelete.getNext());

        if (toDelete.getNext() == null){
            this.head = null;   
            this.tail = null;
        }

        this.length--;
        return data;
    }

    public E deleteRear() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("No elements to delete.\n");

        if (this.length == 1)
            return deleteHead();

        NodeDouble<E> toDelete = this.tail;
        E data = toDelete.getData();

        this.tail = this.tail.getPrev();
        this.tail.setNext(null);

        this.length--;
        return data;
    }

    public E delete(int position) throws InvalidPositionException, EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("No elements to delete.\n");
        if (position < 0 || position > this.length)
            throw new InvalidPositionException("Invalid position, Deletion failed.\n");

        if (position == 0)
            return deleteHead();
        if (position == this.length - 1)
            return deleteRear();

        NodeDouble<E> temp = this.head;
        for (int i = 0; i < position - 1; i++)
            temp = temp.getNext();

        NodeDouble<E> toDelete = temp.getNext();
        E data = toDelete.getData();

        temp.setNext(toDelete.getNext());
        toDelete.getNext().setPrev(temp);

        this.length--;
        return data;
    }

    public Node<E> searchByKey(E key) {
        if (isEmpty())
            throw new EmptyLinkedListException("No elements to search.\n");

        NodeDouble<E> temp = this.head;
        while (temp != null) {
            if (temp.getData() == key)
                return temp;
            temp = temp.getNext();
        }
        throw new KeyNotFoundException("key not found");
    }

    public E deleteBykey(E key) {
        NodeDouble<E> toDelete = (NodeDouble<E>) searchByKey(key);
        E data = toDelete.getData();

        if (toDelete == this.head)
            return deleteHead();
        else {
            NodeDouble<E> temp = this.head;
            while (temp != null && temp.getNext() != toDelete) {
                temp = temp.getNext();
            }
            if (temp != null)
                temp.setNext(toDelete.getNext());
            this.length--;
        }
        return data;
    }

    public LinkedList<E> copyList() {
        DoubleLinkedList<E> copy = new DoubleLinkedList<>();

        NodeDouble<E> temp = this.head;

        while (temp != null) {
            copy.insertRear(temp.getData());
            temp = temp.getNext();
        }
        return copy;
    }

    public void reverse() {
        if (isEmpty())
            throw new EmptyLinkedListException("List is empty to reverse.\n");

        NodeDouble<E> current = this.head;
        NodeDouble<E> next = null;
        NodeDouble<E> prev = null;

        while (current != null) {
            next = current.getNext();

            current.setNext(prev);
            current.setPrev(next);

            prev = current;
            current = next;
        }
        this.tail = this.head;
        this.head = prev;
    }

    public void createOrderedList(E data) {

    }

    public boolean isEmpty() {
        return this.head == null && this.length == 0;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        NodeDouble<E> temp = this.head;

        data.append("The Elements of the list are, \nnull<=>");
        while (temp != null) {
            data.append(temp.getData()).append("<=>");
            temp = temp.getNext();
        }
        data.append("null");
        return data.toString();
    }

    public void display() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("List is empty, No elements to display");

        NodeDouble<E> temp = this.head;
        System.out.println("The elements of the list are, ");
        System.out.print("null<=>");
        while (temp != null) {
            System.out.print(temp.getData() + "<=>");
            temp = temp.getNext();
        }
        System.out.print("null");
    }
}
