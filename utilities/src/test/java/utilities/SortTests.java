package utilities;

import org.junit.Test;

import static org.junit.Assert.*;
import static utilities.Sort.insertionSort;

public class SortTests {
    @Test
    public void insertionSort_sortsArrays() {
        int[] testArray = new int[]{8, 4, 23, 42, 16, 15};
        int[] expected = new int[]{4, 8, 15, 16, 23, 42};
        assertArrayEquals(expected, insertionSort(testArray));
    }

    @Test
    public void insertionSort_doesntModifySortedArrays() {
        int[] testArray = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(testArray, insertionSort(testArray));
    }

    @Test public void insertionSort_handlesNegatives() {
        int[] testArray = new int[]{-2, 2, 35, 1, -8};
        int[] expected = new int[]{-8, -2, 1, 2, 35};
        assertArrayEquals(expected, insertionSort(testArray));
    }

    @Test public void insertionSort_doesNothingWithEmptyArray() {
        int[] testArray = new int[0];
        assertArrayEquals(testArray, insertionSort(testArray));
    }
}
