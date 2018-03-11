package sorting_algorithms;

public class AashishSort1 extends Sort{
	public static int[] aashishSort1(int[] array){   //Assuming base 10
		return doAashishSort1(array, (int)(Math.pow(10, (int)(Math.log10(getMaxValue(array)) + 1))),
		                      (short)Math.log10(getMaxValue(array))
		);
	}

	public static int[] doAashishSort1(int[] array, int modulus, short numberOfDigits){
		int[][] digitArray = new int[10][array.length];
		int[] digitArrayIndexes = new int[10];

		for(int i = 0; i < digitArrayIndexes.length; i++){
			digitArrayIndexes[i] = 0;
		}


		for(int j = 0; j < array.length; j++){
			int digit = (array[j] % modulus) / (int)Math.pow(10, numberOfDigits);
			digitArray[digit][digitArrayIndexes[digit]++] = array[j];
		}

		if(numberOfDigits == 0){
			int arrayIndex = 0;
			int[] newArray = new int[getNumberOf2dItems(digitArrayIndexes)];
			for(int w = 0; w < 10; w++){    //Copy results back into array in order
				for(int u = 0; u < digitArrayIndexes[w]; u++){
					newArray[arrayIndex++] = digitArray[w][u];
				}
			}
			return newArray;
		}

		modulus /= 10;
		for(int p = 0; p < 10; p++){
			digitArray[p] = doAashishSort1(trimUnused(digitArray[p], digitArrayIndexes[p]), modulus,
			                               (short)(numberOfDigits - 1)
			);
		}

		int arrayIndex = 0;
		for(int w = 0; w < 10; w++){    //Copy results back into array in order
			for(int u = 0; u < digitArrayIndexes[w]; u++){
				array[arrayIndex++] = digitArray[w][u];
			}
		}
		return array;
	}

	public static int[] trimUnused(int[] array, int end){
		int[] newArray = new int[end];

		for(int i = 0; i < end; i++){
			newArray[i] = array[i];
		}
		return newArray;
	}

	public static int getNumberOf2dItems(int[] indexArray){
		int numberOfElements = 0;
		for(int i = 0; i < indexArray.length; i++){
			numberOfElements += indexArray[i];
		}
		return numberOfElements;
	}
}
