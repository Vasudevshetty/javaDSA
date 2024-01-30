package dsa.stack;

import dsa.stack.Exception.StackOverflowException;
import dsa.stack.Exception.StackUnderflowException;

public class StackArray<E> {
    private Object[] array;
    private int capacity;
    private int length;
    private int top;

    public StackArray() {
        this.capacity = 10;
        this.length = 0;
        this.top = -1;
        array = new Object[capacity];
    }

    public StackArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.top = -1;
        array = new Object[capacity];
    }

    public boolean isEmpty() {
        return this.length == 0 && this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.capacity - 1;
    }

    public void push(E value) throws StackOverflowException {
        if (isFull())
            throw new StackOverflowException("Stack is full, cannot push.");
        this.array[++top] = value;
        this.length++;
    }

    @SuppressWarnings("unchecked")
    public E pop() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException("Stack is empty, cannot pop.");
        this.length--;
        return (E) this.array[top--];
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        return (E) this.array[top];
    }

    public int lenght() {
        return length;
    }

    public String toString() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException("Stack if empty, cannot print.");
        StringBuilder stack = new StringBuilder();
        stack.append("Elements of the array are, (from top of the stack.) \n");
        for (int i = this.length - 1; i >= 0; i--) {
            stack.append(String.valueOf(this.array[i])).append("\n");
        }
        return stack.toString();
    }
}
