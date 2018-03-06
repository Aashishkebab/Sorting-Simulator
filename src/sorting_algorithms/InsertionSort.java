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
    public static Comparable[] insertionSort(Comparable[] array) {
        for(int i = 0; i < array.length; i++){
            try{
                for(int j = i; array[j].compareTo(array[j - 1]) < 0; j--){
//                    System.out.println(Arrays.toString(array));
                    swapTwoValues(j, j - 1, array);
                }
            }catch(Exception atBeginning){}
        }

        return array;
    }
}