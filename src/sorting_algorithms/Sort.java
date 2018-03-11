/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import Sorting_Simulator.Fork;
import Sorting_Simulator.SortingSimulator;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static Sorting_Simulator.SortingSimulator.alert;
import static Sorting_Simulator.SortingSimulator.truncate;
import static sorting_algorithms.TrumpSort.immigrants;


/**
 * @author Aashish Bharadwaj
 */
public class Sort{
	public static String sortingMethod = "javaSort";
	public static String inputMethod = "randomOrder";

	public static Instant startTime;

	public static Queue allBlocks;

	public static void swapTwoValues(int valueOne, int valueTwo, int[] array){
		try{
			int temp = array[valueOne];
			array[valueOne] = array[valueTwo];
			array[valueTwo] = temp;
		}catch(Exception e){
		}
	}

	public static int[] incrementArray(int size){
		int[] array = new int[size];

		for(int i = 0; i < size; i++){
			array[i] = i;
		}

		return array;
	}

	public static int[] decrementArray(int size){
		int[] array = new int[size];

		for(int i = size; i > 0; i--){
			array[(size - i)] = i;
		}

		return array;
	}

	public static int[] randomizeArray(int size){
		int[] array;
		try{
			array = new int[size];
		}catch(OutOfMemoryError e){
			alert("Cannot Sort", "You have entered too large of an input size.",
			      "Please enter a smaller list size.", "WARNING", false);
			return null;
		}

		for(int i = 0; i < size; i++){
			array[i] = (int)(Math.random() * size + 1);
		}

		return array;
	}

	public static int getMaxValue(int[] array){
		int mx = array[0];
		for(int i = 1; i < array.length; i++){
			if(array[i] > mx){
				mx = array[i];
			}
		}
		return mx;
	}

	public static int getMinValue(int[] array){
		int mn = array[0];
		for(int i = 1; i < array.length; i++){
			if(array[i] < mn){
				mn = array[i];
			}
		}
		return mn;
	}

	public static int[] deleteIndex(int[] array, int index){
		int[] newArray = new int[array.length - 1];

		for(int i = 0; i < index; i++){
			newArray[i] = array[i];
		}
		for(int i = index + 1; i < array.length; i++){
			newArray[i - 1] = array[i];
		}
		return newArray;
	}

	public static boolean isSorted(int[] array){
		for(int i = 1; i < array.length; i++){
			if(array[i] < (array[i - 1])){
				return false;
			}
		}
		return true;
	}

	/**
	 * Sums the integers in an array
	 *
	 * @param indexArray Array to pull numbers from
	 * @return Sum
	 */
	public static int sumArray(int[] indexArray){
		int numberOfElements = 0;
		for(int i = 0; i < indexArray.length; i++){
			numberOfElements += indexArray[i];
		}
		return numberOfElements;
	}

	public static boolean isNumberInArray(int number, int[] array){
		for(int i = 0; i < array.length; i++){
			if(array[i] == number){
				return true;
			}
		}
		return false;
	}

	public static void letsSort(int size, int blocks){

		if(size <= 0 || blocks <= 0){
			if(size <= 0){
				alert("Invalid input", "You have entered list size " + size + ", which is wrong.",
				      "Please enter a value greater than zero.", "WARNING", false);
			}
			if(blocks <= 0){
				alert("Invalid input",
				      "You have entered block size " + blocks + ", which is wrong.",
				      "Please enter a value greater than zero.", "WARNING", false);
			}

			return;
		}

//        size++;
		if((size / blocks) < 1){  //SO that the number of threads isn't zero
			blocks = size;
		}

		int[] array = createArray(size);
		allBlocks = new ArrayBlockingQueue(size / blocks + 1);

		//System.out.println(Arrays.toString(array));

		startSorting(array, size, blocks);
	}

