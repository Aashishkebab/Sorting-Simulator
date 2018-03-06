package sorting_algorithms;

public class BucketSort extends Sort{
	public static Comparable[] bucketSort(Comparable[] a){
		int[] bucket = new int[getMax(a) + 1];

		for(int i = 0; i < bucket.length; i++){
			bucket[i] = 0;
		}

	      for (int i = 0; i < a.length; i++){
			bucket[(int)a[i]]++;
		}

		int outPos = 0;
	      for(int i = 0; i < bucket.length; i++){
			for (int j = 0; j < bucket[i]; j++){
				a[outPos++] = i;
			}
		}

		return a;
	}
}
