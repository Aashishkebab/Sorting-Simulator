package sorting_algorithms;

public class CombSort extends Sort{
	// To find gap between elements
	static int getNextGap(int gap){
		// Shrink gap by Shrink factor
		gap = (gap * 10) / 13;
		if(gap < 1){
			return 1;
		}
		return gap;
	}

	// Function to sort arr[] using Comb Sort
	public static void combSort(int[] array){
		int n = array.length;

		// initialize gap
		int gap = n;

		// Initialize swapped as true to make sure that
		// loop runs
		boolean swapped = true;

		// Keep running while gap is more than 1 and last
		// iteration caused a swap
		while(gap != 1 || swapped){
			// Find next gap
			gap = getNextGap(gap);

			// Initialize swapped as false so that we can
			// check if swap happened or not
			swapped = false;

			// Compare all elements with current gap
			for(int i = 0; i < n - gap; i++){
				if(array[i] > array[i + gap]){
					// Swap arr[i] and arr[i+gap]
					int temp = array[i];
					array[i] = array[i + gap];
					array[i + gap] = temp;

					// Set swapped
					swapped = true;
				}
			}
		}
		return;
	}
}