	public static int[] createArray(int size){
		int[] createdArray;

		switch(inputMethod){
			case "randomOrder":{
				createdArray = randomizeArray(size);
				break;
			}
			case "alreadySorted":{
				createdArray = incrementArray(size);
				break;
			}
			case "reverseOrder":{
				createdArray = decrementArray(size);
				break;
			}
			default:
				return null;
		}

		System.out.println("Initial array:\n" + truncate(Arrays.toString(createdArray), 3333));
		System.out.println("");

		return createdArray;
	}

	private static void startSorting(int[] array, int size, int blockSize){
		startTime = Instant.now();

		if(blockSize >= size){
			Thread singleSort = new Thread(new Fork(sortingMethod, createCopy(array)));

			singleSort.start();
			try{
				singleSort.join();
			}catch(InterruptedException ex){
			}

		}else{
			sortByBlocks(array, size, blockSize);
			doTheMerge(array, blockSize);
		}

//        while(allBlocks.size() < size/blockSize){
////            //System.out.println("waiting");
////            //System.out.println(allBlocks.size());
////            //System.out.println(size/blockSize);
//        }  //There's got to be a better way...
		//Make sure the above actually works before starting the merging

		displayFinalResults(array);
	}

	//This creates a copy of an array to avoid modifying the original repeatedly, which doesn't work
	private static int[] createCopy(int[] array){
		int[] newArray = new int[array.length];

		for(int i = 0; i < array.length; i++){
			newArray[i] = array[i];
		}

		return newArray;
	}

	private static void doTheMerge(int[] array, int blockSize){
//        System.out.println("doTheMerge");
//        int blockSize = ((Comparable[])(allBlocks.peek())).length;

//        if(newArraySize == array.length){
//            setArray(array);
//            //System.out.println("we done " + Arrays.toString(array));
//            return;
//        }

//        while(newArraySize < array.length){

		while(true){
			try{
				mergeBlocks(blockSize, array);
				break;
			}catch(Exception e){
				continue;
			}
		}

//        while(allBlocks.size() > i/2 + 1){
//            //System.out.println(allBlocks.size());
//            //System.out.println(i - 1);
//        }


		//System.out.println(Arrays.toString((Comparable[])(allBlocks.peek())));

	}

	private static void setArray(int[] array){
		array = (int[])allBlocks.peek();
		//System.out.println("Copy the array over");

		for(int i = 0; i < array.length; i++){
			array[i] = ((int[])(allBlocks.peek()))[i];
		}
	}

	public static int[] trimArray(int[] array){
		int numOfValues = 0;

		for(int i = 0; i < array.length; i++){
			if(array[i] != 0){
				numOfValues++;
			}
		}

		int[] newArray = new int[numOfValues];
		for(int i = 0; i < numOfValues; i++){
			newArray[i] = array[i];
		}

		return newArray;
	}

	public static void joinThreads(ArrayList<Thread> threads){
		for(int i = 0; i < threads.size(); i++){
			try{
				threads.get(i).join();
			}catch(InterruptedException ex){
			}
		}
	}

	private static void displayFinalResults(int[] array){
		long endTime = Instant.now().toEpochMilli();
		System.out.println("");

		if(sortingMethod.equals("trumpSort")){
			System.out.println(immigrants + " foreign items deported.");
			System.out.println("");
			immigrants = 0;
		}
		if(sortingMethod.equals("bernieSort")){
			System.out.println("The average wealth was " +
					                   truncate(Integer.toString(BernieSort.averageWealth), 3333));
			System.out.println("It has been split amongst all.");
			System.out.println("");
		}
		if(sortingMethod.equals("hillarySort")){
			System.out.println("All suspicious items have been deleted.");
			System.out.println("");
		}

		alert("Operation finished", "The time taken is below",
		      (endTime - Sort.startTime.toEpochMilli()) + " milliseconds", "INFORMATION", false);

		System.out.println("Sorted array:\n" + SortingSimulator.truncate(
				Arrays.toString((int[])(allBlocks.poll())), 3333));
		System.out.println("");
		System.out.println("");
	}

