package tree;

import java.util.ArrayList;

public class BinarySearchTree {
    Node root;

    public void add(int value) {
        if (root == null) root = new Node(value);
        Node node = root;
        while (node.right != null && value > node.value) {
            node = node.right;
        }
        while (node.left != null && value < node.value) {
            node = node.left;
        }
        if (node.value < value) node.right = new Node(value);
        if (node.value > value) node.left = new Node(value);
    }

    public boolean contains(Node root, int value) {
        if (root.value == value) return true;
        if (root.left != null) {
            if (root.left.value == value) return true;
            contains(root.left, value);
        }
        if (root.right != null) {
            if (root.right.value == value) return true;
            contains(root.right, value);
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(5);
        bst.add(20);
        bst.add(15);
        bst.add(13);
        System.out.println(bst.root.right.value);
        System.out.println(bst.root.right.left.left.value);
        System.out.println(bst.contains(bst.root, 21));
    }
}