package sorting_algorithms;

public class DropSort extends Sort{
	public static int[] dropSort(int[] array){
		int greatest = 0;
		for(int i = 0; i < array.length; i++){
			try{
				if(array[greatest] > array[i]){
					array = drop(i, array);
					i--;
				}
				else if(array[greatest] < array[i]){
					greatest = i;
				}
			}catch(Exception e){
			}
		}
		return array;
	}

	public static int[] drop(int itemToDrop, int[] array){
		int[] newArray = new int[array.length - 1];

		for(int i = 0, j = 0; i < array.length; i++){
			if(i == itemToDrop){
				i++;
			}

			try{
				newArray[j] = array[i];
			}catch(Exception e){
			}
			j++;
		}

		return newArray;
	}
}
