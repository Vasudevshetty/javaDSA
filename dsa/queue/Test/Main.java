package dsa.queue.Test;

import dsa.queue.CircularQueue;

public class Main {
    public static void main(String args[]){
        CircularQueue<Integer> q = new CircularQueue<>(100);
        q.enqueue(8);
        q.enqueue(8);
        q.enqueue(5);
        q.enqueue(2);
        System.out.println(q);
        q.dequeue();
        q.dequeue();
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
    }
}
