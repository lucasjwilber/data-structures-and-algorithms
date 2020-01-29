package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

    public static ArrayList<Integer> breadthFirst(BinarySearchTree tree) {
        ArrayList<Integer> list = new ArrayList<>();
        if (tree.root != null) {
            LinkedList<Node> queue = new LinkedList<Node>();
            queue.add(tree.root);
            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                if (current.left != null) queue.addLast(current.left);
                if (current.right != null) queue.addLast(current.right);
                list.add(current.value);
            }
        }
        return list;
    }
}