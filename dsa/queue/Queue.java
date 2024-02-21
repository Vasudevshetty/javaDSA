package dsa.queue;

import dsa.list.DoubleLinkedList;
import dsa.list.NodeDouble;
import dsa.queue.Exception.QueueEmptyException;

public class Queue<E> implements Que<E> {
    private DoubleLinkedList<E> que;

    public Queue() {
        que = new DoubleLinkedList<>();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    @Override
    public void enqueue(E value) {
        que.insertTail(value);
    }

    @Override
    public E dequeue() throws QueueEmptyException{
        if (isEmpty())
            throw new QueueEmptyException("Queue is empty, Dequeue failed.\n");
        return que.deleteHead();
    }

    public int length() {
        return que.getLength();
    }

    @Override
    public E front() {
        return isEmpty() ? null : que.getHead().getData();
    } 

    @Override
    public E rear() {
        if (isEmpty())
            return null;
        return que.getTail().getData();
    }
    
    @Override
    public String toString() {
        if(isEmpty()) throw new QueueEmptyException("Queue is empty, printing failed.\n");
        StringBuilder queue = new StringBuilder();
        NodeDouble<E> temp = que.getHead();
        queue.append("Elements of the queue are, \n");
        while (temp != null) {
            queue.append(temp.getData()).append(" ");
            temp = temp.getNext();
        }
        return queue.toString();
    }
}
