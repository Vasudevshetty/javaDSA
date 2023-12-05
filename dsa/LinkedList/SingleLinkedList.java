package dsa.LinkedList;

import dsa.LinkedList.Exception.EmptyLinkedListException;
import dsa.LinkedList.Exception.InvalidPositionException;
import dsa.LinkedList.Exception.KeyNotFoundException;

public class SingleLinkedList<E> extends NodeSingle<E> implements LinkedList<E>{
    private NodeSingle<E> head;
    private int length;

    // getters and setters.
    public NodeSingle<E> getHead(){return this.head;}
    public void setHead(NodeSingle<E> head){this.head = head;}
    public int getLength(){return this.length;} // you can't set the length of the linked list.

    public void insertHead(E data){
        
    } // insert at head.
    public void insertRear(E data){

    } // extra function to insert at rear part of the list.
    public void insert(E data, int position) throws InvalidPositionException{

    } // overloaded function to accept the position and insert.
    public E removeHead() throws EmptyLinkedListException{

    } // function to remove at head part of the list.
    public E removeRear() throws EmptyLinkedListException{

    } // function to remove at rear part of the list.
    public E remove(int position) throws EmptyLinkedListException, InvalidPositionException{

    } // function to remove from position.
    public E deleteBykey(E key) throws EmptyLinkedListException, InvalidPositionException, KeyNotFoundException{

    }
    public NodeSingle<E> searchByKey(E key) throws KeyNotFoundException{

    }
    public void createOrderedList(E data){

    }
    public void reverse(){

    }
    public LinkedList<E> copyList(){

    }
    public boolean isEmtpy(){

    }
    public void display(){

    }
}

