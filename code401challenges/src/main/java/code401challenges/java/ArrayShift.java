package code401challenges.java;

import java.util.Arrays;

public class ArrayShift {

    public static int[] insertShiftArray(int[] inputArray, int number) {
        int[] newArray = new int[inputArray.length + 1];
        int middleIndex = (int) Math.ceil(newArray.length / 2);
        int position = 0;

        for (int i = 0; i < newArray.length; i++) {
            //for now, skip the index for the new number
            if (i == middleIndex) {
                continue;
            }
            newArray[i] = inputArray[position];
            position++;
        }
        //add the new number
        newArray[middleIndex] = number;
        return newArray;
    }

    public static void main(String[] args) {
//        int[] testArr = {1, 2, 3, 6};
//        int testNum = 5;
//        System.out.println("Result with " + Arrays.toString(testArr) + " and number " + testNum);
//        System.out.println(Arrays.toString(insertShiftArray(testArr, testNum)));
//
//        int [] testArr2 = {3, 5, 1, 6, 13};
//        testNum = 69;
//        System.out.println("Result with " + Arrays.toString(testArr2) + " and number " + testNum);
//        System.out.println(Arrays.toString(insertShiftArray(testArr2, testNum)));
    }
}
