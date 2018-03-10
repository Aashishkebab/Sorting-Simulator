package sorting_algorithms;

import java.util.Arrays;


public class AashishSort4 extends Sort{
	public static void aashishSort4(int[] array){
		while(!isSorted(array)){
			for(int i = 1; i < array.length; i++){
				if(array[i - 1] > array[i]){
					swapTwoValues(i - 1, i, array);
				}
			}
		}
	}
}
