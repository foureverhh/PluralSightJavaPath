package com.quicksort.practice;

import com.quicksort.samples.SortFromEndSample;
import com.quicksort.samples.SortFromEndSample1;
import com.quicksort.samples.SortFromMiddle;
import com.quicksort.samples.SortFromStart;

public class Main {



    public static void main(String[] args) {
        int[] array = {80,100,20,50,10};
        int endIndex = array.length-1;
        SortFromEndSample sample = new SortFromEndSample(array);
        //sample.quickSort(array,0,endIndex);

        SortFromEndSample1 sample1 = new SortFromEndSample1(array);
        //sample1.quickSort(array,0,endIndex);

        SortFromStart sampleFromStart = new SortFromStart(array);
        //sampleFromStart.quickSortFromStart(array,0,endIndex);
        //quickSort(array,0,endIndex-1);
        SortFromMiddle sortFromMiddle  = new SortFromMiddle();
        sortFromMiddle.quickSortFromMiddle(array,0,endIndex);
        printArray(array);
    }

    private static int partition(int[] array, int startIndex,int endIndex){
        int sortIndex = startIndex -1;
        int pivot = array[endIndex];
        for(int index = startIndex; index < endIndex; index++){
            //if an element is smaller than or equals pivot, swap(sort) it with the first bigger one
            if(array[index] <= pivot){
                sortIndex++;
                //swap bigger element with current index element
                int temp = array[index];
                array[index] = array[sortIndex];
                array[sortIndex] = temp;
            }
        }
        //swap the current sortIndex value with the endIndex value
        int temp = array[endIndex];
        array[endIndex] = array[sortIndex+1];
        array[sortIndex+1] = temp;
        return sortIndex+1;
    }

    private static void quickSort(int[] array, int startIndex,int endIndex){

        if(startIndex < endIndex){
            int pi = partition(array,startIndex,endIndex);
            quickSort(array,startIndex,pi-1);
            quickSort(array,pi+1,endIndex);
        }
    }

    private static void printArray(int[] array){
        for(int number : array){
            System.out.print(number + " ");
        }
    }
}
