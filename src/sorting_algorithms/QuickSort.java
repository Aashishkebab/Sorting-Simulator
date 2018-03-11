/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import javafx.application.Platform;

import static Sorting_Simulator.SortingSimulator.alert;
import static sorting_algorithms.QuickSort.realQuickSort;


/**
 * @author Aashish Bharadwaj
 */
public class QuickSort extends Sort{

	public static void quickSort(int[] array){
		realQuickSort(array, 0, array.length - 1);
	}

	private static int[] actualQuickSort(int[] array, int lower, int upper){  //Deprecated
		if(array == null || array.length <= 0){
			return null;
		}

		int newLow = lower, newHigh = upper;
		int pivot = array[(int)(Math.random() * array.length)];

		while(newLow <= newHigh){
			while(array[newLow] < pivot){
				newLow++;
			}
			while(array[newHigh] > pivot){
				newHigh--;
			}

			if(newLow <= newHigh){
				swapTwoValues(newLow, newHigh, array);

				newLow++;
				newHigh--;
			}
		}

		try{
			if(lower < newHigh){
				if((newHigh - lower) > 1){
					actualQuickSort(array, lower, newHigh);
				}
			}
			if(newLow < upper){
				if((upper - newLow) > 1){
					actualQuickSort(array, newLow, upper);
				}
			}
		}catch(StackOverflowError tooLarge){
			Platform.runLater(new TooLargeQuick());
			array = null;
			return null;
		}

		return array;
	}

	static int[] realQuickSort(int[] array, int lower, int upper){
		if(lower < upper){
			int pivot;

			try{
				pivot = partitionamafy(array, lower, upper);

				array = realQuickSort(array, lower, pivot - 1);
				array = realQuickSort(array, pivot + 1, upper);

			}catch(StackOverflowError e){
				Platform.runLater(new TooLargeQuick());
				array = null;
				return null;
			}catch(NullPointerException e){
				return null;
			}
		}

		return array;
	}

	private static int partitionamafy(int[] array, int lower, int upper){

		int pivot = array[upper];


		int newLow = lower - 1;
		int i;

		for(i = lower; i < upper; i++){
			if(array[i] <= pivot){
				newLow++;
				swapTwoValues(i, newLow, array);
			}
		}

		swapTwoValues(newLow + 1, upper, array);
		return newLow + 1;

	}

}

class TooLargeQuick implements Runnable{

	@Override
	public void run(){
		alert("Cannot Sort", "You have overloaded the quickSort algorithm.",
		      "Please enter a smaller list size or block size.", "ERROR", true);
	}

}

class QuickThread implements Runnable{

	int[] array;
	int lower, upper;

	public QuickThread(int[] array, int lower, int upper){
		this.array = array;
		this.lower = lower;
		this.upper = upper;
	}

	@Override
	public void run(){
		this.array = realQuickSort(array, lower, upper);
	}

}