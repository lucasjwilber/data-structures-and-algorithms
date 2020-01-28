package utilities;

import org.junit.Before;
import org.junit.Test;
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

        assertTrue("Buzz", fbTree.root);
    }
}
