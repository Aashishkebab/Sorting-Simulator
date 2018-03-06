package sorting_algorithms;

public class BucketSort extends Sort{
	public static void bucketSort(Comparable[] array){
		int[] bucket = new int[getMax(array) + 1];

		for(int i = 0; i < bucket.length; i++){
			bucket[i] = 0;
		}

		for (int i = 0; i < array.length; i++){
			bucket[(int)array[i]]++;
		}

		int outPos = 0;
        for(int i = 0; i < bucket.length; i++){
			for (int j = 0; j < bucket[i]; j++){
				array[outPos++] = i;
			}
		}
		return;
	}
}
