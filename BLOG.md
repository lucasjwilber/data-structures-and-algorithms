# Insertion Sort
This sorting method works by iterating through the array from left to right and maintaining a sorted, growing portion of the array until the entire array has been checked.

## Algorithm
1. Loop through the entire array.
2. Keep track of two adjacent values, starting at index 0. (j and i).
3. Store the value of i in a 'temp' variable at every loop.
4. Inside the loop, whenever j is greater than i, i is not in the correct position. To find it's proper position, loop towards index 0, moving each value to the right, until a value is found that is less than j. Then insert the temp value at j + 1.

## Pseudo Code
  
    FOR i = 1 to arr.length
    
      int j <-- i - 1
      int temp <-- arr[i]
      
      WHILE j >= 0 AND temp < arr[j]
        arr[j + 1] <-- arr[j]
        j <-- j - 1
        
      arr[j + 1] <-- temp

## Whiteboard step-through example
![Whiteboard](./assets/insertionSortDrawing.png)

## Approach and Efficiency
This approach loops through the entire array once, with the potential to loop through the array again at each iteration n-i times, making it O(n squared/2) for time complexity, or O(n squared). No additional data structure is created during the sort, making it O(1) for space complexity.

## Code
![Code](./utilities/src/main/java/utilities/Sort.java)

