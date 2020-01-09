package code401challenges.java;

public class BinarySearchTest {

    public static int binarySearchForValue(int[] sortedArray, int searchKey) {
        int currentIndex = sortedArray.length / 2;
        int currentNumber = sortedArray[currentIndex];

        while (currentNumber != searchKey) {
            if (searchKey > currentNumber) {
                currentIndex += (sortedArray.length - currentIndex) / 2;
            }
            if (searchKey < currentNumber) {
                currentIndex -= (sortedArray.length - currentIndex) / 2;
            }
            currentNumber = sortedArray[currentIndex];

            //if number is not in array:
            if (
                currentIndex == 0 && currentNumber != searchKey ||
                currentIndex == sortedArray.length - 1 && currentNumber != searchKey
            ) {
                System.out.println("The given number is not in the array");
                return -1;
            }
        }
        return currentIndex;
    }




    public static void main (String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearchForValue(testArray, 4));
    }
}
