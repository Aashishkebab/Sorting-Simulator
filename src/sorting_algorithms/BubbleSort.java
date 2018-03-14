/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

/**
 * @author Aashish Bharadwaj
 */
public class BubbleSort extends Sort{
	public static void bubbleSort(int[] array){
		boolean haveSwapped = true;
		for(int i = 0; i < array.length && haveSwapped; i++){
			haveSwapped = false;
			for(int j = 1; j < array.length - i; j++){
				if(array[j - 1] > array[j]){
					haveSwapped = true;
					swapTwoValues(j - 1, j, array);
				}
			}
		}
		return;
	}
}