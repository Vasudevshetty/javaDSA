package dsa.queue;

import dsa.list.DoubleLinkedList;
import dsa.list.NodeDouble;
import dsa.queue.Exception.QueueEmptyException;

public class Deque<E> {
    DoubleLinkedList<E> que;

    public Deque() {
        que = new DoubleLinkedList<>();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    public void enqueueFront(E data) {
        que.insertHead(data);
    }

    public void enqueueRear(E data) {
        que.insertTail(data);
    }

    public E dequeueFront() throws QueueEmptyException {
        if (isEmpty())
            throw new QueueEmptyException("Queue under flow, dequeuing failed.");
        return que.deleteHead();
    }

    public E dequeueRear() throws QueueEmptyException{
        if(isEmpty()) throw new QueueEmptyException("Queue under flow, dequeuin failed.");
        return que.deleteTail();
    }

    public E front() {
        return isEmpty() ? null : que.getHead().getData();
    }

    public E rear() {
        return isEmpty() ? null : que.getTail().getData();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("The elements of the dequeue are, \n");
        NodeDouble<E> temp = que.getHead();
        while (temp != null) {
            string.append(temp.getData()).append(" ");
            temp = temp.getNext();
        }
        return string.toString();
    }
}
