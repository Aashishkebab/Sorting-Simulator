/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

/**
 *
 * @author Aashish Bharadwaj
 */
public class SelectionSort extends Sort{
    public static void selectionSort(Comparable[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i].compareTo(array[j]) > 0){
                    swapTwoValues(i, j, array);
                }
            }
        }
        return;
    }
}
