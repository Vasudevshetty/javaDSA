package dsa.LinkedList;
import dsa.LinkedList.Exception.*;

public interface LinkedList<E> {
    void insertHead(E data); // insert at head.
    void insertRear(E data); // extra function to insert at rear part of the list.
    void insert(E data, int position) throws InvalidPositionException; // overloaded function to accept the position and insert.
    E removeHead() throws EmptyLinkedListException; // function to remove at head part of the list.
    E removeRear() throws EmptyLinkedListException; // function to remove at rear part of the list.
    E remove(int position) throws EmptyLinkedListException, InvalidPositionException; // function to remove from position.
    E deleteBykey(E key) throws EmptyLinkedListException, InvalidPositionException, KeyNotFoundException;
    NodeSingle<E> searchByKey(E key) throws KeyNotFoundException;
    void createOrderedList(E data);
    void reverse();
    LinkedList<E> copyList();
    boolean isEmtpy();
    int getLength();
    void display();
}
