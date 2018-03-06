package sorting_algorithms;

public class CountingSort {
	public static Comparable[] countingSort(Comparable arr[]) {
		int n = arr.length;

		// The output character array that will have sorted arr
		Comparable output[] = new Comparable[n];

		// Create a count array to store count of individual
		// characters and initialize count array as 0
		int count[] = new int[arr.length];
		for(int i = 0; i < arr.length; ++i) {
			count[i] = 0;
		}

		// store count of each character
		for(int i = 0; i < n; ++i){
			++count[(int)arr[i]];
		}

		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		for (int i = 1; i <= 255; ++i){
			count[i] += count[i - 1];
		}

		// Build the output character array
		for (int i = 0; i<n; ++i){
			output[count[(int)arr[i]] - 1] = arr[i];
			--count[(int)arr[i]];
		}

		// Copy the output array to arr, so that arr now
		// contains sorted characters
		for (int i = 0; i<n; ++i){
			arr[i] = output[i];
		}

		return arr;
	}
}
