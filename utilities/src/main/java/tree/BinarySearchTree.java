package tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {
    Node root;

    public Object[] preOrder(Node root) {
        ArrayList<Integer> results = new ArrayList<>();
        fillListPreOrder(root, results);
        return results.toArray();
    }
    public void fillListPreOrder(Node root, ArrayList<Integer> list) {
        list.add(root.value);
        if (root.left != null) {
            fillListPreOrder(root.left, list);
        }
        if (root.right != null) {
            fillListPreOrder(root.right, list);
        }
    }

    public Object[] inOrder(Node root) {
        ArrayList<Integer> results = new ArrayList<>();
        fillListInOrder(root, results);
        return results.toArray();
    }
    public void fillListInOrder(Node root, ArrayList<Integer> list) {
        if (root.left != null) {
            fillListInOrder(root.left, list);
        }
        list.add(root.value);
        if (root.right != null) {
            fillListInOrder(root.right, list);
        }
    }

    public Object[] postOrder(Node root) {
        ArrayList<Integer> results = new ArrayList<>();
        fillListPostOrder(root, results);
        return results.toArray();
    }
    public void fillListPostOrder(Node root, ArrayList<Integer> list) {
        if (root.left != null) {
            fillListPostOrder(root.left, list);
        }
        if (root.right != null) {
            fillListPostOrder(root.right, list);
        }
        list.add(root.value);
    }

    public static void main(String[] args ) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(4);
        bst.root.left = new Node(3);
        bst.root.right = new Node(5);
        bst.root.left.left = new Node(2);
        bst.root.left.right = new Node(1);
        bst.root.right.right = new Node(34);
        //bst:
        //      4
        //    3   5
        //  2  1   34
        System.out.println(Arrays.toString(bst.preOrder(bst.root)));
        System.out.println(Arrays.toString(bst.inOrder(bst.root)));
        System.out.println(Arrays.toString(bst.postOrder(bst.root)));
    }
}