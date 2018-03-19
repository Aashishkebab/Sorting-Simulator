package sorting_algorithms;

public class CountingSort extends Sort{
	public static void countingSort(int[] array){
		int[] count = new int[getMaxValue(array) + 1]; //Assume initialized to zeroes

		for(int i = 0; i < array.length; i++){
			count[array[i]]++;
		}

		int outPos = 0;
		for(int i = 0; outPos < array.length; i++){
			for(int j = 0; j < count[i]; j++){
				array[outPos++] = i;
			}
		}
		return;
	}
}