	private static void sortByBlocks(int[] array, int size, int blockSize){
		ArrayList<Thread> sortThreads = new ArrayList<>();

		int[] blockArray = new int[blockSize];
		int threadNumber = 1;
		int i;
		int blockIndex = 0;

		for(i = 1; i <= array.length; i++){
			blockArray[blockIndex] = array[i - 1];
			blockIndex++;

			if(i % blockSize == 0){
				sortThreads.add(new Thread(new Fork(sortingMethod, createCopy(blockArray))));
				sortThreads.get(threadNumber - 1).start();

				//System.out.println("Thread: " + threadNumber);
				threadNumber++;

				blockIndex = 0;
			}
		}

		if(blockIndex < blockSize){
			sortLeftovers(array, size, blockSize, blockIndex, i);
		}

		joinThreads(sortThreads);
	}

	private static void sortLeftovers(int[] array, int size, int blockSize, int blockIndex,
	                                  int arrayLength){
		int[] newBlockArray = new int[size % blockSize];

		for(int t = (arrayLength - blockIndex) - 1; t < Integer.MAX_VALUE; t++){
			try{
				//System.out.println("value1: " + array[t]);
				//System.out.println("value2: " + t);
				//System.out.println("value3: " + (t - (i - blockIndex - 1)));

				newBlockArray[(t - (arrayLength - blockIndex - 1))] = array[t];
			}catch(Exception e){
				Thread leftovers = new Thread(new Fork(sortingMethod, createCopy(newBlockArray)));
				leftovers.start();

				//System.out.println("Thread after: " + threadNumber);

				//System.out.println(Arrays.toString(newBlockArray));
//                    pause();

				try{
					leftovers.join();
				}catch(InterruptedException ex){
					System.out.println("Join exception");
				}

				break;
			}
		}
	}

	private static void mergeBlocks(int blockSize, int[] array){
		int i;
		int newSize;

		while(((int[])(allBlocks.peek())).length < array.length){
			//System.out.println("size: " + allBlocks.size());

			newSize = allBlocks.size();

			try{
				ArrayList<Thread> mergingThreads = new ArrayList<>();

				if(blockSize <= 0){
					return;
				}

				double numberOfMerges = Math.ceil(((float)newSize) / ((float)blockSize));

				for(i = 0; i < numberOfMerges; i++){
//                            Thread merge = new Thread(new Merger());
					mergingThreads.add(new Thread(new Merger()));
					mergingThreads.get(i).start();

//                            merge.start();
//                        merge.join();
				}

//                        System.out.println("Waiting for join");
				joinThreads(mergingThreads);

				if(allBlocks.size() == 1){
					return;
				}
			}catch(Exception pleaseWait){
			}
		}
	}

//    public static Integer[] convertToIntegers(Comparable[] array){
//        Integer[] newArray = new Integer[array.length];
//
//        for(int i = 0; i < array.length; i++){
//            newArray[i] = (Integer)(array[i]);
//        }
//
//        return newArray;
//    }

	private static class Merger implements Runnable{

		public Merger(){
		}

		@Override
		public synchronized void run(){

			//System.out.println("Merge thread");
			//System.out.println("allBlocks size before: " + allBlocks.size());

			//System.out.println(""); //System.out.println(""); //System.out.println("");

//            displayTest();

			if(allBlocks.size() < 2){
				return;
			}

			try{
				allBlocks.offer(
						MergeSort.mergeData((int[])(allBlocks.poll()), (int[])(allBlocks.poll())));
			}catch(Exception foweijfeowifj){
			}

			try{
				//System.out.println("Lenghth of peek: " + ((Comparable[])(allBlocks.peek())).length);
			}catch(Exception e){
			}

			//System.out.println("allBlocks size after: " + allBlocks.size());
			//System.out.println("Finish merge thread");

			//System.out.println(Arrays.toString((Comparable[])(allBlocks.peek())));
		}

		public void displayTest(){
			for(int i = 0; i < Integer.MAX_VALUE; i++){
				try{
					//System.out.println(Arrays.toString((Comparable[])(allBlocks.poll())));
				}catch(Exception e){
				}
			}
		}
	}
}