import java.util.Arrays;

public class ArrayReverse {
  public static int[] reverseArray (int[] inputArray) {
    //make an empty array with the same length as the input array:
    int inputLength = inputArray.length;
    int[] reversedArray = new int[inputLength];

    //loop over the input array in reverse:
    int count = 0;
    for (int i = inputLength - 1; i >= 0; i--) {
      reversedArray[count] = inputArray[i];
      count++;
    }
    return reversedArray;
  }
  public static void main (String[] args) {
    int[] testArray = new int[] {2, 6, 7, 4, 11, 2323};
    System.out.println("reversing array " + Arrays.toString(testArray));
    System.out.println("result: " + Arrays.toString(reverseArray(testArray)));
  }
}