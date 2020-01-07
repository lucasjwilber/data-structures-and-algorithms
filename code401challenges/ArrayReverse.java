import java.util.Arrays;

public class ArrayReverse {
  public static int[] reverseArray (int[] inputArray) {
    int inputLength = inputArray.length;
    int[] reversedArray = new int[inputLength];
    int count = 0;
    for (int i = inputLength - 1; i >= 0; i--) {
      reversedArray[count] = inputArray[i];
      count++;
    }
    return reversedArray;
  }
  public static void main (String[] args) {
    int[] testArray = new int[] {2, 6, 7, 4, 11, 2323};
    System.out.println(Arrays.toString(reverseArray(testArray)));
  }
}