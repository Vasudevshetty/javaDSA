package dsa.queue;

import dsa.queue.Exception.QueueEmptyException;

public interface Que<E> {
    public void enqueue(E value);
    public E dequeue() throws QueueEmptyException;
    public E front();
    public E rear();
}
