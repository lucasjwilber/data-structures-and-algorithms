package code401challenges.java;

//need to add handling for non-int array values
public class BinarySearch {
    public static int binarySearchForValue(int[] sortedArray, int searchKey) {
        int currentIndex = sortedArray.length / 2;
        int currentNumber = sortedArray[currentIndex];
        int cycleCount = 0;

        while (currentNumber != searchKey) {
            cycleCount++;
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
        System.out.println("It took " + cycleCount + " cycles to find the index.");
        return currentIndex;
    }
    public static void main(String[] args) {
        System.out.println("hi");
    }
}
