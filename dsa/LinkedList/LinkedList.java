package dsa.LinkedList;

import dsa.LinkedList.Exception.*;

public interface LinkedList<E> {
    void insertHead(E data); // insert at head.

    void insertRear(E data); // extra function to insert at rear part of the list.

    void insert(E data, int position) throws InvalidPositionException; // overloaded function to accept the position and  insert.

    E deleteHead() throws EmptyLinkedListException; // function to remove at head part of the list.

    E deleteRear() throws EmptyLinkedListException; // function to remove at rear part of the list.

    E delete(int position) throws EmptyLinkedListException, InvalidPositionException; // function to remove from position.                                                                                 

    E deleteBykey(E key) throws EmptyLinkedListException, InvalidPositionException;

    Node<E> searchByKey(E key) throws KeyNotFoundException;

    void createOrderedList(E data);

    void reverse() throws EmptyLinkedListException;

    LinkedList<E> copyList();

    boolean isEmpty();

    int getLength();

    void display() throws EmptyLinkedListException;
}
