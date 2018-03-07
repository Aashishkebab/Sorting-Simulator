package sorting_algorithms;

import java.util.Arrays;

public class PiegeonholeSort {
	public static void pigeonhole_sort(int array[], int n){
		int min = array[0];
		int max = array[0];
		int range, i, j, index;

		for(int a = 0; a < n; a++){
			if(array[a] > max) {
				max = array[a];
			}
			if(array[a] < min) {
				min = array[a];
			}
		}

		range = max - min + 1;
		int[] phole = new int[range];
		Arrays.fill(phole, 0);

		for(i = 0; i < n; i++){
			phole[array[i] - min]++;
		}
		
		index = 0;

		for(j = 0; j < range; j++){
			while(phole[j]-- > 0){
				array[index++] = j + min;
			}
		}
		return;
	}
}
