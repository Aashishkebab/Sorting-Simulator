# Sorting-Simulator
Program that simulates sorting arrays with multiple threads and different algorithms.
Please see the [Wiki](https://github.com/Aashishkebab/Sorting-Simulator/wiki) to learn more.

## Download
- You will need to make sure you have [Java installed](https://java.com/en/download/).


### [Click here to download](https://github.com/Aashishkebab/Sorting-Simulator/raw/master/out/artifacts/Sorting_Simulator_jar/Sorting-Simulator_Java8.jar)

You can also [Download the Java 9 version](https://github.com/Aashishkebab/Sorting-Simulator/raw/master/out/artifacts/Sorting_Simulator_jar/Sorting-Simulator_Java8.jar). This version works identically, but is slightly faster due to improvements in Java. The problem is that the default Java download still links to Java 8 (because Oracle is weird), so that is the default download link. If you have Java 9 installed, you should download this version.

## To use the program
1. User sets the size of the array of items to be sorted.
2. The user sets the order of the list of items to be sorted.
3. The user enters integer value of the smallest item in array and the largest item in array.
4. The user chooses the block size, which is the number of items in the array are to be sorted in parallel on different threads.
  a. If the block size is greater than or equal to the size of the array, then one thread is used.
  b. If the block size is less than the size of the array, then multiple threads use the selected sorting algorithm, with the array split        into multiple arrays equal to the block size. The last block size is the remainder elements. After all threads are complete, they are merged using **Merge Sort**.
5. The program displays the time taken to sort the array.
6. The program displays the array in the console.

## Input Type
How items in the array are generated.

### Already Sorted
Generates an array of numbers increasing in size, starting from **Smallest Number** and ending at **Largest Number**.
The generator attempts to have a balanced amount of each number based on the **input size**.

### Reverse Order
Generates an array of numbers decreasing in size from **Largest Number** to **Smallest Number**.
Balances the number of appearances of each number based on the **Input Size**.

### Random
Generates an array of a bunch of randomized numbers in the range between **Smallest Number** and **Largest Number**.


## Input Parameters
The text fields for user input. The generator will generate integers between **Smallest Number** and **Largest Number**. The number of generated items is based on the **Input Size**.
If a non-random **Input Type** is selected, then the generator will try to create an equal number of each generated integer.
For example, if the user inputs
> **Input Size** = 10, **Smallest Number** = -2, and **Largest Number** = 2, **Input Type** = _Already Sorted_

then the generated array will be

> -2, -2, -1, -1, 0, 0, 1, 1, 2, 2.

If the user inputs

> **Input Size** = 6, **Smallest Number** = 0, and **Largest Number** = 12, **Input Type** = _Reverse order_

then the generated array will be

> 12, 10, 8, 6, 4, 2.

### Input Size
The number of generated items.

### Smallest Number
The lowest value integer in the generated array.

### Largest Number
The highest value integer in the array.

### Block Size
The number of array items in each thread.
The program splits the sorting into multiple concurrent threads based on the **Input Size** / **Block Size**. At the end, the individually sorted arrays are merged via _Merge Sort_.
