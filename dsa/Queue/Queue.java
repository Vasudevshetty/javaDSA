package dsa.Queue;

import dsa.LinkedList.NodeSingle;
import dsa.LinkedList.SingleLinkedList;
import dsa.Queue.Exception.QueueEmptyException;

public class Queue<E> {
    SingleLinkedList<E> que;
    
    public Queue(){
        que = new SingleLinkedList<>();
    }

    public boolean isEmpty(){
        return que.isEmpty();
    }
    public void enqueue(E value){
        que.insertRear(value);
    }
    public E dequeue(){
        if(isEmpty()) throw new QueueEmptyException("Queue is empty, Dequeue failed.\n");
        return que.deleteHead();
    }
    public int length(){return que.getLength();}
    public E peek(){
        if(isEmpty()) throw new QueueEmptyException("Queue is empty, no element to peek.\n");
        return que.getHead().getData();
    }
    @Override
    public String toString(){
        StringBuilder queue = new StringBuilder();
        NodeSingle<E> temp = que.getHead();
        queue.append("Elements of the queue are, \n");
        while(temp != null){
            queue.append(temp.getData()).append(" ");
            temp = temp.getNext();
        }
        return queue.toString();
    }
}
