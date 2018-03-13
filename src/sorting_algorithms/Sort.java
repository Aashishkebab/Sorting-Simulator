/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import Sorting_Simulator.Fork;
import Sorting_Simulator.GUI;
import Sorting_Simulator.SortingSimulator;
import javafx.application.Platform;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static Sorting_Simulator.GUI.alert;
import static Sorting_Simulator.SortingSimulator.truncate;
import static sorting_algorithms.TrumpSort.immigrants;


/**
 * @author Aashish Bharadwaj
 */
public class Sort{
	public static String sortingMethod = "javaSort";
	public static String inputMethod = "randomOrder";
	public static boolean printArrays = false;

	public static int minSize;
	public static int maxSize;

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

	public static int[] incrementArray(int size, int min, int max){
		int[] array = new int[size];
		int numElements = 1 + max - min;

		for(int i = 0; i < size; i++){
			array[i] = min + (i * numElements) / size;
		}

		return array;
	}

	public static int[] decrementArray(int size, int min, int max){
		int[] array = new int[size];
		int numElements = 1 + max - min;

		for(int i = 0; i < size; i++){
			array[i] = max - (i * numElements) / size;
		}

		return array;
	}

	public static int[] randomizeArray(int size, int min, int max){
		int[] array;
		array = new int[size];

		for(int i = 0; i < size; i++){
			array[i] = min + (int)(Math.random() * ((max - min) + 1));
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

		System.arraycopy(array, 0, newArray, 0, index);
		System.arraycopy(array, index + 1, newArray, index, array.length - (index + 1));
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
	public static int sumArray(int[] array){
		int numberOfElements = 0;
		for(int i = 0; i < array.length; i++){
			numberOfElements += array[i];
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
		try{
			if(size <= 0 || blocks <= 0 || minSize > maxSize){
				if(size <= 0){
					alert("Invalid input",
					      "You have entered list size " + size + ", which is wrong.",
					      "Please enter a value greater than zero.", "WARNING", true);
				}
				if(blocks <= 0){
					alert("Invalid input",
					      "You have entered block size " + blocks + ", which is wrong.",
					      "Please enter a value greater than zero.", "WARNING", true);
				}
				if(minSize > maxSize){
					alert("Invalid input", "Please fix your input.",
					      "Largest number must be greater than\nor equal to smallest number.",
					      "WARNING", true);
				}

				return;
			}

			pleaseWait();

//        size++;
			if((size / blocks) < 1){  //So that the number of threads isn't zero
				blocks = size;
			}

			int[] array = createArray(size);
			allBlocks = new ArrayBlockingQueue(size / blocks + 1);

			//		Thread sorter = new Thread(new Sorter(array, size, blocks));
			//		sorter.start();

			new Thread(new Sorter(array, size, blocks)).start();

		}catch(OutOfMemoryError e){
			alert("Cannot Sort", "You have entered too large of an input size.",
			      "Please enter a smaller list size.", "ERROR", true);
			Platform.runLater(new SetGoState(false));
			return;
		}
	}

	public static void pleaseWait(){
		Platform.runLater(new SetGoState(true));
	}

	public static int[] createArray(int size){
		int[] createdArray;

		switch(inputMethod){
			case "randomOrder":{
				createdArray = randomizeArray(size, minSize, maxSize);
				break;
			}
			case "alreadySorted":{
				createdArray = incrementArray(size, minSize, maxSize);
				break;
			}
			case "reverseOrder":{
				createdArray = decrementArray(size, minSize, maxSize);
				break;
			}
			default:
				return null;
		}

		if(printArrays){
			alert("Start", "Here is the initial array",
			      SortingSimulator.truncate(Arrays.toString(createdArray), 2222), "INFORMATION",
			      true);
		}

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
				alert("Crap", "Fatal error has ocurred!", "InterruptedException", "ERROR", true);
			}

		}else{
			sortByBlocks(array, size, blockSize);
			doTheMerge(array, blockSize);
		}

		long endTime = Instant.now().toEpochMilli();
		Thread displayResults = new Thread(new Displayer(endTime));
		Platform.runLater(displayResults);

//		Platform.runLater(new Thread(new Displayer(Instant.now().toEpochMilli())));
	}

	private static int[] createCopy(int[] array){
		int[] newArray = new int[array.length];

		System.arraycopy(array, 0, newArray, 0, array.length);

//		for(int i = 0; i < array.length; i++){
//			newArray[i] = array[i];
//		}

		return newArray;
	}

	private static void doTheMerge(int[] array, int blockSize){
		mergeBlocks(blockSize, array);
	}

	private static void setArray(int[] array){
		array = (int[])allBlocks.peek();

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
		System.arraycopy(array, 0, newArray, 0, numOfValues);

		return newArray;
	}

	public static void joinThreads(ArrayList<Thread> threads){
		for(int i = 0; i < threads.size(); i++){
			try{
				threads.get(i).join();
			}catch(InterruptedException ex){
				alert("Crap", "Fatal error has ocurred!", "InterruptedException", "ERROR", true);
			}
		}
	}

	private static void displayFinalResults(long endTime){
		alert("Operation finished", "The time taken is below",
		      (endTime - Sort.startTime.toEpochMilli()) + " milliseconds", "INFORMATION", true);

		if(sortingMethod.equals("trumpSort")){
			alert("Make Sorting Great Again!", "Wall has been built!",
			      immigrants + " foreign items deported.", "INFORMATION", true);
		}
		if(sortingMethod.equals("bernieSort")){
			alert("Feel the Bern!", "Wealth has been distributed equally.",
			      "The average wealth was " +
					      truncate(Integer.toString(BernieSort.averageWealth), 333), "INFORMATION",
			      true);
		}
		if(sortingMethod.equals("hillarySort")){
			alert("Watch out Bill!", "Server has been erased.", "Bribery was successful.",
			      "INFORMATION", true);
		}

		if(printArrays){
			alert("Results", "Here is the sorted array",
			      SortingSimulator.truncate(Arrays.toString((int[])(allBlocks.poll())), 2222),
			      "INFORMATION", false);
		}

		Platform.runLater(new SetGoState(false));
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
				newBlockArray[(t - (arrayLength - blockIndex - 1))] = array[t];
			}catch(Exception e){
				Thread leftovers = new Thread(new Fork(sortingMethod, createCopy(newBlockArray)));
				leftovers.start();

				try{
					leftovers.join();
				}catch(InterruptedException ex){
					alert("Crap", "Fatal error has ocurred!", "InterruptedException", "ERROR",
					      true);
					Platform.runLater(new SetGoState(false));
				}

				break;
			}
		}
	}

	private static void mergeBlocks(int blockSize, int[] array){
		int i;
		int newSize;

		while(((int[])(allBlocks.peek())).length < array.length){
			newSize = allBlocks.size();

			try{
				ArrayList<Thread> mergingThreads = new ArrayList<>();

				if(blockSize <= 0){
					return;
				}

				double numberOfMerges = Math.ceil(((float)newSize) / ((float)blockSize));

				for(i = 0; i < numberOfMerges; i++){
					mergingThreads.add(new Thread(new Merger()));
					mergingThreads.get(i).start();
				}

				joinThreads(mergingThreads);

				if(allBlocks.size() == 1){
					return;
				}
			}catch(NullPointerException pleaseWait){
				alert("Crap", "Programmer is probably an idiot...", "NullPointerException", "ERROR",
				      true);
				Platform.runLater(new SetGoState(false));
			}
		}
	}

	private static class Merger implements Runnable{

		public Merger(){
		}

		@Override
		public synchronized void run(){
			if(allBlocks.size() < 2){
				return;
			}

			try{
				allBlocks.offer(
						MergeSort.mergeData((int[])(allBlocks.poll()), (int[])(allBlocks.poll())));
			}catch(Exception foweijfeowifj){
				alert("Crap", "Programmer is stupid...",
				      "Did you try unplugging it\nand plugging it back in?", "ERROR", true);
				Platform.runLater(new SetGoState(false));
			}
		}
	}

	private static class Sorter implements Runnable{

		int[] array;
		int size;
		int blocks;

		public Sorter(int[] array, int size, int blocks){
			this.array = array;
			this.size = size;
			this.blocks = blocks;
		}

		@Override
		public synchronized void run(){
			startSorting(array, size, blocks);
		}
	}

	private static class Displayer implements Runnable{

		long endTime;

		public Displayer(long endTime){
			this.endTime = endTime;
		}

		@Override
		public synchronized void run(){
			displayFinalResults(endTime);
		}
	}
}

class SetGoState implements Runnable{

	boolean isDisabled;

	public SetGoState(boolean isDisabled){
		this.isDisabled = isDisabled;
	}


	@Override
	public void run(){
		GUI.goButton.setDisable(isDisabled);
		if(isDisabled){
			GUI.goButton.setText("Sorting...");
		}else{
			GUI.goButton.setText("Go");
		}
	}
}