package dsa.Queue;

import dsa.LinkedList.NodeSingle;
import dsa.LinkedList.SingleLinkedList;
import dsa.Queue.Exception.QueueEmptyException;

public class Queue<E> implements que<E> {
    private SingleLinkedList<E> que;

    public Queue() {
        que = new SingleLinkedList<>();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    @Override
    public void enqueue(E value) {
        que.insertRear(value);
    }

    @Override
    public E dequeue() throws QueueEmptyException{
        if (isEmpty())
            throw new QueueEmptyException("Queue is empty, Dequeue failed.\n");
        return que.deleteHead();
    }

    @Override
    public int length() {
        return que.getLength();
    }

    @Override
    public E peek() throws QueueEmptyException{
        if (isEmpty())
            throw new QueueEmptyException("Queue is empty, no element to peek.\n");
        return que.getHead().getData();
    }

    @Override
    public String toString() {
        if(isEmpty()) throw new QueueEmptyException("Queue is empty, printing failed.\n");
        StringBuilder queue = new StringBuilder();
        NodeSingle<E> temp = que.getHead();
        queue.append("Elements of the queue are, \n");
        while (temp != null) {
            queue.append(temp.getData()).append(" ");
            temp = temp.getNext();
        }
        return queue.toString();
    }
}
