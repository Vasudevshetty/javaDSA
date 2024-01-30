package dsa.list;

import dsa.list.Exception.*;

/**
 * This is the interaface of linkedlist containing the functions for all the
 * operations for linked list,
 * like insert, delete, find reverse, key, copy and lenght of the list, also
 * check whether it is empty and display it.
 */
public interface LinkedList<E> {
    /**
     * This is the insertion function which inserts at the head of the list.
     * 
     * @param data this is the data of the new node which needed to be inserted.
     */
    void insertHead(E data); // insert at head.

    /**
     * This is the isnertion function which inserts at the tail of the list.
     * 
     * @param data this is the data of the new node which is to be inserted.
     */
    void insertTail(E data); // extra function to insert at rear part of the list.

    /**
     * This is insertion function which insertes at the specified postiion of the
     * list.
     * 
     * @param data     The data of the new node.
     * @param position The specified postion.
     * @throws InvalidPositionException thorws supoose the given postiion is
     *                                  invalid.
     */
    void insert(E data, int position) throws InvalidPositionException; // overloaded function to accept the position and
                                                                       // insert.

    /**
     * This function is to delete at head.
     * 
     * @return the value(data) at the node at head which is deleted.
     * @throws EmptyLinkedListException throws when the list is empty as it cannot
     *                                  delete.
     */
    E deleteHead() throws EmptyLinkedListException; // function to remove at head part of the list.

    /**
     * This function is to delete at tail.
     * 
     * @return the value(data) at the node at tail which is deleted.
     * @throws EmptyLinkedListException throws when the list is empty as it cannot
     *                                  delete.
     */
    E deleteTail() throws EmptyLinkedListException; // function to remove at rear part of the list.

    /**
     * This function is to delte the node at specific postiion.
     * 
     * @param position the postioin where the node to be delete.
     * @return the value(data) which is beign deleted.
     * @throws EmptyLinkedListException cannot delete if the list is empty so, it
     *                                  throws
     * @throws InvalidPositionException and it cannot even delete if the given
     *                                  postiion is invalid.
     */
    E delete(int position) throws EmptyLinkedListException, InvalidPositionException; // function to remove from
                                                                                      // position.

    /**
     * This function is to delete the key specific in the list.
     * 
     * @param key the key which is to be deleted.
     * @return the value of the key .
     * @throws EmptyLinkedListException if the list is empty it cannot delete rather
     *                                  find the key.
     * @throws KeyNotFoundException     say if the key is not found we can't delete
     *                                  the node.
     */
    E deleteBykey(E key) throws EmptyLinkedListException, KeyNotFoundException;

    /**
     * This function is a support function to deleteByKey function to find the
     * address of the node of the key.
     * 
     * @param key the key which is to be found.
     * @return the node contatining the key's address.
     * @throws KeyNotFoundException if the key is not found.
     */
    Node<E> searchByKey(E key) throws KeyNotFoundException;

    void createOrderedList(E data);

    /**
     * This function reverses the link of the list and hence the list also gets
     * reversed.
     * 
     * @throws EmptyLinkedListException
     */
    void reverse() throws EmptyLinkedListException;

    /**
     * Copies the list to a new list.
     * 
     * @return returns the copied list.
     */
    LinkedList<E> copyList();

    /**
     * Checks whetehr the list is empyt or not.
     * 
     * @return if empty returns true and else false.
     */
    boolean isEmpty();

    /**
     * To find the lenght of the list.(nodes's count)
     * 
     * @return the count.
     */
    int getLength();

    /**
     * Support function to display the list.
     * 
     * @throws EmptyLinkedListException if the list is empty we can't display.
     */
    void display() throws EmptyLinkedListException;
}
