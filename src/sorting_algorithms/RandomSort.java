/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import Sorting_Simulator.GUI;


/**
 * @author Aashish Bharadwaj
 */
public class RandomSort extends Sort{

	public static void randomSort(int[] array){
		int loops = 0;

		while(true){
			loops++;

			swapTwoValues((int)(Math.random() * array.length), (int)(Math.random() * array.length),
			              array);

			if(isSorted(array)){
				break;
			}

			if(loops >= (Integer.MAX_VALUE / 17)){
				GUI.alert("I'm out of patience", "Took to long.", "What did you " + "expect?" + "",
				          "INFORMATION", false);
				return;
			}
		}
	}

}
