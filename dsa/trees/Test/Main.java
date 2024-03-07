package dsa.trees.Test;

import dsa.trees.BinarySearchTree;
import dsa.trees.binaryTrees.BinaryTree;
import dsa.trees.binaryTrees.TraversalGenerator;
import dsa.trees.binaryTrees.TreeGenerator;

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

      BinaryTree<Integer> treec = TreeGenerator.treeGenerator(TraversalGenerator.preOrder(tree),
            TraversalGenerator.inOrder(tree));
      TraversalGenerator.inOrder(treec);
      TraversalGenerator.preOrder(treec);
      TraversalGenerator.postOrder(treec);
   }
}
