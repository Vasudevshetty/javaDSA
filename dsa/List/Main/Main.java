package dsa.List.Main;

import dsa.List.SingleCircularLinkedList;

public class Main {
    public static void main(String[] args) {
        SingleCircularLinkedList<Integer> l = new SingleCircularLinkedList<>();
        for (int i = 1; i <= 10; i++)
            l.insert(i, i - 1);
        System.out.println(l);
        l.reverse();
        l.deleteBykey(5);
        System.out.println(l);
  }
}