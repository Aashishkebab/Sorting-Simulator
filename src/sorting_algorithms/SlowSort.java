package sorting_algorithms;

public class SlowSort extends Sort{
	public static void slowSort(int[] array){
		doTheSort(array, 0, array.length - 1);
	}

	private static void doTheSort(int[] array, int beginning, int end){
		if(beginning >= end){
			return;
		}
		int m = (beginning + end) / 2;
		doTheSort(array, beginning, m);
		doTheSort(array, m + 1, end);

		if(array[m] > array[end]){
			swapTwoValues(m, end, array);
		}
		doTheSort(array, beginning, end - 1);
	}
}
