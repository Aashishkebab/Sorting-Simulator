package sorting_algorithms;

public class HeapSort extends Sort{
	public static void heapSort(int[] array){
		int n = array.length;

		// Build heap (rearrange array)
		for(int i = n / 2 - 1; i >= 0; i--){
			heapify(array, n, i);
		}

		// One by one extract an element from heap
		for(int i = n - 1; i >= 0; i--){
			// Move current root to end
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			// call max heapify on the reduced heap
			heapify(array, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	static void heapify(int[] array, int n, int i){
		int largest = i;  // Initialize largest as root
		int l = 2 * i + 1;  // left = 2*i + 1
		int r = 2 * i + 2;  // right = 2*i + 2

		// If left child is larger than root
		if(l < n && array[l] > array[largest]){
			largest = l;
		}

		// If right child is larger than largest so far
		if(r < n && array[r] > array[largest]){
			largest = r;
		}

		// If largest is not root
		if(largest != i){
			int swap = array[i];
			array[i] = array[largest];
			array[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(array, n, largest);
		}
	}
}
