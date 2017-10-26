/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import static sorting_algorithms.Sort.swapTwoValues;

/**
 *
 * @author Aashish Bharadwaj
 */
public class RandomSort {

    public static Comparable[] randomSort(Comparable[] array){
        boolean sorted = true;
        int loops = 0;
        
        while(true){
            loops++;
            
            swapTwoValues((int)(Math.random() * array.length), (int)(Math.random() * array.length), array);
            
            for(int i = 1; i < array.length; i++){
                if(array[i].compareTo(array[i - 1]) < 0){
                    sorted = false;
                    break;
                }
            }
            if(sorted){
                break;
            }
            
            if(loops >= (Integer.MAX_VALUE / 17)){
                System.out.println("");
                System.out.println("Took too long, here's what we got.");
                
                return array;
            }
            sorted = true;
            
        }
        
        return array;
    }
    
}
