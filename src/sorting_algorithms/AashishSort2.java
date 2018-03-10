package sorting_algorithms;

public class AashishSort2 extends Sort{
	public static int[] aashishSort2(int[] array){
		int[] indexArray = new int[array.length];

		for(int i = 0; i < indexArray.length; i++){
			indexArray[i] = -1;
		}

		for(int i = 0; i < array.length; i++){
			indexArray[i] = getMinIndexExcluding(array, indexArray, i);
		}

		int[] newArray = new int[array.length];
		for(int i = 0; i < array.length; i++){
			newArray[i] = array[indexArray[i]];
		}

		return newArray;
	}

	public static int getMinIndexExcluding(int[] array, int[] exclusions, int max){
		int mn = getFirstNotExcluded(exclusions);
		for(int i = 0; i < array.length; i++){
			if(array[i] < array[mn] && !isNumberInArray(i, exclusions, max)){
				mn = i;
			}
		}
		return mn;
	}

	public static int getFirstNotExcluded(int[] exclusions){
		for(int i = 0; i < exclusions.length; i++){
			if(!isNumberInArray(i, exclusions, exclusions.length)){
				return i;
			}
		}
		return exclusions.length - 1;
	}

	public static boolean isNumberInArray(int number, int[] array, int max){
		for(int i = 0; i < max; i++){
			if(array[i] == number){
				return true;
			}
		}
		return false;
	}
}
