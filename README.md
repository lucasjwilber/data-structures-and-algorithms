This is the repo used for the Code Fellows 301 and 401 Code Challenges.
Author: Lucas Wilber

# Reverse an Array
401 Java challenge #1.

## Challenge
Write a Java method that takes in an array and returns the reverse.

## Approach & Efficiency
My approach was to iterate backwards over the inputted array and define the values of the new array in order with each iteration.

## Solution
[code](./code401challenges/src/main/java/code401challenges/java/ArrayReverse.java)
![image](./assets/array-reverse.jpg)


# Shift an Array
401 Java challenge #2.

## Challenge
Write a function called insertShiftArray which takes in an array and the value to be added. Without utilizing any of the built-in methods available, return an array with the new value added at the middle index.

## Approach & Efficiency
My approach was to create an empty array with a length of the inputted array + 1, then iterate over it, skipping the middle index while adding the values from the inputted array, then finally setting the middle index to be the inputted value.

## Solution
[code](./code401challenges/src/main/java/code401challenges/java/ArrayShift.java)
![image](./assets/array-shift.jpg)


# Array Binary Search
401 Java challenge #3.

## Challenge
Write a function called BinarySearch which takes in 2 parameters: a sorted array and the search key. Without utilizing any of the built-in methods, return the index of the array’s element that is equal to the search key, or -1 if the element does not exist.

## Approach & Efficiency
My approach was to start at the middle by taking the input array length / 2, then begin a while-loop where I compare the value at that index to the search key and keep track of the index of comparison. If the search key wasn't found, I add or subtract half of the difference between the input array length and the tracked index value to the index value, which continuously halves the current index value while moving towards the search key. If the maximum or minimum index values are reached and the search key isn't found, I return -1;

## Solution
[code](./code401challenges/src/main/java/code401challenges/java/BinarySearch.java)
![image](./assets/binarySearch.jpg)


# Singly Linked List

## Challenge
Create a LinkedList class from scratch, along with insert() to add Nodes and  toString() to print the entire LinkedList.

## Approach & Efficiency
My approach inserts new nodes at the head of the list, so that inserting new nodes is O(1) rather than O(n).

## API
  -`insert(int value)`
  Inserts a new Node into the Linked List
  -`includes(int input)`
  Checks the value of each Node in the list agains the `input` and returns true if found, false if not.
  -`listToString()`
  Prints each value of the Linked List in "{ [Head value] } -> { [next Node value]} ->..." format.
  
## Solution
[code](./Data-Structures/src/main/java/linkedList/LinkedList.java)
