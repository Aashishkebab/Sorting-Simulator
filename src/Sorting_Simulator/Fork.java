/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting_Simulator;

import sorting_algorithms.*;

import java.time.Instant;
import java.util.Arrays;

import static sorting_algorithms.Sort.allBlocks;


/**
 * @author Aashish Bharadwaj
 */
public class Fork implements Runnable{

	String fork;
	int[] array;

	public Fork(String fork, int[] array){
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

		if(fork.equals("slowSort")){
			SlowSort.slowSort(this.array);
		}
		if(fork.equals("cycleSort")){
			CycleSort.cycleSort(this.array);
		}
		if(fork.equals("stoogeSort")){
			StoogeSort.stoogeSort(this.array);
		}
		if(fork.equals("selectionSort")){
			SelectionSort.selectionSort(this.array);
		}
		if(fork.equals("heapSort")){
			HeapSort.heapSort(this.array);
		}
		if(fork.equals("bubbleSort")){
			BubbleSort.bubbleSort(this.array);
		}
		if(fork.equals("cocktailSort")){
			CocktailSort.cocktailSort(this.array);
		}
		if(fork.equals("oddEvenSort")){
			OddEvenSort.oddEvenSort(this.array);
		}
		if(fork.equals("combSort")){
			CombSort.combSort(this.array);
		}
		if(fork.equals("insertionSort")){
			InsertionSort.insertionSort(this.array);
		}
		if(fork.equals("shellSort")){
			ShellSort.shellSort(this.array);
		}
		if(fork.equals("quickSort")){
			QuickSort.quickSort(this.array);
		}
		if(fork.equals("mergeSort")){
			this.array = MergeSort.mergeSort(this.array);
		}
		if(fork.equals("timSort")){
			TimSort.timSort(this.array);
		}
		if(fork.equals("randomSort")){
			RandomSort.randomSort(this.array);
		}
		if(fork.equals("gravitySort")){
			this.array = GravitySort.gravitySort(this.array);
		}
		if(fork.equals("javaSort")){
			Arrays.sort(this.array);
		}
		if(fork.equals("trumpSort")){
			this.array = TrumpSort.makeSortingGreatAgain(this.array);
		}
		if(fork.equals("bernieSort")){
			BernieSort.spreadTheWealth(this.array);
		}
		if(fork.equals("hillarySort")){
			HillarySort.lieToEveryone(this.array);
		}
		if(fork.equals("radixSort")){
			RadixSort.radixSort(this.array);
		}
		if(fork.equals("bucketSort")){
			BucketSort.bucketSort(this.array);
		}
		if(fork.equals("countingSort")){
			CountingSort.countingSort(this.array);
		}
		if(fork.equals("pigeonSort")){
			PigeonholeSort.pigeonholeSort(this.array);
		}
		if(fork.equals("aashishSort1")){
			AashishSort1.aashishSort1(this.array);
		}
		if(fork.equals("aashishSort2")){
			this.array = AashishSort2.aashishSort2(this.array);
		}
		if(fork.equals("aashishSort5")){
			this.array = AashishSort5.aashishSort5(this.array);
		}
		if(fork.equals("aashishSort4")){
			AashishSort4.aashishSort4(this.array);
		}

		//System.out.println("Offer: " + Arrays.toString(array));
		try{
			allBlocks.offer(array);
		}catch(StackOverflowError e){
			System.out.println(
					"Too many values were attempted to be sorted, and there was a stack overflow.");
		}catch(NullPointerException e){
			if(Sort.sortingMethod.equals("hillarySort")){
				return;
			}else{
				System.out.println("Null pointer. Apologies.");
			}
		}
	}
}
