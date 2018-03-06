/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import Sorting_Methods.Fork;
import Sorting_Methods.SortingSimulator;
import static Sorting_Methods.SortingSimulator.alert;
import static Sorting_Methods.SortingSimulator.truncate;
import static sorting_algorithms.TrumpSort.immigrants;

/**
 *
 * @author Aashish Bharadwaj
 */
public class Sort{
    public static String sortingMethod = "javaSort";
    public static String inputMethod = "randomOrder";
    
    public static Instant startTime;
    
    public static Queue allBlocks;
    
    public static void swapTwoValues(int valueOne, int valueTwo, Comparable[] array){
        try{
            Comparable temp = array[valueOne];
            array[valueOne] = array[valueTwo];
            array[valueTwo] = temp;
        }catch(Exception e){}
    }
    
    public static Integer[] incrementArray(int size) {
        Integer[] array = new Integer[size];
        
        for(int i = 0; i < size; i++){
            array[i] = i;
        }
        
        return array;
    }
    
    public static Integer[] decrementArray(int size) {
        Integer[] array = new Integer[size];
        
        for(int i = size; i > 0; i--){
            array[(size - i)] = i;
        }
        
        return array;
    }

    public static Integer[] randomizeArray(int size) {
        Integer[] array = new Integer[size];
        
        for(int i = 0; i < size; i++){
            array[i] = (int)(Math.random() * size + 1);
        }
        
        return array;
    }

	// A utility function to get maximum value in arr[]
	public static int getMax(Comparable arr[]){
		int mx = (int)arr[0];
		for (int i = 1; i < arr.length; i++)
			if ((int)arr[i] > mx){
				mx = (int)arr[i];
			}
		return mx;
	}
    
    public static void letsSort(int size, int blocks){
        
        if(size <= 0 || blocks <= 0){
            if(size <= 0){
                alert("Invalid input", "You have entered list size " + size + ", which is wrong.", "Please enter a value greater than zero.", "WARNING", false);
            }
            if(blocks <= 0){
                alert("Invalid input", "You have entered block size " + blocks + ", which is wrong.", "Please enter a value greater than zero.", "WARNING", false);
            }
            
            return;
        }
        
//        size++;
        if((size/blocks) < 1){  //SO that the number of threads isn't zero
            blocks = size;
        }
        
        Integer[] array = createArray(size);    allBlocks = new ArrayBlockingQueue((int)(size/blocks) + 1);
        
        //System.out.println(Arrays.toString(array));
        
        startSorting(array, size, blocks);
    }

    public static Integer[] createArray(int size){
        Integer[] createdArray;
        
        switch(inputMethod){
            case "randomOrder":
                {
                    createdArray = randomizeArray(size);
                    break;
                }
            case "alreadySorted":
                {
                    createdArray = incrementArray(size);
                    break;
                }
            case "reverseOrder":
                {
                    createdArray = decrementArray(size);
                    break;
                }
            default:
              return null;  
        }
        
        System.out.println("Initial array:\n" + truncate(Arrays.toString(createdArray), 3333));
        System.out.println("");
        
        return createdArray;
    }

    private static void startSorting(Integer[] array, int size, int blockSize){
        startTime = Instant.now();
        
        if(blockSize >= size){
            Thread singleSort = new Thread(new Fork(sortingMethod, createCopy(array)));
            
            singleSort.start();
            try{
                singleSort.join();
            }catch(InterruptedException ex){}
            
        }else{
            sortByBlocks(array, size, blockSize);
            doTheMerge(array, blockSize);
        }
        
//        while(allBlocks.size() < size/blockSize){
////            //System.out.println("waiting");
////            //System.out.println(allBlocks.size());
////            //System.out.println(size/blockSize);
//        }  //There's got to be a better way...
        //Make sure the above actually works before starting the merging
        
        displayFinalResults(array);
    }
    
    private static Comparable[] createCopy(Comparable[] array){ //This creates a copy of an array to avoid modifying the original repeatedly, which doesn't work
        Comparable[] newArray = new Comparable[array.length];
        
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        
        return newArray;
    }

