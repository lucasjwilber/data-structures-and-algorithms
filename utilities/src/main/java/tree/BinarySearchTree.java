package tree;

import java.util.Arrays;

public class BinarySearchTree extends BinaryTree {
    public Node root;

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
//        return Arrays.asList(preOrder(this)).contains(value);
        return containsHelper(this.root, value);
    }
    public boolean containsHelper(Node node, int value) {
        if (node == null) {
            return false;
        } else if (node.value == value) {
            return true;
        } else if (value > node.value) {
            return containsHelper(node.right, value);
        } else {
            return containsHelper(node.left, value);
        }
    }
}