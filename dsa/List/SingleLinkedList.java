package dsa.List;

import dsa.List.Exception.EmptyLinkedListException;
import dsa.List.Exception.InvalidPositionException;
import dsa.List.Exception.KeyNotFoundException;

public class SingleLinkedList<E> extends NodeSingle<E> implements LinkedList<E> {
    private NodeSingle<E> head;
    private int length;

    public SingleLinkedList() {
        this.head = null;
        this.length = 0;
    }

    // getters and setters.
    public NodeSingle<E> getHead() {
        return this.head;
    }

    public void setHead(NodeSingle<E> head) {
        this.head = head;
    }

    public int getLength() {
        return this.length;
    } // you can't set the length of the linked list.

    public void insertHead(E data) {
        NodeSingle<E> newNode = new NodeSingle<>(data);

        if (this.head == null) {
            setHead(newNode);
        } else {
            newNode.setNext(this.head.getNext());
            setHead(newNode);
        }
        this.length++;
    }

    // insert at head.
    public void insertRear(E data) {
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

    // extra function to insert at rear part of the list.
    public void insert(E data, int position) throws InvalidPositionException {
        if (position < 0 || position > this.length)
            throw new InvalidPositionException("Invalid position to insert.\n");
        if (position == 0) {
            insertHead(data);
            return;
        }
        if (position == this.length - 1) {
            insertRear(data);
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

    public E deleteRear() throws EmptyLinkedListException {
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
    } // function to remove at rear part of the list.

    public E delete(int position) throws EmptyLinkedListException, InvalidPositionException {
        if (isEmpty())
            throw new InvalidPositionException("Invalid position to insert.\n");
        if (isEmpty())
            throw new EmptyLinkedListException("No elements to delete.\n");

        if (position == 0)
            return deleteHead();
        if (position == this.length - 1)
            return deleteRear();

        NodeSingle<E> temp = this.head;
        for (int i = 0; i < position - 1; i++)
            temp = temp.getNext();

        NodeSingle<E> toDelete = temp.getNext();
        E data = toDelete.getData();

        temp.setNext(toDelete.getNext());
        this.length--;
        return data;

    } // function to remove from position.

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

    public E deleteBykey(E key) throws EmptyLinkedListException, InvalidPositionException {
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

    public void createOrderedList(E data) {

    }

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

    public LinkedList<E> copyList() {
        SingleLinkedList<E> copy = new SingleLinkedList<>();

        NodeSingle<E> temp = this.head;

        while (temp != null) {
            copy.insertRear(temp.getData());
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
