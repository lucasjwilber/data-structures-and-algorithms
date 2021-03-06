package utilities;

import org.junit.Test;

import static org.junit.Assert.*;
import static utilities.Sort.*;

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

    @Test
    public void mergeSort_works() {
        int[] testArray = new int[]{8, 4, 23, 42, 16, 15};
        int[] expected = new int[]{4, 8, 15, 16, 23, 42};
        assertArrayEquals(expected, mergeSort(testArray));
    }

    @Test public void mergeSort_doesNothingToEmptyArray() {
        int[] testArray = new int[0];
        assertArrayEquals(testArray, mergeSort(testArray));
    }

    @Test
    public void mergeSort_doesntModifySortedArrays() {
        int[] testArray = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(testArray, mergeSort(testArray));
    }

    @Test public void mergeSort_handlesNegatives() {
        int[] testArray = new int[]{-2, 2, 35, 1, -8};
        int[] expected = new int[]{-8, -2, 1, 2, 35};
        assertArrayEquals(expected, mergeSort(testArray));
    }

    @Test
    public void quickSort_works() {
        int[] testArray = new int[]{8, 4, 23, 42, 16, 15};
        int[] expected = new int[]{4, 8, 15, 16, 23, 42};
        assertArrayEquals(expected, quickSortWholeArray(testArray));
    }

    @Test public void quickSort_doesNothingToEmptyArray() {
        int[] testArray = new int[0];
        assertArrayEquals(testArray, quickSortWholeArray(testArray));
    }

    @Test
    public void quickSort_doesntModifySortedArrays() {
        int[] testArray = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(testArray, quickSortWholeArray(testArray));
    }

    @Test public void quickSort_handlesNegatives() {
        int[] testArray = new int[]{-2, 2, 35, 1, -8};
        int[] expected = new int[]{-8, -2, 1, 2, 35};
        assertArrayEquals(expected, quickSortWholeArray(testArray));
    }
}
