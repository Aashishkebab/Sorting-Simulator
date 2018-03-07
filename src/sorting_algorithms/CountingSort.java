package sorting_algorithms;

public class CountingSort extends Sort{
	public static void countingSort(Comparable array[]) {
		int max = getMax(array);

		//The output array that will have sorted array
		Comparable output[] = new Comparable[array.length];

		//Create a count array to store count of individual
		//numbers and initialize count array as 0
		int count[] = new int[max + 1];
		for(int i = 0; i < max; ++i) {
			count[i] = 0;
		}

		//store count of each number
		for(int i = 0; i < array.length; ++i){
			++count[(int)array[i]];
		}

		//Change count[i] so that count[i] now contains actual
		//position of this character in output array
		for(int i = 1; i <= max; ++i){
			count[i] += count[i - 1];
		}

		//Build the output array
		for(int i = 0; i < array.length; ++i){
			output[count[(int)array[i]] - 1] = array[i];
			--count[(int)array[i]];
		}

		// Copy the output array, so that it now
		//contains sorted numbers
		for(int i = 0; i < array.length; ++i){
			array[i] = output[i];
		}
		return;
	}
}