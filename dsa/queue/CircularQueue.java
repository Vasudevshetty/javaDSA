package dsa.queue;

import dsa.queue.Exception.QueueEmptyException;
import dsa.queue.Exception.QueueFullException;

public class CircularQueue<E> implements Que<E> {
    private Object[] array;
    private int capacity;
    private int front;
    private int rear;

    public CircularQueue(int size) {
        capacity = size + 1;
        array = new Object[capacity];
        front = rear = 0;
    }

    boolean isEmpty() {
        return front == rear;
    }

    boolean isFull() {
        return front == (rear + 1) % capacity;
    }

    public void enqueue(E value) throws QueueFullException{
        if (!isFull()) {
            array[rear] = value;
            rear = (rear + 1) % capacity;
        } else
            throw new QueueFullException("Queue over flow, enqueuing failed.");
    }

    @SuppressWarnings("unchecked")
    public E dequeue() throws QueueEmptyException{
        if (!isEmpty()) {
            E data = (E)array[front];
            front = (front + 1) % capacity;
            return data;
        } else
            throw new QueueEmptyException("Queue udner flow, dequeuing failed.");
    }

    @SuppressWarnings("unchecked")
    public E front() {
        return isEmpty() ? null : (E) array[front];
    }

    @SuppressWarnings("unchecked")
    public E rear() {
        return isEmpty() ? null : (E) array[rear];
    }

}
