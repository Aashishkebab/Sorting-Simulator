package sorting_algorithms;

public class BatcherSort extends Sort{
	static int[] a;

	public static void batcherSort(int[] a){
		BatcherSort.a = a;
		oddEvenMergeSort(0, a.length);
	}

	/**
	 * sorts a piece of length n of the array
	 * starting at position lo
	 */
	private static void oddEvenMergeSort(int lo, int n){
		if(n > 1){
			int m = n / 2;
			oddEvenMergeSort(lo, m);
			oddEvenMergeSort(lo + m, m);
			oddEvenMerge(lo, n, 1);
		}
	}

	/**
	 * lo is the starting position and
	 * n is the length of the piece to be merged,
	 * r is the distance of the elements to be compared
	 */
	private static void oddEvenMerge(int lo, int n, int r){
		int m = r * 2;
		if(m < n){
			oddEvenMerge(lo, n, m); // even subsequence
			oddEvenMerge(lo + r, n, m); // odd subsequence
			for(int i = lo + r; i + r < lo + n; i += m){
				compare(i, i + r);
			}
		}else{
			compare(lo, lo + r);
		}
	}

	private static void compare(int i, int j){
		if(a[i] > a[j]){
			exchange(i, j);
		}
	}

	private static void exchange(int i, int j){
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
