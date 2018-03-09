/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

/**
 * @author Aashish Bharadwaj
 */
public class MergeSort extends Sort{


	/**
	 * This method exists solely to call the real method, but the name of this method is more friendly to programmers
	 *
	 * @param array Array of generics that is passed in to the method
	 * @return Resultant array
	 */
	public static int[] mergeSort(int[] array){
		return splitData(array);
	}

	public static int[] splitData(int[] array){
		if(array.length <= 1){
			return array;
		}

		int[] newArray1 = new int[(array.length) / 2];
		int[] newArray2 = new int[(int)(Math.ceil(((float)(array.length)) / 2))];
		int i;

		for(i = 0; i < (array.length) / 2; i++){
			newArray1[i] = array[i];
		}
		for(int j = i; j < array.length; j++){
			newArray2[j - i] = array[j];
		}

		newArray1 = splitData(newArray1);
		newArray2 = splitData(newArray2);

		return mergeData(newArray1, newArray2);
	}

	public static int[] mergeData(int[] part1, int[] part2){

		if(part1.length == 0){
			return part2;
		}else if(part2.length == 0){
			return part1;
		}

		int[] array = new int[part1.length + part2.length];

//        System.out.println("Merging " + Arrays.toString(part1) + " with " + Arrays.toString(part2));    //System.out.println("");

		int index1 = 0, index2 = 0;
		int indexResult = 0;

		try{
			while(index1 < part1.length || index2 < part2.length){
				try{
					if(part1[index1] <= part2[index2]){
						array[indexResult] = part1[index1];
						index1++;
					}else{
						array[indexResult] = part2[index2];
						index2++;
					}
					//System.out.println("As we go: " + Arrays.toString(array));
				}catch(Exception arrayEmpty){
					addArrays(array, indexResult, part1, index1);
					addArrays(array, indexResult, part2, index2);

					return Sort.trimArray(array);
				}

				indexResult++;
			}
		}catch(Exception nothingToMerge){
		}

		return array;
	}

	public static void addArrays(int[] mainArray, int mainIndex, int[] addition, int additionIndex){
		//System.out.println("addArrays");

		while(true){
			try{
				mainArray[mainIndex] = addition[additionIndex];

				mainIndex++;
				additionIndex++;
			}catch(Exception arrayEmpty){
				return; //May need to return the array
			}
		}
	}

}