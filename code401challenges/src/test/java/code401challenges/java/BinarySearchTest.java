package code401challenges.java;

import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.*;


public class BinarySearchTest {

    @Test public void testBinarySearch() {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, BinarySearch.binarySearchForValue(testArray, 1));
    }

}
