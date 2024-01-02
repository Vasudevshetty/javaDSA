package dsa.Queue;

import dsa.Queue.Exception.QueueEmptyException;

public interface Que<E> {
    public void enqueue(E value);
    public E dequeue() throws QueueEmptyException;
    public E peek() throws QueueEmptyException;
    public int length();
}
