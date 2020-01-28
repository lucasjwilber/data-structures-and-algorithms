package utilities;

import tree.BinarySearchTree;
import tree.Node;

public class FizzbuzzTree {
    FizzBuzzNode root;

    public static String fizzBuzzify(Integer value) {
        if (value % 15 == 0) {
            return "FizzBuzz";
        } else if (value % 5 == 0) {
            return "Buzz";
        } else if (value % 3 == 0) {
            return "Fizz";
        } else {
            return value.toString();
        }
    }

    public static void fizzBuzzCopier(Node oldNode, FizzBuzzNode newNode) {
        if (oldNode != null) {
            if (oldNode.left != null) {
                FizzBuzzNode leftNode = new FizzBuzzNode(fizzBuzzify(oldNode.left.value));
                newNode.left = leftNode;
                fizzBuzzCopier(oldNode.left, leftNode);
            }
            if (oldNode.right != null) {
                FizzBuzzNode rightNode = new FizzBuzzNode(fizzBuzzify(oldNode.right.value));
                newNode.right = rightNode;
                fizzBuzzCopier(oldNode.right, rightNode);
            }
            newNode.value = fizzBuzzify(oldNode.value);
        }
    }

    public static FizzbuzzTree FizzBuzzTree(BinarySearchTree tree) {
        FizzbuzzTree newTree = new FizzbuzzTree();
        if (tree.root != null) {
            newTree.root = new FizzBuzzNode(fizzBuzzify(tree.root.value));
        }
        fizzBuzzCopier(tree.root, newTree.root);
        return newTree;
    }
}
