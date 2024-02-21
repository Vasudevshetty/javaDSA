package dsa.trees.Test;

import dsa.trees.applications.ExpresssionTree;
import dsa.trees.applications.ExpresssionTree.Notation;

public class Main {
   public static void main(String[] args) {
      String expression = "ab+cd*-";
      ExpresssionTree tree = new ExpresssionTree(expression, Notation.postfix);
      tree.inOrder();
      System.out.println();
      tree.postOrder();
      System.out.println();
      tree.preOrder();
      System.out.println();
      tree.levelOrder();
   } 
}
