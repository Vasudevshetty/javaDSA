package dsa.list;

import dsa.list.Exception.EmptyLinkedListException;
import dsa.list.Exception.InvalidPositionException;
import dsa.list.Exception.KeyNotFoundException;

/**
 * The class for double circular linked list, where the nodes or connected
 * mutually, only operations at specific postioins takes
 * lienar time(O(K)), where k is the position and at head or tail it is constant
 * time.
 * and the list is circular making it easier to travese any way wanted.
 */
public class DoubleCircularLinkedList<E> implements LinkedList<E>, CircularLinkedList<E> {
    private NodeDouble<E> head;
    private NodeDouble<E> tail;
    private int length;

    /**
     * The funtion to get or fetch the head's refernce.
     * 
     * @return the refernce to head.
     */
    public NodeDouble<E> getHead() {
        return this.head;
    }

    /**
     ** The funtion to get or fetch the tail's refernce.
     * 
     * @return the refernce to tail.
     */
    public NodeDouble<E> getTail() {
        return this.tail;
    }

    /** {@inheritDoc} */
    public int getLength() {
        return this.length;
    }

    /**
     * Constructs the linkedlist where the head node is considered as a dummy node,
     * tail node points to the tail of the list.
     * head node points to the first data ndoe of the list.
     * length is the count of the nodes.
     */
    public DoubleCircularLinkedList() {
        this.head = new NodeDouble<E>(null);
        this.tail = null;
        this.length = 0;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isCircular() {
        if (isEmpty())
            return false;
        return this.head.getNext().getPrev() == this.tail && this.tail.getNext() == this.head.getNext();
    }

    /** {@inheritDoc} */
    public boolean isEmpty() {
        return this.head.getNext() == null && this.tail == null && this.length == 0;
    }

    /** {@inheritDoc} */
    @Override
    public void insertHead(E data) {
        NodeDouble<E> newNode = new NodeDouble<E>(data, true);
        if (isEmpty()) {
            this.head.setNext(newNode);
            this.tail = newNode;
        } else {
            newNode.setNext(this.head.getNext());
            this.head.getNext().setPrev(newNode);
            this.head.setNext(newNode);
            this.head.setPrev(this.tail);
            this.tail.setNext(this.head.getNext());
        }
        this.length++;
    }

    /** {@inheritDoc} */
    @Override
    public void insertTail(E data) {
        if (isEmpty()) {
            insertHead(data);
            return;
        }
        NodeDouble<E> newNode = new NodeDouble<>(data, true);
        newNode.setPrev(this.tail);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.tail.setNext(this.head.getNext());
        this.head.getNext().setPrev(this.tail);
        this.length++;
    }

    /** {@inheritDoc} */
    @Override
    public void insert(E data, int position) throws InvalidPositionException {
        if (position < 0 || position > this.length)
            throw new InvalidPositionException("Invalid position to insert, Insertion failed.");
        if (position == 0)
            insertHead(data);
        else if (position == this.length)
            insertTail(data);
        else {
            NodeDouble<E> newNode = new NodeDouble<>(data, true);
            NodeDouble<E> temp = this.head.getNext();
            for (int i = 0; i < position - 1; i++)
                temp = temp.getNext();
            temp.getNext().setPrev(newNode);
            newNode.setNext(temp.getNext());
            newNode.setPrev(temp);
            temp.setNext(newNode);
            this.length++;
        }
    }

    /** {@inheritDoc} */
    @Override
    public E deleteHead() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("Empty list, no elements to delete.");
        NodeDouble<E> toDelete = this.head.getNext();
        E data = toDelete.getData();
        if (this.length == 1) {
            this.head.setNext(null);
            this.tail = null;
        } else {
            this.head.setNext(toDelete.getNext());
            this.head.getNext().setPrev(this.tail);
            this.tail.setNext(this.head.getNext());
        }
        this.length--;
        return data;
    }

