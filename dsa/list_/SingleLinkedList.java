package dsa.list;

import dsa.list.Exception.EmptyLinkedListException;
import dsa.list.Exception.InvalidPositionException;
import dsa.list.Exception.KeyNotFoundException;

/**
 * This class is a implemetnation of the linkedlist interface where it is only
 * connected by a single link and
 * unidirectional, operations on tail will end up taking linear time and at head
 * it is constant.
 */
public class SingleLinkedList<E> implements LinkedList<E> {
    private NodeSingle<E> head;
    private int length;

    // getters and setters.
    /**
     * The function find and access the head.
     * 
     * @return the refernce to head.
     */
    public NodeSingle<E> getHead() {
        return this.head;
    }

    /**
     * function to set the head.
     * 
     * @param head the new head to be's refernce.
     */
    public void setHead(NodeSingle<E> head) {
        this.head = head;
    }

    /**
     * {@inheritDoc}
     */
    public int getLength() {
        return this.length;
    } // you can't set the length of the linked list.

    /**
     * {@inheritDoc}
     */
    public void insertHead(E data) {
        NodeSingle<E> newNode = new NodeSingle<>(data);

        if (this.head == null) {
            setHead(newNode);
        } else {
            newNode.setNext(this.head);
            setHead(newNode);
        }
        this.length++;
    }

    // insert at head.
    /**
     * {@inheritDoc}
     */
    public void insertTail(E data) {
        if (this.isEmpty()) {
            insertHead(data);
            return;
        }

        NodeSingle<E> newNode = new NodeSingle<>(data);
        NodeSingle<E> temp = getHead();

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(newNode);

    }

    /**
     * {@inheritDoc}
     */
    // extra function to insert at Tail part of the list.
    public void insert(E data, int position) throws InvalidPositionException {
        if (position < 0 || position > this.length)
            throw new InvalidPositionException("Invalid position to insert.\n");
        if (position == 0) {
            insertHead(data);
            return;
        }
        if (position == this.length - 1) {
            insertTail(data);
            return;
        }

        NodeSingle<E> temp = this.head;
        NodeSingle<E> newNode = new NodeSingle<>(data);

        for (int i = 0; i < position - 1; i++)
            temp = temp.getNext();
        if (temp != null) {
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            this.length++;
        }

    } // overloaded function to accept the position and insert.

    /**
     * {@inheritDoc}
     */
    public E deleteHead() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("No elements to delete.\n");

        NodeSingle<E> toDelete = this.head;
        E data = toDelete.getData();

        this.length--;
        if (getLength() == 0)
            setHead(null);

        setHead(toDelete.getNext());
        return data;
    } // function to remove at head part of the list.

    /**
     * {@inheritDoc}
     */
    public E deleteTail() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("No elements to delete.\n");

        NodeSingle<E> temp = this.head;
        while (temp.getNext() != null)
            temp = temp.getNext();

        NodeSingle<E> toDelete = temp.getNext();
        E data = toDelete.getData();
        temp.setNext(null);
        this.length--;

        return data;
    } // function to remove at Tail part of the list.

    /**
     * {@inheritDoc}
     */
    public E delete(int position) throws EmptyLinkedListException, InvalidPositionException {
        if (isEmpty())
            throw new InvalidPositionException("Invalid position to insert.\n");
        if (isEmpty())
            throw new EmptyLinkedListException("No elements to delete.\n");

        if (position == 0)
            return deleteHead();
        if (position == this.length - 1)
            return deleteTail();

        NodeSingle<E> temp = this.head;
        for (int i = 0; i < position - 1; i++)
            temp = temp.getNext();

        NodeSingle<E> toDelete = temp.getNext();
        E data = toDelete.getData();

        temp.setNext(toDelete.getNext());
        this.length--;
        return data;

    } // function to remove from position.

    /**
     * {@inheritDoc}
     */
    public Node<E> searchByKey(E key) throws KeyNotFoundException {
        if (isEmpty())
            throw new EmptyLinkedListException("No elements to search.\n");

        NodeSingle<E> temp = this.head;
        while (temp != null) {
            if (temp.getData().equals(key))
                return temp;
            temp = temp.getNext();
        }
        throw new KeyNotFoundException("key not found");
    }

    /**
     * {@inheritDoc}
     */
    public E deleteBykey(E key) throws EmptyLinkedListException, KeyNotFoundException {
        NodeSingle<E> toDelete = (NodeSingle<E>) searchByKey(key);
        E data = toDelete.getData();

        if (toDelete == this.head)
            return deleteHead();
        else {
            NodeSingle<E> temp = this.head;
            while (temp != null && temp.getNext() != toDelete) {
                temp = temp.getNext();
            }
            if (temp != null)
                temp.setNext(toDelete.getNext());
            this.length--;
        }
        return data;
    }

    /**
     * {@inheritDoc}
     */
    public void createOrderedList(E data) {

    }

    /**
     * {@inheritDoc}
     */
    public void reverse() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("No elements to reverse");

        NodeSingle<E> currentNode = this.head;
        NodeSingle<E> prevNode = null;
        NodeSingle<E> nextNode;

        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }
        this.head = prevNode;
    }

    /**
     * {@inheritDoc}
     */
    public LinkedList<E> copyList() {
        SingleLinkedList<E> copy = new SingleLinkedList<>();

        NodeSingle<E> temp = this.head;

        while (temp != null) {
            copy.insertTail(temp.getData());
            temp = temp.getNext();
        }
        return copy;
    }

    public boolean isEmpty() {
        return (this.head == null && this.length == 0);
    }

    @Override
    public String toString() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("No Elements to display");
        StringBuilder data = new StringBuilder();
        NodeSingle<E> temp = this.head;

        data.append("Elements of the linked list are \n");
        while (temp != null) {
            data.append(temp.getData()).append("->");
            temp = temp.getNext();
        }
        data.append("null");
        return data.toString();
    }

    /**
     * {@inheritDoc}
     */
    public void display() throws EmptyLinkedListException {
        NodeSingle<E> temp = this.head;
        // check whether the list is empty
        if (isEmpty())
            throw new EmptyLinkedListException("List is empty, unable to display");

        System.out.println("Elements of the linked list are ,");
        while (temp != null) {
            System.out.print(temp.getData() + "->");
            temp = temp.getNext();
        }
        System.out.println("null");
    }
}
