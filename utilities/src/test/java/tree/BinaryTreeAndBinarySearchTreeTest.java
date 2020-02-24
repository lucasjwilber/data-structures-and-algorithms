package tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static tree.BinaryTree.*;

public class BinaryTreeAndBinarySearchTreeTest {
    BinarySearchTree bst = new BinarySearchTree();
    @Before public void setUp() {
        bst.add(22);
        bst.add(27);
        bst.add(12);
        bst.add(40);
        bst.add(18);
        bst.add(11);
        bst.add(15);
        bst.add(25);
        bst.add(30);
        bst.add(31);
    }
    @Test public void binaryTree_canInstantiate() {
        BinaryTree bt = new BinaryTree();
        assertNull(bt.root);
    }
    @Test public void binarySearchTree_canInstantiate() {
        BinarySearchTree bst = new BinarySearchTree();
        assertNull(bst.root);
    }
    @Test public void binaryTree_canInstantiateRootNode() {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(5);
        assertEquals(5, bt.root.value);
    }
    @Test public void binarySearchTree_canInstantiateRootNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(2);
        assertEquals(2, bst.root.value);
    }
    @Test public void binarySearchTree_canAddLeftAndRightNodes() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(13);
        bst.add(6);
        assertEquals(13, bst.root.right.value);
        assertEquals(6, bst.root.left.value);
    }
    @Test public void binaryTree_preOrder() {
        assertEquals(bst.root.value, preOrder(bst)[0]);
        assertEquals(bst.root.left.value, preOrder(bst)[1]);
    }
    @Test public void binaryTree_inOrder() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(1);
        tree.add(20);
        assertEquals(tree.root.value, inOrder(tree)[1]);
        assertEquals(tree.root.left.value, inOrder(tree)[0]);
        assertEquals(tree.root.right.value, inOrder(tree)[2]);
    }
    @Test public void binaryTree_postOrder() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(54);
        tree.add(2);
        tree.add(2353);
        assertEquals(tree.root.value, postOrder(tree)[2]);
        assertEquals(tree.root.left.value, postOrder(tree)[0]);
        assertEquals(tree.root.right.value, postOrder(tree)[1]);
    }
    @Test public void binarySearchTree_contains() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(54);
        tree.add(2);
        tree.add(2353);
        tree.add(44);
        tree.add(56);
        tree.add(45);
        tree.add(46);

        assertTrue(tree.contains(46));
        assertTrue(tree.contains(2));
        assertFalse(tree.contains(99));
    }
    @Test public void findMaximumValueReturnsMaxValue() {
        assertEquals(40, findMaximumValue(bst));
    }
    @Test public void findMaximumValueReturnsZeroWithEmptyTree() {
        BinarySearchTree emptyTree = new BinarySearchTree();
        assertEquals(0, findMaximumValue(emptyTree));
    }
    @Test
    public void treeIntersection_worksOnEmptyTrees() {
        BinarySearchTree t1 = new BinarySearchTree();
        BinarySearchTree t2 = new BinarySearchTree();
        HashSet<Integer> emptySet = new HashSet<>();
        assertEquals(emptySet, treeIntersection(t1, t2));
    }
}
