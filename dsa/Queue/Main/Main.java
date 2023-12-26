package dsa.Queue.Main;

import dsa.Queue.Queue;

public class Main {
    public static void main(String args[]){
        Queue<Integer> q = new Queue<>();

        q.enqueue(8);
        q.enqueue(8);
        q.enqueue(8);
        q.enqueue(8);
        System.out.println(q);
        q.dequeue();
        q.dequeue();
        System.out.println(q);
    }
}
