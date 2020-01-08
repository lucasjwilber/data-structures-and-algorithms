package code401challenges.java;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayReverseTest {
    @Test public void testArrayReverse() {
        ArrayReverse classUnderTest = new ArrayReverse();

        int[] testArray = {4, 5, 6, 7, 8};
        assertArrayEquals(new int[] {8, 7, 6, 5, 4}, classUnderTest.reverseArray(testArray));

        int[] testArray2 = {-3, 13, 245345, 4, 4};
        assertArrayEquals(new int[] {4, 4, 245345, 13, -3}, classUnderTest.reverseArray(testArray2));
    }
}
