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
		return splitByDigit(array, (short)Math.log10(getMaxValue(array)), array.length);
	}

	/**
	 * Splits the array into multiple arrays based on a significant digit.
	 *
	 * @param array          Array to be split into multiple arrays/buckers
	 * @param numberOfDigits The number of digits that are being to be looked at,
	 *                       starting at the least significant digit and going backwards.
	 * @param arrLength      Number of consecutive items in passed in "array" that are valid.
   *                       We need this because 'array' will contain a bunch of extra '0' elements.
	 * @return The array split into digits.
	 */
	private static int[] splitByDigit(int[] array, short numberOfDigits, int arrLength){
		//  Use above method signature if using modulus variable, which is redundant.

		/*
		 * Create a two-dimensional array to store ten "buckets."
		 * Have buckets for the numbers 0-9, and each bucket should be
		 * large enough to handle the entire array (second dimension).
		 */
		int[][] digitArray = new int[10][array.length];

		/*
		 * Keep track of how many items are inside each bucket to nullify the extra 0s
		 * These extra 0s exist because each bucket is the size of the original array,
		 * but each bucket will not receive that many items.
		 *
		 * We're assuming that digitArrayIndexes is automatically initialized to all zeroes in Java.
 		 * Ports to other languages may require manually filling the array with zeroes.
		 */
		int[] digitArrayIndexes = new int[10];

		for(int j = 0; j < arrLength; j++){
			/*
			 * Takes a certain number of digits of an element of array and divides by most
			 * significant decimal to obtain most usable. significant digit.
			 * Essentially takes the modulus of the array item and then divides it by the number
			 * of decimal places to take into account.
			 * Because it is an integer, it will drop decimals.
			 */
			int modulus = (int)Math.pow(10, numberOfDigits);

			/*
			 * Takes the array element, then mods it by a power of 10.
			 * This will drop the more significant digits.
			 * Then, divides by the variable "modulus", which drops
			 * the less significant digits. All that remains is the digit
			 * that we want to test against.
			 */
			int digit = (array[j] % (modulus * 10)) / modulus;

			/*
			 * Stores the number in the array in the appropriate 'bucket', right after the
			 * previous one stored in the same bucket. digitArrayIndexes keeps track of how many
			 * are stored in each bucket, which is now incremented.
			 */
			digitArray[digit][digitArrayIndexes[digit]++] = array[j];
		}

		if(numberOfDigits == 0){
			int arrayIndex = 0;
			/*
			 * Create array with the appropriate size to fit everything in all the buckets
			 */
			int[] newArray = new int[sumArray(digitArrayIndexes)];
			for(int w = 0; w < 10; w++){	// Split array into separate arrays/Buckets
				for(int u = 0; u < digitArrayIndexes[w]; u++){	// Iterate through each bucket
					newArray[arrayIndex++] = digitArray[w][u];
				}
			}
			return newArray;
		}

		numberOfDigits--;
		for(int p = 0; p < 10; p++){
			/*
			 * Redo the algorithm on only one bucket (aka a new Most Significant Digit)
			 * with a reduced number of digits.
			 */
			if(digitArrayIndexes[p] > 1){   // Only if there is more than one item in the bucket
				digitArray[p] = splitByDigit(digitArray[p], (short)numberOfDigits,
				                             digitArrayIndexes[p]);
			}
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
