package code401challenges.java;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayReverseTest {
    @Test public void testArrayReverse() {
        ArrayReverse classUnderTest = new ArrayReverse();

        //Happy Paths:
        int[] testArray = {4, 5, 6, 7, 8};
        assertArrayEquals(new int[] {8, 7, 6, 5, 4}, classUnderTest.reverseArray(testArray));
        testArray = new int[] {-3, 13, 245345, 4, 4};
        assertArrayEquals(new int[] {4, 4, 245345, 13, -3}, classUnderTest.reverseArray(testArray));

        //Expected Failure:
        testArray = new int[] {2, 1, 3};
        assertNotEquals("", (new int[]{1, 2, 3} == classUnderTest.reverseArray(testArray)));

        //Edge cases:
    }
}
