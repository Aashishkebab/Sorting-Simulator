package sorting_algorithms;

public class CocktailSort extends Sort{
	public static void cocktailSort(int a[]){
		boolean swapped = true;
		int start = 0;
		int end = a.length;

		while(swapped){
			// reset the swapped flag on entering the
			// loop, because it might be true from a
			// previous iteration.
			swapped = false;

			// loop from bottom to top same as
			// the bubble sort
			for(int i = start; i < end - 1; ++i){
				if(a[i] > a[i + 1]){
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swapped = true;
				}
			}

			// if nothing moved, then array is sorted.
			if(!swapped){
				break;
			}

			// otherwise, reset the swapped flag so that it
			// can be used in the next stage
			swapped = false;

			// move the end point back by one, because
			// item at the end is in its rightful spot
			end = end - 1;

			// from top to bottom, doing the
			// same comparison as in the previous stage
			for(int i = end - 1; i >= start; i--){
				if(a[i] > a[i + 1]){
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swapped = true;
				}
			}

			// increase the starting point, because
			// the last stage would have moved the next
			// smallest number to its rightful spot.
			start = start + 1;
		}
	}
}
