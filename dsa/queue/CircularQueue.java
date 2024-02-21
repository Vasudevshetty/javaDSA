package dsa.queue;

import dsa.queue.Exception.QueueEmptyException;
import dsa.queue.Exception.QueueFullException;

public class CircularQueue<E> implements Que<E> {
    private Object[] array;
    private int capacity;
    private int front;
    private int rear;

    /**
     * To construct a array of capacity of size + 1 and to innitailse the front and rear to zero
     * @param size the size of the array needed.
     */
    public CircularQueue(int size) {
        capacity = size + 1;
        array = new Object[capacity];
        front = rear = 0;
    }

    /**
     * To check whether the queue is empty or not.
     * @return 
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * To check whterht the queue is full or not. 
     * @return
     */
    public boolean isFull() {
        return front == (rear + 1) % capacity;
    }

     
    /**
     * @param value the value to be enqueued.
     */
    public void enqueue(E value) throws QueueFullException {
        if (!isFull()) {
            array[rear] = value;
            rear = (rear + 1) % capacity;
        } else
            throw new QueueFullException("Queue over flow, enqueuing failed.");
    }

    /**
     * @return the value dequeued.
     */
    @SuppressWarnings("unchecked")
    public E dequeue() throws QueueEmptyException {
        if (!isEmpty()) {
            E data = (E) array[front];
            front = (front + 1) % capacity;
            return data;
        } else
            throw new QueueEmptyException("Queue udner flow, dequeuing failed.");
    }

    /**
     * @return the value at the front
     */
    @SuppressWarnings("unchecked")
    public E front() {
        return isEmpty() ? null : (E) array[front];
    }

    /**
     * @return the value at the rear.
     */
    @SuppressWarnings("unchecked")
    public E rear() {
        return isEmpty() ? null : (E) array[rear];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if (isEmpty())
            string.append("Queue is empty.");
        else {
            string.append("The elements of the queue are, \n");
            int i = front;
            do {
                string.append(String.valueOf(array[i])).append(" ");
                i = (i + 1) % capacity;
            } while (i != rear % capacity);
        }
        return string.toString();
    }
}
