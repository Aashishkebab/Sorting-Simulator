package sorting_algorithms;

/**
 * This sorting algorithm makes no comparisons.
 * Rather, it uses properties of mathematics to sort the data.
 * <p>
 * The algorithm finds the number of digits in the largest item in the array.
 * Then, it splits the data into groups, or 'buckets', based on the most significant digit.
 * It stores these groups in a two dimensional array.
 * <p>
 * It then recursively calls itself on each digit with an increasing modulus (to ignore preceding
 * digits), and a decreasing 'numberOfDigits'.
 * Once the numberOfDigits equals zero, the program copies the data in the 2-d array, and returns
 * it.
 * <p>
 * The easiest way to think of it is a purely recursive Bucket Sort, from which this algorithms
 * was inspired.
 * <p>
 * The assumption is that the numeric system is in base 10.
 * <p>
 * Author: Aashish Bharadwaj
 */

public class AashishSort1 extends Sort{

	/**
	 * Calculates the appropriate parameters and initiates sorting.
	 *
	 * @param array The array to be sorted.
	 * @return The sorted array.
	 */
	public static int[] aashishSort1(int[] array){
		return splitByDigit(array, (short)Math.log10(getMaxValue(array)));
	}

	/**
	 * Splits the array into multiple arrays based on a significant digit.
	 *
	 * @param array          Array to be split into multiple arrays.
	 * @param numberOfDigits The number of digits that are being looked at, starting at the least
	 *                       significant digit and going backwards.
	 * @return The array split into digits.
	 */
	public static int[] splitByDigit(int[] array, short numberOfDigits){
		//  Use above method signature if using modulus variable, which is redundant.

		int[][] digitArray = new int[10][array.length]; // Create ten 'buckets'
		int[] digitArrayIndexes = new int[10];  // Create list to store number of items per bucket.
		// We're assuming that digitArrayIndexes is automatically initialized to all zeroes in Java.
		// Ports to other languages may require manually filling the array with zeroes.

		for(int j = 0; j < array.length; j++){
			// Take a certain number of digits of an element of array and divides by most
			// significant decimal to obtain most usable. significant digit.
			// Essentially takes the modulus of the array item and then divides it by the number
			// of decimal places to take into account

			int modulus = (int)Math.pow(10, numberOfDigits);
			int digit = (array[j] % (modulus * 10)) / modulus;


			// Stores the number in the array in the appropriate 'bucket', right after the
			// previous one stored in the same bucket. digitArrayIndexes keeps track of how many
			// are stored in each bucket, which is now incremented.
			digitArray[digit][digitArrayIndexes[digit]++] = array[j];
		}

		if(numberOfDigits == 0){
			int arrayIndex = 0;
			// Create array with the appropriate size to fit everything in all the buckets.
			int[] newArray = new int[sumArray(digitArrayIndexes)];
			for(int w = 0; w < 10; w++){    //Copy results back into array in order
				for(int u = 0; u < digitArrayIndexes[w]; u++){  //Iterate through each bucket.
					newArray[arrayIndex++] = digitArray[w][u];
				}
			}
			return newArray;
		}

		for(int p = 0; p < 10; p++){
			// Redo the algorithm on only one bucket (aka one Most Significant Digit).
			// Also reduce the number of digits being used by one.
			digitArray[p] = splitByDigit(trimUnused(digitArray[p], digitArrayIndexes[p]),
			                             (short)(numberOfDigits - 1));
		}

		int arrayIndex = 0;
		for(int w = 0; w < 10; w++){    //Copy results back into array in order
			for(int u = 0; u < digitArrayIndexes[w]; u++){
				array[arrayIndex++] = digitArray[w][u];
			}
		}
		return array;
	}

	/**
	 * Create array with only items from original array, and not proceeding zeroes.
	 *
	 * @param array Array to pull data from
	 * @param end   Where data should stop being pulled
	 * @return Ending array
	 */
	public static int[] trimUnused(int[] array, int end){
		int[] newArray = new int[end];

		for(int i = 0; i < end; i++){
			newArray[i] = array[i];
		}
		return newArray;
	}

	/**
	 * Sums the integers in an array
	 *
	 * @param indexArray Array to pull numbers from
	 * @return Sum
	 */
	public static int sumArray(int[] indexArray){
		int numberOfElements = 0;
		for(int i = 0; i < indexArray.length; i++){
			numberOfElements += indexArray[i];
		}
		return numberOfElements;
	}
}
