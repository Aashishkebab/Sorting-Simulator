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
public class InsertionSort extends Sort{
    public static void insertionSort(int[] array){
        int n = array.length;
        for (int i = 1; i < n; ++i){
            int key = (int)array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && (int)array[j] > key){
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return;
    }
}