    private static void doTheMerge(Comparable[] array, int blockSize){
//        System.out.println("doTheMerge");
//        int blockSize = ((Comparable[])(allBlocks.peek())).length;
        
//        if(newArraySize == array.length){
//            setArray(array);
//            //System.out.println("we done " + Arrays.toString(array));
//            return;
//        }
        
//        while(newArraySize < array.length){

        while(true){
            try{
                mergeBlocks(blockSize, array);
                break;
            }catch(Exception e){
                continue;
            }
        }
        
//        while(allBlocks.size() > i/2 + 1){
//            //System.out.println(allBlocks.size());
//            //System.out.println(i - 1);
//        }
        
        
        //System.out.println(Arrays.toString((Comparable[])(allBlocks.peek())));
        
    }

    private static void setArray(Comparable[] array) {
        array = (Comparable[])allBlocks.peek();
        //System.out.println("Copy the array over");
        
        for(int i = 0; i < array.length; i++){
            array[i] = ((Comparable[])(allBlocks.peek()))[i];
        }
    }

    public static Comparable[] trimArray(Comparable[] array){
        int numOfValues = 0;
        
        for(int i = 0; i < array.length; i++){
            if(array[i] != null){
                numOfValues++;
            }
        }
        
        Comparable[] newArray = new Comparable[numOfValues];
        for(int i = 0; i < numOfValues; i++){
            newArray[i] = array[i];
        }
        
        return newArray;
    }

    public static void joinThreads(ArrayList<Thread> threads) {
        for(int i = 0; i < threads.size(); i++){
            try {
                threads.get(i).join();
            }catch(InterruptedException ex){}
        }
    }

    private static void displayFinalResults(Comparable[] array){
        long endTime = Instant.now().toEpochMilli();
        System.out.println("");
        
        if(sortingMethod.equals("trumpSort")){
            System.out.println(immigrants + " foreign items deported.");
            System.out.println("");
            immigrants = 0;
        }
        if(sortingMethod.equals("bernieSort")){
            System.out.println("The average wealth was " + truncate(Integer.toString(BernieSort.averageWealth), 3333));
            System.out.println("It has been split amongst all.");
            System.out.println("");
        }
        if(sortingMethod.equals("hillarySort")){
            System.out.println("All suspicious items have been deleted.");
            System.out.println("");
        }
        
        alert("Operation finished", "The time taken is below", (endTime - Sort.startTime.toEpochMilli()) + " milliseconds", "INFORMATION", false);

        System.out.println("Sorted array:\n" + SortingSimulator.truncate(Arrays.toString((Comparable[])(allBlocks.poll())), 3333));
        System.out.println(""); System.out.println("");
    }

    private static void sortByBlocks(Integer[] array, int size, int blockSize){
        ArrayList<Thread> sortThreads = new ArrayList<>();

        Integer[] blockArray = new Integer[blockSize];
        int threadNumber = 1;   int i;  int blockIndex = 0;

        for(i = 1; i <= array.length; i++){
            blockArray[blockIndex] = array[i - 1];
            blockIndex++;

            if(i % blockSize == 0){
                sortThreads.add(new Thread(new Fork(sortingMethod, createCopy(blockArray))));
                sortThreads.get(threadNumber - 1).start();
                
                //System.out.println("Thread: " + threadNumber);
                threadNumber++;

                blockIndex = 0;
            }
        }

        if(blockIndex < blockSize){
            sortLeftovers(array, size, blockSize, blockIndex, i);
        }
        
        joinThreads(sortThreads);
    }

