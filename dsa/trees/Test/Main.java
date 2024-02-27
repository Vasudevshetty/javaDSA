package dsa.trees.Test;

import dsa.trees.BinarySearchTree;

public class Main {
   public static void main(String[] args) {
      BinarySearchTree<Integer> tree = new BinarySearchTree<>();
      tree.insert(5);
      tree.insert(3);
      tree.insert(4);
      tree.insert(2);
      tree.insert(1);
      tree.insert(6);
      tree.insert(7);

      tree.preOrder();
      tree.inOrder();
      tree.postOrder();

      System.out.println(tree.getHeight() + " " + tree.getNodeCount());
   }
}
