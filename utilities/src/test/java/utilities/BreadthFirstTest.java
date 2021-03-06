package utilities;

import org.junit.Before;
import org.junit.Test;
import tree.BinarySearchTree;
import static org.junit.Assert.*;
import static tree.BinaryTree.*;

public class BreadthFirstTest {
    BinarySearchTree tree;
    @Before public void setUp() {
        tree = new BinarySearchTree();
        tree.add(4);
        tree.add(2);
        tree.add(3);
        tree.add(6);
        tree.add(5);
    }

    @Test public void breadthFirstReturnsAllValuesInTree() {
        assertEquals(5, breadthFirst(tree).size());
    }
    @Test public void breadthFirstReturnsValuesInBreathFirstOrder() {
        assertEquals(breadthFirst(tree).toString(), "[4, 2, 6, 3, 5]");
    }
    @Test public void breadthFirstReturnsEmptyListWhenTreeIsEmpty() {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals(breadthFirst(tree).toString(), "[]");
    }
    @Test public void breadthFirstWorksOnUnbalancedTrees() {
        tree.add(45);
        tree.add(46);
        tree.add(47);
        assertEquals(breadthFirst(tree).toString(), "[4, 2, 6, 3, 5, 45, 46, 47]");
    }
}
