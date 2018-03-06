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
public class BubbleSort extends Sort{
    public static void bubbleSort(Comparable[] array) {
        for(int i = array.length - 1; i >= 0; i--){
            for(int j = array.length - 1; j >= 0; j--){
//                try{
                    if(array[i].compareTo(array[j]) > 0){
                        swapTwoValues(i, j, array);
                    }
//                }catch(Exception e){}
            }
        }
        return;
    }
}