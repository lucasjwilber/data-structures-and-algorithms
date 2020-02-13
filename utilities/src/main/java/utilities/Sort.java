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

    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            int mid = n / 2;
            int[] left = new int[mid];
            int[] right;
            //if arr's length is odd, make the right array hold the extra value
            if (arr.length % 2 != 0) {
                right = new int[mid + 1];
            } else {
                right = new int[mid];
            }
            //put the first half of arr into left
            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }
            //put the second half of arr into right
            for (int i = 0; i < mid; i++) {
                right[i] = arr[mid + i];
            }
            //if arr was odd, add the last value of arr to the end of right
            if (arr.length % 2 != 0) right[mid] = arr[mid * 2];

            mergeSort(left);
            mergeSort(right);
            merge(left, right, arr);
        }
        return arr;
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, //left
            j = 0, //right
            k = 0; //arr
        //sort and insert values until either array is out of values
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
        //if either array still has uninserted values, add them
        if (i == left.length) {
            while (j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }
        } else {
            while (i < left.length) {
                arr[k] = left[i];
                i++;
                k++;
            }
        }
    }


    public static int[] quickSortWholeArray(int[] arr) {
        if (arr.length > 0) {
            quickSort(arr, 0, arr.length - 1);
        }
        return arr;
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //divide the array in half at the pivot point
            int position = partition(arr, left, right);
            quickSort(arr, left, position - 1);
            quickSort(arr, position + 1, right);
        }
    }
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int low = left - 1;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                low++;
                swap(arr, i, low);
            }
        }
        swap(arr, right, low + 1);
        return low + 1;
    }
    public static void swap(int[] arr, int i, int low) {
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
    }


    public static void main(String[] args) {
        int[] testArr = new int[]{4, 1, 6, 23, 4, 4 ,77, 2};
        quickSortWholeArray(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
