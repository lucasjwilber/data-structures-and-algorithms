package tree;

import java.util.Arrays;

public class BinarySearchTree extends BinaryTree {
    Node root;

    public void add(int value) {
        if (root == null) root = new Node(value);
        positionFinder(root, value);
    }
    public void positionFinder(Node node, int value) {
        if (value > node.value) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                positionFinder(node.right, value);
            }
        }
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                positionFinder(node.left, value);
            }
        }
    }

    public boolean contains(int value) {
        return Arrays.asList(preOrder(this)).contains(value);
    }
}