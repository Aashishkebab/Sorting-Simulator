/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import javafx.application.Platform;
import static Sorting_Methods.Project4_Bharadwaj.alert;
import static sorting_algorithms.QuickSort.realQuickSort;
import static sorting_algorithms.Sort.swapTwoValues;

/**
 *
 * @author Aashish Bharadwaj
 */
public class QuickSort extends Sort{
    
    private static Comparable[] array;
    public static int recurse = 0;

    public static Comparable[] quickSort(Comparable[] array){
        QuickSort.array = array;
        return realQuickSort(array, 0, array.length - 1);
    }
    
    private static Comparable[] actualQuickSort(int lower, int upper){  //Deprecated
        if(array == null || array.length <= 0){
            return null;
        }
        
        int newLow = lower, newHigh = upper;
        Comparable pivot = array[(int)(Math.random() * array.length)];
        
        while(newLow <= newHigh){
            while(array[newLow].compareTo(pivot) < 0){
                newLow++;
            }
            while(array[newHigh].compareTo(pivot) > 0){
                newHigh--;
            }
            
            if(newLow <= newHigh){
                swapTwoValues(newLow, newHigh, array);
                
                newLow++;   newHigh--;
            }
        }
        
        try{
            if(lower < newHigh){
                if((newHigh - lower) > 1){
                    actualQuickSort(lower, newHigh);
                }
            }
            if(newLow < upper){
                if((upper - newLow) > 1){
                    actualQuickSort(newLow, upper);
                }
            }
        }catch(StackOverflowError tooLarge){
            Platform.runLater(new TooLargeQuick());
            array = null;
            return null;
        }
        
        return array;
    }
    
    static Comparable[] realQuickSort(Comparable[] array, int lower, int upper){
        if(lower < upper){
            int pivot;
            
            pivot = partitionamafy(array, lower, upper);
            
//            Thread part1 = new Thread(new QuickThread(array, lower, pivot - 1));
//            Thread part2 = new Thread(new QuickThread(array, pivot + 1, upper));
//            
//            part1.start();  part2.start();
//            try{
//                part1.join();   part2.join();
//            }catch(InterruptedException e){}
            
            array = realQuickSort(array, lower, pivot - 1);
            array = realQuickSort(array, pivot + 1, upper);
        }
        
        return array;
    }

    private static int partitionamafy(Comparable[] array, int lower, int upper) {
        recurse++;
        System.out.println(recurse);
        
        Comparable pivot = array[upper];
        int newLow = lower - 1;
        int i;
        
        for(i = lower; i < upper; i++){
            if(array[i].compareTo(pivot) <= 0){
                newLow++;
                swapTwoValues(i, newLow, array);
            }
        }
        
        swapTwoValues(newLow + 1, upper, array);
        return newLow + 1;
    }
    
}

class TooLargeQuick implements Runnable{
    
    @Override
    public void run() {
        alert("Cannot Sort", "You have overloaded the quickSort algorithm.", "Please enter a smaller list size or block size.", "WARNING", false);
    }
    
}

class QuickThread implements Runnable{
    
    Comparable[] array;
    int lower, upper;
    
    public QuickThread(Comparable[] array, int lower, int upper){
        this.array = array;
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public void run(){
        this.array = realQuickSort(array, lower, upper);
    }
    
}