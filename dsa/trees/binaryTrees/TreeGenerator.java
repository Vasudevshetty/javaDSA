package dsa.trees.binaryTrees;

import java.util.ArrayList;

public class TreeGenerator {
    static int preIndex = 0;

    private static <E> int findIndex(final ArrayList<E> inOrder, E key, int inStart, int inEnd) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder.get(i) == key)
                return i;
        }
        return -1;
    }

    private static <E> TreeNode<E> buildTree(final ArrayList<E> preOrder, final ArrayList<E> inOrder, int inStart,
            int inEnd) {
        if (inStart > inEnd)
            return null;

        TreeNode<E> root = new TreeNode<E>(preOrder.get(preIndex));

        int rootIndex = findIndex(inOrder, root.getData(), inStart, inEnd);

        root.setLeftChild(buildTree(preOrder, inOrder, inStart, rootIndex - 1));
        root.setRightChild(buildTree(preOrder, inOrder, rootIndex + 1, inEnd));

        return root;
    }

    public static <E> BinaryTree<E> treeGenerator(final ArrayList<E> preOrder, final ArrayList<E> inOrder) {
        BinaryTree<E> tree = new BinaryTree<>();
        tree.root = buildTree(inOrder, preOrder, 0, inOrder.size() - 1);
        return tree;
    }
}
