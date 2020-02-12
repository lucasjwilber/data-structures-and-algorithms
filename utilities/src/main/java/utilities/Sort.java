package utilities;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort {

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;

            //store the value of i at each iteration, in case we need to insert it in another index during sorting
            int temp = arr[i];

            //if a value is found that is less than the value on its left, we need to find the correct position for
            //that value. if our check brings us all the way to index 0 (when j = -1), we terminate the loop and
            // insert it there.
            while (j >= 0 && temp < arr[j]) {

                //we set the value on the right to be the value on the left
                arr[j + 1] = arr[j];

                //then we decrement j so that our next check moves left again.
                j--;
            }
            //now that the correct position for the value has been found we insert it
            arr[j + 1] = temp;
        }
        return arr;
    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            int mid = n / 2;
            int[] left = new int[mid];
            int[] right;
            if (arr.length % 2 != 0) {
                right = new int[mid + 1];
            } else {
                right = new int[mid];
            }
            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }
            if (arr.length % 2 != 0) {
                for (int i = 0; i < mid + 1; i++) {
                    right[i] = arr[mid + i];
                }
            } else {
                for (int i = 0; i < mid; i++) {
                    right[i] = arr[mid + i];
                }
            }
            System.out.println("left " + Arrays.toString(left));
            System.out.println("right " + Arrays.toString(right));
            mergeSort(left);
            mergeSort(right);
            merge(left, right, arr);
        }
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, //left
            j = 0, //right
            k = 0; //arr
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
            if (i == left.length) {
//        set remaining entries in arr to remaining values in right
                while (j < right.length) {
                    arr[k] = right[j];
                    j++;
                    k++;
                }
            } else {
//        set remaining entries in arr to remaining values in left
                while (i < left.length) {
                    arr[k] = left[i];
                    i++;
                    k++;
                }
            }

    }

    public static void main(String[] args) {
        int[] testArr = new int[]{8, 4, 23, 42, 16, 15};
        mergeSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
