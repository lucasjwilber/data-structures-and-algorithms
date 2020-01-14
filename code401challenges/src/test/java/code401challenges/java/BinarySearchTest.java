package code401challenges.java;

import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.*;


public class BinarySearchTest {

    @Test public void testBinarySearchLeftInBounds() {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, BinarySearch.binarySearchForValue(testArray, 1));
    }
    @Test public void testBinarySearchOutOfBounds() {
        int[] testArray = {11,22,33,44,55,66,77};
        assertEquals(-1, BinarySearch.binarySearchForValue(testArray, 999));
    }

}
