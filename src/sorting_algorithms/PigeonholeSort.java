package sorting_algorithms;

import java.util.Arrays;


public class PigeonholeSort extends Sort{
	public static void pigeonholeSort(int array[]){
		int min = array[0];
		int max = array[0];
		int range, i, j, index;
		int n = array.length;

		for(int a = 0; a < n; a++){
			if(array[a] > max){
				max = array[a];
			}
			if(array[a] < min){
				min = array[a];
			}
		}

		range = max - min + 1;
		int[] pigeonHoles = new int[range];

		for(i = 0; i < n; i++){
			pigeonHoles[array[i] - min]++;
		}

		index = 0;

		for(j = 0; j < range; j++){
			while(pigeonHoles[j]-- > 0){
				array[index++] = j + min;
			}
		}
		return;
	}
}
