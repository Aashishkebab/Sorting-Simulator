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
		int wall = 0;

		for(int i = 0; i < array.length; i++){
			try{
				if(array[wall] > array[i]){
					//array = deport(i, array);
					//i--;
					array[i] = 0;
				}else if(array[wall] < array[i]){
					wall = i;
				}
			}catch(Exception e){
			}
		}
		array = deportAll(array);

//        System.out.println("Here it is:\n" + Arrays.toString(array));

		return array;
	}

	static int[] deportAll(int[] array){
		int[] newArray = new int[array.length - getNumberOfImmigrants(array)];

		int j = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] != 0){
				newArray[j] = array[i];
				j++;
			}
		}
		return newArray;
	}

	static int getNumberOfImmigrants(int[] array){
		int illegals = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] == 0){
				illegals++;
			}
		}
		return illegals;
	}

	public static int[] deport(int illegal, int[] array){
		int[] newArray = new int[array.length - 1];
		immigrants++;

		for(int i = 0, j = 0; i < array.length; i++){
			if(i == illegal){
				i++;
			}

			try{
				newArray[j] = array[i];
			}catch(Exception e){
			}
			j++;
		}

		return newArray;
	}

}