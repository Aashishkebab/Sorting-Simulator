package sorting_algorithms;

public class StoogeSort extends Sort{
	public static void stoogeSort(int[] arr){
		threeStooges(arr, 0, arr.length - 1);
	}

	public static void threeStooges(int[] arr, int l, int h)
	{
		if (l >= h)
			return;

		// If first element is smaller
		// than last,swap them
		if (arr[l] > arr[h])
		{
			int t = arr[l];
			arr[l] = arr[h];
			arr[h] = t;
		}

		// If there are more than 2 elements in
		// the array
		if (h-l+1 > 2)
		{
			int t = (h-l+1) / 3;

			// Recursively sort first 2/3 elements
			threeStooges(arr, l, h-t);

			// Recursively sort last 2/3 elements
			threeStooges(arr, l+t, h);

			// Recursively sort first 2/3 elements
			// again to confirm
			threeStooges(arr, l, h-t);
		}
	}
}
