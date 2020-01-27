package tree;

import java.util.ArrayList;

public class BinaryTree {
    Node root;

    public static Object[] preOrder(BinarySearchTree tree) {
        ArrayList<Integer> results = new ArrayList<>();
        fillListPreOrder(tree.root, results);
        return results.toArray();
    }
    public static void fillListPreOrder(Node root, ArrayList<Integer> list) {
        list.add(root.value);
        if (root.left != null) {
            fillListPreOrder(root.left, list);
        }
        if (root.right != null) {
            fillListPreOrder(root.right, list);
        }
    }

    public static Object[] inOrder(BinarySearchTree tree) {
        ArrayList<Integer> results = new ArrayList<>();
        fillListInOrder(tree.root, results);
        return results.toArray();
    }
    public static void fillListInOrder(Node root, ArrayList<Integer> list) {
        if (root.left != null) {
            fillListInOrder(root.left, list);
        }
        list.add(root.value);
        if (root.right != null) {
            fillListInOrder(root.right, list);
        }
    }

    public static Object[] postOrder(BinarySearchTree tree) {
        ArrayList<Integer> results = new ArrayList<>();
        fillListPostOrder(tree.root, results);
        return results.toArray();
    }
    public static void fillListPostOrder(Node root, ArrayList<Integer> list) {
        if (root.left != null) {
            fillListPostOrder(root.left, list);
        }
        if (root.right != null) {
            fillListPostOrder(root.right, list);
        }
        list.add(root.value);
    }
}