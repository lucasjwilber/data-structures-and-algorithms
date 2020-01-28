package utilities;

import org.junit.Before;
import org.junit.Test;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.*;
import tree.BinarySearchTree;
import static utilities.FizzbuzzTree.FizzBuzzTree;

public class FizzBuzzTreeTest {
    @Test public void fbTreeCanInit() {
        BinarySearchTree tree = new BinarySearchTree();
        FizzbuzzTree fbTree = FizzBuzzTree(tree);
    }
    @Test public void fbTreeFizzBuzzifiesValues() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(6);
        tree.add(7);
        tree.add(3);
        tree.add(15);
        tree.add(14);
        tree.add(18);
        FizzbuzzTree fbTree = FizzBuzzTree(tree);

        assertTrue(fbTree.root.value.equals("Buzz"));
        assertTrue(fbTree.root.right.value.equals("FizzBuzz"));
        assertTrue(fbTree.root.left.value.equals("Fizz"));
        assertTrue(fbTree.root.left.right.value.equals("7"));
    }
    @Test public void fbTreeMaintainsTreeStructure() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(6);
        tree.add(7);
        tree.add(3);
        tree.add(15);
        tree.add(14);
        tree.add(18);
        FizzbuzzTree fbTree = FizzBuzzTree(tree);

        assertEquals(tree.root.right.left.value, parseInt(fbTree.root.right.left.value));
        assertEquals(tree.root.left.right.value, parseInt(fbTree.root.left.right.value));
    }
}
