package dsa.LinkedList.Main;

import dsa.LinkedList.SingleLinkedList;

public class Main {
    
    public static void main(String[] args) {
    SingleLinkedList<Integer> l = new SingleLinkedList<>();
        for(int i = 1; i <= 10; i++)
             l.insert(i, i-1);
        
        System.out.println(l);
        System.out.println();
        l.reverse();
        l.display();
    }
}
