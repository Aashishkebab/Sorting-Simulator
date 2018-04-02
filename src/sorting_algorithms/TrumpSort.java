/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

/**
 * @author Aashish Bharadwaj
 */
public class TrumpSort extends Sort{

	//This is all satire, please take this in good humor.

	static public int immigrants = 0;

	public static int[] makeSortingGreatAgain(int[] array){
		immigrants = 0;
		int wall = 0;
		boolean[] registryOfIllegals = new boolean[array.length];

		for(int i = 0; i < array.length; i++){
			try{
				if(array[wall] > array[i]){
					//array = deport(i, array);
					//i--;
					registryOfIllegals[i] = true;
				}
				else if(array[wall] < array[i]){
					wall = i;
				}
			}catch(Exception e){
			}
		}
		array = deportAll(array, registryOfIllegals);

		return array;
	}

	static int[] deportAll(int[] array, boolean[] registry){
		int[] newArray = new int[array.length - getNumberOfImmigrants(registry)];

		int j = 0;
		for(int i = 0; i < array.length; i++){
			if(!registry[i]){
				newArray[j] = array[i];
				j++;
			}
			else{
				immigrants++;
			}
		}
		return newArray;
	}

	static int getNumberOfImmigrants(boolean[] array){
		int illegals = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i]){
				illegals++;
			}
		}
		return illegals;
	}

}