    private static void sortLeftovers(Integer[] array, int size, int blockSize, int blockIndex, int arrayLength) {
        Integer[] newBlockArray = new Integer[size % blockSize];

        for(int t = (arrayLength - blockIndex) - 1; t < Integer.MAX_VALUE; t++){
            try{
                //System.out.println("value1: " + array[t]);
                //System.out.println("value2: " + t);
                //System.out.println("value3: " + (t - (i - blockIndex - 1)));     

                newBlockArray[(t - (arrayLength - blockIndex - 1))] = array[t];
            }catch(Exception e){
                Thread leftovers = new Thread(new Fork(sortingMethod, createCopy(newBlockArray)));
                leftovers.start();

                //System.out.println("Thread after: " + threadNumber);

                //System.out.println(Arrays.toString(newBlockArray));
//                    pause();

                try{
                    leftovers.join();
                }catch(InterruptedException ex){
                    System.out.println("Join exception");
                }

                break;
            }
        }
    }

    private static void mergeBlocks(int blockSize, Comparable[] array){
        int i;  int newSize;
        
        while(((Comparable[])(allBlocks.peek())).length < array.length){
            //System.out.println("size: " + allBlocks.size());

            newSize = allBlocks.size();

            try{
                ArrayList<Thread> mergingThreads = new ArrayList<>();
                
                if(blockSize <= 0){
                    return;
                }
                
                double numberOfMerges = Math.ceil(((float)newSize) / ((float)blockSize));
                
                for(i = 0; i < numberOfMerges; i++){
//                            Thread merge = new Thread(new Merger());
                    mergingThreads.add(new Thread(new Merger()));
                    mergingThreads.get(i).start();
                    
//                    System.out.println(Arrays.toString((Comparable[])(allBlocks.peek())));

//                            merge.start();
//                        merge.join();
                }
                
//                        System.out.println("Waiting for join");
                joinThreads(mergingThreads);
//                        System.out.println("Done joining");
                
                if(allBlocks.size() == 1){
                    //System.out.println("");
                    //System.out.println("break");
                    return;
                }

//                        while(true){
//                            try{
//                                while(allBlocks.size() - 1 != Math.floor(newSize / 2) && ((Comparable[])(allBlocks.peek())).length != newLength * 2){
//            //                        //System.out.println(Arrays.toString(((Comparable[])(allBlocks.peek()))));
//
//            //                        //System.out.println("");
//            //                        //System.out.println("allBlocks size: " + allBlocks.size());
//            //                        //System.out.println("Comparator: " + Math.ceil(newSize / 2));
//            //                        
//            //                        //System.out.println("");
//            //                        //System.out.println("Peek length: " + ((Comparable[])(allBlocks.peek())).length);
//            //                        //System.out.println("Comparator: " + newLength);
//                                }
//                                break;
//                            }catch(Exception e){
//                                continue;
//                            }
//                        }
            }catch(Exception pleaseWait){}
        }
    }

    public static Integer[] convertToIntegers(Comparable[] array){
        Integer[] newArray = new Integer[array.length];
        
        for(int i = 0; i < array.length; i++){
            newArray[i] = (Integer)(array[i]);
        }
        
        return newArray;
    }
    
    private static class Merger implements Runnable{
        
        public Merger(){}

        @Override
        public synchronized void run(){
            
            //System.out.println("Merge thread");
            //System.out.println("allBlocks size before: " + allBlocks.size());
            
            //System.out.println(""); //System.out.println(""); //System.out.println("");
            
//            displayTest();
                
            if(allBlocks.size() < 2){
                return;
            }
            
            try{
                allBlocks.offer(MergeSort.mergeData((Comparable[])(allBlocks.poll()), (Comparable[])(allBlocks.poll())));
            }catch(Exception foweijfeowifj){}
            
            try{
                //System.out.println("Lenghth of peek: " + ((Comparable[])(allBlocks.peek())).length);
            }catch(Exception e){}
            
            //System.out.println("allBlocks size after: " + allBlocks.size());
            //System.out.println("Finish merge thread");
            
            //System.out.println(Arrays.toString((Comparable[])(allBlocks.peek())));
        }

        public void displayTest() {
            for(int i = 0; i < Integer.MAX_VALUE; i++){
                try{
                    //System.out.println(Arrays.toString((Comparable[])(allBlocks.poll())));
                }catch(Exception e){}
            }
        }
    }
}