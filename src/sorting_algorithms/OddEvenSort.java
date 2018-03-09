package sorting_algorithms;

public class OddEvenSort extends Sort{
	public static void oddEvenSort(int[] arr){
		boolean isSorted = false; // Initially array is unsorted
		int n = arr.length;

		while(!isSorted){
			isSorted = true;
			int temp;

			// Perform Bubble sort on odd indexed element
			for(int i = 1; i <= n - 2; i = i + 2){
				if(arr[i] > arr[i + 1]){
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					isSorted = false;
				}
			}

			// Perform Bubble sort on even indexed element
			for(int i = 0; i <= n - 2; i = i + 2){
				if(arr[i] > arr[i + 1]){
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					isSorted = false;
				}
			}
		}
	}
}