    /** {@inheritDoc} */
    @Override
    public E deleteTail() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("Empty list, no elements to delete.");
        if (this.length == 1)
            return deleteHead();
        NodeDouble<E> toDelete = this.tail;
        E data = toDelete.getData();
        this.tail = toDelete.getPrev();
        this.tail.setNext(this.head.getNext());
        this.head.getNext().setPrev(this.tail);
        this.length--;
        return data;
    }

    /** {@inheritDoc} */
    @Override
    public E delete(int position) throws EmptyLinkedListException, InvalidPositionException {
        if (isEmpty())
            throw new EmptyLinkedListException("Empty list, no elements to delete.");
        if (position < 0 || position >= this.length)
            throw new InvalidPositionException("Invalid position, deletion failed.");
        if (position == 0)
            return deleteHead();
        if (position == this.length - 1)
            return deleteTail();

        NodeDouble<E> temp = this.head.getNext();
        for (int i = 0; i < position - 1; i++)
            temp = temp.getNext();
        NodeDouble<E> toDelete = temp.getNext();
        E data = toDelete.getData();
        toDelete.getNext().setPrev(temp);
        temp.setNext(toDelete.getNext());
        this.length--;
        return data;
    }

    /** {@inheritDoc} */
    @Override
    public E deleteBykey(E key) throws EmptyLinkedListException, KeyNotFoundException {
        if (isEmpty())
            throw new EmptyLinkedListException("Empty list, no elements to delete.");
        NodeDouble<E> toDelete = (NodeDouble<E>) searchByKey(key);
        if (toDelete == this.head.getNext())
            return deleteHead();
        else if (toDelete == this.tail)
            return deleteTail();
        else {
            NodeDouble<E> temp = this.head.getNext();
            E data = toDelete.getData();
            while (temp.getNext() != toDelete)
                temp = temp.getNext();
            toDelete.getNext().setPrev(temp);
            temp.setNext(toDelete.getNext());
            this.length--;
            return data;
        }
    }

    /** {@inheritDoc} */
    @Override
    public Node<E> searchByKey(E key) throws KeyNotFoundException {
        NodeDouble<E> temp = this.head.getNext();
        do {
            if (temp.getData().equals(key))
                return temp;
            temp = temp.getNext();
        } while (temp != this.head.getNext());
        throw new KeyNotFoundException("Key not found.");
    }

    @Override
    public void createOrderedList(E data) {
    }

    /** {@inheritDoc} */
    @Override
    public void reverse() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("Empty list, can't reverse.");
        NodeDouble<E> current, previous, next;
        previous = next = null;
        current = this.head.getNext();
        do {
            next = current.getNext();
            current.setPrev(next);
            current.setNext(previous);
            previous = current;
            current = next;
        } while (current != this.head.getNext());
        this.tail = this.head.getNext();
        this.head.setNext(previous);
        this.tail.setNext(this.head.getNext());
        this.head.getNext().setPrev(this.tail);
    }

    /** {@inheritDoc} */
    @Override
    public LinkedList<E> copyList() {
        DoubleCircularLinkedList<E> copy = new DoubleCircularLinkedList<>();
        NodeDouble<E> original = this.head.getNext();
        do {
            copy.insertTail(original.getData());
            original = original.getNext();
        } while (original != this.head.getNext());
        return copy;
    }

    /** {@inheritDoc} */
    @Override
    public void display() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("Empty list, no elements to display.");
        NodeDouble<E> temp = this.head.getNext();
        System.out.println("The elements of the list are, ");
        do {
            System.out.print(temp.getData() + "<=>");
            temp = temp.getNext();
        } while (temp != this.head.getNext());
        System.out.println(temp.getData());
    }

    @Override
    public String toString() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("List is empty, no elements to print.");
        StringBuilder list = new StringBuilder();
        NodeDouble<E> temp = this.head.getNext();
        list.append("The elements of the list are,\n");
        do {
            list.append(temp.getData() + "<=>");
            temp = temp.getNext();
        } while (temp != this.head.getNext());
        list.append(temp.getData());
        return list.toString();
    }
}
