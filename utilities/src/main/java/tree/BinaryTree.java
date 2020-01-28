package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTree {
    Node root;

    public static Object[] preOrder(BinarySearchTree tree) {
        ArrayList<Integer> results = new ArrayList<>();
        fillListPreOrder(tree.root, results);
        return results.toArray();
    }
    public static void fillListPreOrder(Node node, ArrayList<Integer> list) {
        list.add(node.value);
        if (node.left != null) {
            fillListPreOrder(node.left, list);
        }
        if (node.right != null) {
            fillListPreOrder(node.right, list);
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