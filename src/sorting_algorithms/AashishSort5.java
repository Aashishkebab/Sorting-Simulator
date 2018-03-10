package sorting_algorithms;

//  Similar to AashishSort2, but rather adding found number to an exclusions list, it just
//  deletes it from the original array.

public class AashishSort5 extends Sort{
	public static int[] aashishSort5(int[] array){
		int[] newArray = new int[array.length];

		for(int i = 0; i < newArray.length; i++){
			array = getAndDeleteMinValue(array, newArray, i);
		}
		return newArray;
	}

	static int[] getAndDeleteMinValue(int[] array, int[] newArray, int index){
		int mnIndex = 0;

		for(int i = 1; i < array.length; i++){
			if(array[i] < array[mnIndex]){
				mnIndex = i;
			}
		}

		newArray[index] = array[mnIndex];

		array = deleteIndex(array, mnIndex);
		return array;
	}

}
