/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

/**
 * @author Aashish Bharadwaj
 */
public class QuickSort extends Sort{

	public static void quickSort(int[] array){
		realQuickSort(array, 0, array.length - 1);
	}

	private static int[] realQuickSort(int[] array, int lower, int upper){
		if(lower < upper){
			int pivot;

			pivot = partitionamafy(array, lower, upper);

			array = realQuickSort(array, lower, pivot - 1);
			array = realQuickSort(array, pivot + 1, upper);

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