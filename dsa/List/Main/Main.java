package dsa.list.Main;

import dsa.list.DoubleCircularLinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleCircularLinkedList<Integer> l = new DoubleCircularLinkedList<>();
        for (int i = 1; i <= 5; i++)
            l.insert(i, i - 1);
        System.out.println(l);
        DoubleCircularLinkedList<Integer> copy = (DoubleCircularLinkedList<Integer>)l.copyList();
        System.out.println(copy);
        copy.reverse();;
        System.out.println(copy);
    }
}