/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting_Methods;

import sorting_algorithms.RandomSort;
import sorting_algorithms.BubbleSort;
import sorting_algorithms.SelectionSort;
import sorting_algorithms.MergeSort;
import sorting_algorithms.QuickSort;
import sorting_algorithms.InsertionSort;
import sorting_algorithms.HillarySort;
import sorting_algorithms.Sort;
import sorting_algorithms.BernieSort;
import sorting_algorithms.TrumpSort;
import sorting_algorithms.RadixSort;
import sorting_algorithms.BucketSort;
import sorting_algorithms.CountingSort;
import java.time.Instant;
import java.util.Arrays;
import static sorting_algorithms.Sort.allBlocks;

/**
 *
 * @author Aashish Bharadwaj
 */
public class Fork implements Runnable{
    
    String fork;
    Comparable[] array;
    
    public Fork(String fork, Comparable[] array){
        this.fork = fork;
        this.array = array;
        Sort.startTime = Instant.now();
    }
    
    @Override
    public void run(){
        if(this.array.length <= 1){
            allBlocks.offer(this.array);
            return;
        }
        
        if(fork.equals("selectionSort")){            
            array = SelectionSort.selectionSort(this.array);
        }
        if(fork.equals("bubbleSort")){
            array = BubbleSort.bubbleSort(this.array);
        }
        if(fork.equals("insertionSort")){
            array = InsertionSort.insertionSort(this.array);
        }
        if(fork.equals("quickSort")){
            array = QuickSort.quickSort(this.array);
        }
        if(fork.equals("mergeSort")){
            array = MergeSort.mergeSort(this.array);
        }
        if(fork.equals("randomSort")){
            array = RandomSort.randomSort(this.array);
        }
        if(fork.equals("guessAndCheck")){
//            array = RandomSort.guessAndCheck(this.array);
        }
        if(fork.equals("javaSort")){
            Arrays.sort(this.array);
        }
        if(fork.equals("trumpSort")){
            this.array = TrumpSort.makeSortingGreatAgain(this.array);
        }
        if(fork.equals("bernieSort")){
            this.array = BernieSort.spreadTheWealth(this.array);
        }
        if(fork.equals("hillarySort")){
            this.array = HillarySort.lieToEveryone(this.array);
        }
        if(fork.equals("radixSort")) {
            this.array = RadixSort.radixSort(this.array);
        }
        if(fork.equals("bucketSort")) {
            this.array = BucketSort.bucketSort(this.array);
        }
        if(fork.equals("countingSort")) {
            this.array = CountingSort.countingSort(this.array);
        }
        
        //System.out.println("Offer: " + Arrays.toString(array));
        try{
            allBlocks.offer(array);
        }catch(StackOverflowError e){
            System.out.println("Too many values were attempted to be sorted, and there was a stack overflow.");
        }catch(NullPointerException e){
            if(Sort.sortingMethod.equals("hillarySort")){
                return;
            }else{
                System.out.println("Null pointer. Apologies.");
            }
        }
    }
}
