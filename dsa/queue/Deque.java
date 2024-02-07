package dsa.queue;

import dsa.list.DoubleLinkedList;
import dsa.list.NodeDouble;
import dsa.queue.Exception.QueueEmptyException;

/**
 * This class is custom created dequeu class which uses double linked list as primary data structure whose operations 
 * insert and delete takes constant time, the que can be used where insertion and deletion (enqueueing and dequeuing) at both 
 * ends are required.
 */
public class Deque<E> {
    DoubleLinkedList<E> que;

    /**
     * Constructor to allocate memeory to the double linked list used.
     */
    public Deque() {
        que = new DoubleLinkedList<>();
    }

    /**
     * This function is support fucntion which primarly checks whetehr the list used is empty or not
     * @return whether que is empty or not.
     */
    public boolean isEmpty() {
        return que.isEmpty();
    }

    /**
     * This function is to insert the data at the front of the queue.
     * @param data the data to be inserted.
     * The function basically calls the insert at head function of the linked list interface.
     */
    public void enqueueFront(E data) {
        que.insertHead(data);
    }

    /**
     * This function is to insert the data at the rear of the queue.
     * @param data the data to be inserted.
     * the function basically calls the insert at tail function fo the linked list interface.
     */
    public void enqueueRear(E data) {
        que.insertTail(data);
    }

    /**
     * This function is to delete the data at the front of the queue.
     * @return the data at the deleted position 
     * @throws QueueEmptyException if the queue is empty as the elemetn cannot be deleted.
     */
    public E dequeueFront() throws QueueEmptyException {
        if (isEmpty())
            throw new QueueEmptyException("Queue under flow, dequeuing failed.");
        return que.deleteHead();
    }

    /**
     * This function ist o delete the data at the rear of the queue.
     * @return the data at the deleted position.
     * @throws QueueEmptyException if the queue is emepty sas the elements cannot be deleted.
     */
    public E dequeueRear() throws QueueEmptyException{
        if(isEmpty()) throw new QueueEmptyException("Queue under flow, dequeuin failed.");
        return que.deleteTail();
    }

    /**
     * The support function to get the data at front
     * @return the data at the front
     */
    public E front() {
        return isEmpty() ? null : que.getHead().getData();
    }

    /**
     * The supprot fucntiont o get the data at rear.
     * @return the data at the rear.
     */
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
