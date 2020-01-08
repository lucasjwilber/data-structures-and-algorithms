package code401challenges.java;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayShiftTest {

    @Test public void testArrayShift() {
        ArrayShift classUnderTest = new ArrayShift();

        //Happy Paths:
        int[] testArray = {1, 2, 3, 4};
        assertArrayEquals(new int[] {1, 2, 5, 3, 4}, classUnderTest.insertShiftArray(testArray, 5));
        testArray = new int[] {-5, 99, 2, -2, 5, 5, 1};
        assertArrayEquals(new int[] {-5, 99, 2, -2, 6, 5, 5, 1}, classUnderTest.insertShiftArray(testArray, 6));

        //Expected Failure:
        assertFalse("with odd number arrays, the inserted number should be on the right side of the middle index", (classUnderTest.insertShiftArray(testArray, 5) == new int[]{-5, 99, 2, 6, -2, 5, 5, 1}));

        //Edge Case:
    }
}
