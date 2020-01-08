package code401challenges.java;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayShiftTest {

    @Test public void testArrayShift() {
        ArrayShift classUnderTest = new ArrayShift();
        int[] testArray = {1, 2, 3, 4};
        assertArrayEquals(new int[] {1, 2, 5, 3, 4}, classUnderTest.insertShiftArray(testArray, 5));

        int[] testArray2 = {-5, 99, 2, -2, 5, 5, 1};
        assertArrayEquals(new int[] {-5, 99, 2, -2, 6, 5, 5, 1}, classUnderTest.insertShiftArray(testArray2, 6));
    }
}
