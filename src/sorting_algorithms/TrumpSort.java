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
public class TrumpSort extends Sort{

    //This is all satire, please take this in good humor.

    static public int immigrants = 0;

    public static Comparable[] makeSortingGreatAgain(Comparable[] array){
        int wall = 0;

        for(int i = 0; i < array.length; i++){
            try{
                if(array[wall].compareTo(array[i]) > 0){
                    array = deport(i, array);
                    i--;
                }else if(array[wall].compareTo(array[i]) < 0){
                    wall = i;
                }
            }catch(Exception e){}
        }

//        System.out.println("Here it is:\n" + Arrays.toString(array));

        return array;
    }

    public static Comparable[] deport(int illegal, Comparable[] array) {
        Comparable[] newArray = new Comparable[array.length - 1];
        immigrants++;

        for(int i = 0, j = 0; i < array.length; i++){
            if(i == illegal){
                i++;
            }

            try{
                newArray[j] = array[i];
            }catch(Exception e){}
            j++;
        }

        return newArray;
    }

}