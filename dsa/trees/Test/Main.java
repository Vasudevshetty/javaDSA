package dsa.trees.Test;

import dsa.trees.BinarySearchTree;
import dsa.trees.binaryTrees.TraversalGenerator;

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

      System.out.println(TraversalGenerator.inOrder(tree));
      tree.inOrder();
      System.out.println(TraversalGenerator.preOrder(tree));
      tree.preOrder();
      System.out.println(TraversalGenerator.postOrder(tree));
      tree.postOrder();
      System.out.println(TraversalGenerator.levelOrder(tree));
      tree.levelOrder();

      System.out.println();
      System.out.println(tree.getHeight() + " " + tree.getNodeCount());
   }
}
