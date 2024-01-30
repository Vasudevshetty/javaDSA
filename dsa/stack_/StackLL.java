package dsa.stack;

import dsa.list.SingleLinkedList;
import dsa.stack.Exception.StackUnderflowException;

public class StackLL<E> {
    SingleLinkedList<E> stack = new SingleLinkedList<>();
    
    public void push(E element) {
        stack.insertHead(element);
    }

    public E pop() throws StackUnderflowException {
        if (stack.isEmpty())
            throw new StackUnderflowException("Stack is empty to pop.!");
        else
            return stack.deleteHead();
    }

    public E peek() throws StackUnderflowException {
        if (stack.isEmpty())
            throw new StackUnderflowException("Stack is empty to peek.");
        else return stack.getHead().getData();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

