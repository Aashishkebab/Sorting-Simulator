/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

/**
 * @author Aashish Bharadwaj
 */
public class BernieSort extends Sort{
	public static int averageWealth;

	public static int[] spreadTheWealth(int[] array){
		long sum = 0;

		for(int i = 0; i < array.length; i++){
			sum += array[i];
		}
		averageWealth = (int)(sum / (array.length));

		for(int i = 0; i < array.length; i++){
			array[i] = averageWealth;
		}

		return array;
	}
}
