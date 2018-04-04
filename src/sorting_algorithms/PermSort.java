package sorting_algorithms;

/*
 * PermSortAlgorithm.java
 * Patrick Morin takes no responsibility for anything. So there.
 *
 */

/**
 * A PermSort Demonstration algorithm.  The PermSort algorithm is due
 * to Patrick Morin <http:www.scs.carleton.ca/~morin>.  The algorithm
 * works by trying every permutation until it finds one that's
 * sorted.  That's right, there are n! permutations and it takes O(n)
 * time to test each one, yielding an O(nn!) algorithm.  No hate mail
 * please.
 *
 * @author Patrick Morin
 */
public class PermSort extends Sort{
	/**
	 * Privately sort the array using the PermSort algorithm.
	 */
	private static boolean sort(int a[], int i){
		int j;

		// Check if array is already sorted
		if(isSorted(a)){
			return true;
		}

		// Array wasn't sorted so start trying permutations until we
		// get the right one.
		for(j = i + 1; j < a.length; j++){
			int T = a[i];
			a[i] = a[j];
			a[j] = T;
			if(sort(a, i + 1)){
				return true;
			}
			T = a[i];
			a[i] = a[j];
			a[j] = T;
		}
		return false;
	}

	/**
	 * Sort the input using the  PermSort algorithm.
	 */
	public static void permSort(int a[]) throws Exception{
		sort(a, 0);
	}
}
