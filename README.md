# Sorting-Simulator
Program that simulates sorting arrays with multiple threads and different algorithms.
Please see the **[Wiki]**(https://github.com/Aashishkebab/Sorting-Simulator/wiki) to learn more.

### [Java 8 Download](https://github.com/Aashishkebab/Sorting-Simulator/raw/master/out/artifacts/Sorting_Simulator_jar/Sorting-Simulator_Java8.jar)
### [Java 9 Download](https://github.com/Aashishkebab/Sorting-Simulator/raw/master/out/artifacts/Sorting_Simulator_jar/Sorting-Simulator.jar)

## To use the program
1. User sets the size of the array of items to be sorted.
2. The user sets the order of the list of items to be sorted.
3. The user enters integer value of the smallest item in array and the largest item in array.
4. The user chooses the block size, which is the number of items in the array are to be sorted in parallel on different threads.
  a. If the block size is greater than or equal to the size of the array, then one thread is used.
  b. If the block size is less than the size of the array, then multiple threads use the selected sorting algorithm, with the array split        into multiple arrays equal to the block size. The last block size is the remainder elements. After all threads are complete, they are merged using **Merge Sort**.
5. The program displays the time taken to sort the array.
6. The program displays the array in the console.
