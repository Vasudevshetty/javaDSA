package dsa.list;

import dsa.list.Exception.*;

/**
 * The class for single circular linked list, where the nodes or connected
 * singly, only operations at specific postioins takes
 * lienar time(O(K)), where k is the position and at head or tail it is constant
 * time.
 * and the list is circular making it easier to travese any way wanted.
 */
public class SingleCircularLinkedList<E> implements LinkedList<E> {
    private NodeSingle<E> head;
    private NodeSingle<E> tail;
    private int length;

    public SingleCircularLinkedList() {
        this.head = new NodeSingle<>(null);
        this.tail = null;
        this.length = 0;
    }

    public NodeSingle<E> getHead() {
        return this.head;
    }

    public NodeSingle<E> getTail() {
        return this.tail;
    }

    /**
     *   {@inheritDoc}
     */
    public int getLength() {
        return this.length;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isCircular() {
        if (isEmpty())
            return false;
        NodeSingle<E> slow = this.head.getNext();
        NodeSingle<E> fast = this.head.getNext();

        while (slow != null && fast != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return this.head.getNext() == null && this.length == 0;
    }

    /**
     * {@inheritDoc}
     */
    public void insertHead(E data) {
        NodeSingle<E> newNode = new NodeSingle<>(data);
        if (isEmpty()) {
            this.head.setNext(newNode);
            this.tail = newNode;
            this.tail.setNext(this.head.getNext());
        } else {
            newNode.setNext(this.head.getNext());
            this.head.setNext(newNode);
            this.tail.setNext(this.head.getNext());
        }
        this.length++;
    }

    /**
     * {@inheritDoc}
     */
    public void insertTail(E data) {
        if (isEmpty()) {
            insertHead(data);
            return;
        }
        NodeSingle<E> newNode = new NodeSingle<>(data);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.tail.setNext(this.head.getNext());
        this.length++;
    }

    /**
     * {@inheritDoc}
     */
    public void insert(E data, int position) throws InvalidPositionException {
        if (position < 0 || position > this.length)
            throw new InvalidPositionException("Invalid position to insert.");
        if (position == 0)
            insertHead(data);
        else if (position == this.length)
            insertTail(data);
        else {
            NodeSingle<E> newNode = new NodeSingle<>(data);
            NodeSingle<E> temp = this.head.getNext();
            for (int i = 0; i < position - 1; i++)
                temp = temp.getNext();
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            this.length++;
        }
    }

    /**
     * {@inheritDoc}
     */
    public E deleteHead() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("Empty list, no elements to delete.");
        NodeSingle<E> toDelete = this.head.getNext();
        E data = toDelete.getData();
        this.head.setNext(toDelete.getNext());
        if (this.length == 1) {
            this.head.setNext(null);
            this.tail = null;
        } else
            this.tail.setNext(this.head.getNext());
        this.length--;
        return data;
    }

    /**
     * {@inheritDoc}
     */
    public E deleteTail() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("Empty list, no elements to delete");
        if (this.length == 1)
            return deleteHead();
        NodeSingle<E> toDelete = this.tail;
        E data = toDelete.getData();
        NodeSingle<E> temp = this.head.getNext();
        while (temp.getNext() != toDelete)
            temp = temp.getNext();
        this.tail = temp;
        this.tail.setNext(this.head.getNext());
        this.length--;
        return data;
    }

    /**
     * {@inheritDoc}
     */
    public E delete(int position) throws InvalidPositionException {
        if (position < 0 || position >= this.length)
            throw new InvalidPositionException("Invalid position, deletion failed.");
        if (position == 0 && this.length == 1)
            return deleteHead();
        if (position == this.length - 1)
            return deleteTail();

        NodeSingle<E> temp = this.head.getNext();
        for (int i = 0; i < position - 1; i++)
            temp = temp.getNext();
        NodeSingle<E> toDelete = temp.getNext();
        E data = toDelete.getData();
        temp.setNext(toDelete.getNext());
        this.length--;
        return data;
    }

    /**
     * {@inheritDoc}
     */
    public NodeSingle<E> searchByKey(E key) throws EmptyLinkedListException, KeyNotFoundException {
        if (isEmpty())
            throw new EmptyLinkedListException("Empty list, search failed.");
        NodeSingle<E> temp = this.head.getNext();
        do {
            if (temp.getData().equals(key))
                return temp;
            temp = temp.getNext();
        } while (temp != this.head.getNext());
        throw new KeyNotFoundException("Key not found.");
    }

    /**
     * {@inheritDoc}
     */
    public E deleteBykey(E key) throws EmptyLinkedListException, KeyNotFoundException {
        if (isEmpty())
            throw new EmptyLinkedListException("Empty list, deletion failed.");
        NodeSingle<E> toDelete = searchByKey(key);
        if (toDelete == this.head.getNext())
            return deleteHead();
        else if (toDelete == this.tail)
            return deleteTail();
        else {
            E data = toDelete.getData();
            NodeSingle<E> temp = this.head.getNext();
            while (temp.getNext() != toDelete)
                temp = temp.getNext();
            temp.setNext(toDelete.getNext());
            this.length--;
            return data;
        }
    }

    /**
     * {@inheritDoc}
     */
    public LinkedList<E> copyList() {
        LinkedList<E> copy = new SingleCircularLinkedList<>();
        NodeSingle<E> original = this.head.getNext();
        do {
            copy.insertTail(original.getData());
            original = original.getNext();
        } while (original != this.head.getNext());
        return copy;
    }

    /**
     * {@inheritDoc}
     */
    public void reverse() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("List empty, cannot reverse..");
        NodeSingle<E> current, previous, next;
        current = this.head.getNext();
        previous = next = null;
        do {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        } while (current != this.head.getNext());
        this.tail = this.head.getNext();
        this.head.setNext(previous);
        this.tail.setNext(this.head.getNext());
    }

    /**
     * {@inheritDoc}
     */
    public void display() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException("List is empty, no elements to display.");
        NodeSingle<E> temp = this.head.getNext();
        System.out.println("The Elements of the list are, ");
        do {
            System.out.print(temp.getData() + "->");
            temp = temp.getNext();
        } while (temp != this.head.getNext());
        System.out.println(temp.getData());
    }

    @Override
    public String toString() {
        if (isEmpty())
            throw new EmptyLinkedListException("List is empty, no elements to dispaly.");
        StringBuilder list = new StringBuilder();
        NodeSingle<E> temp = this.head.getNext();
        list.append("The Elements of the list are, \n");
        do {
            list.append(temp.getData()).append("->");
            temp = temp.getNext();
        } while (temp != this.head.getNext());
        list.append(temp.getData());
        return list.toString();
    }

    /**
     * {@inheritDoc}
     */
    public void createOrderedList(E data) {
        if (isEmpty()) {
            insertHead(data);
        }
    }

}