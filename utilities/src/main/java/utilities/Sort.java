package utilities;

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

    public static void main(String[] args) {
        int[] testarr = new int[]{1, 5, 32, 8, 4, 6};
        System.out.println(Arrays.toString(insertionSort(testarr)));
    }
}
