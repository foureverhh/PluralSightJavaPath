package com.quicksort.practice;

import com.quicksort.samples.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        int[] array = {80,100,30,50,200,210,150,30};
        int endIndex = array.length-1;
        SortFromEndSample sample = new SortFromEndSample(array);
        sample.quickSort(array,0,endIndex);
        printArray(array);
        System.out.println();
        SortFromEndSample1 sample1 = new SortFromEndSample1(array);
        //sample1.quickSort(array,0,endIndex);

        SortFromStart sampleFromStart = new SortFromStart(array);
        sampleFromStart.quickSortFromStart(array,0,endIndex);
        printArray(array);
        System.out.println();
        //quickSort(array,0,endIndex-1);
        SortFromMiddle sortFromMiddle  = new SortFromMiddle();
        //sortFromMiddle.quickSortFromMiddle(array,0,endIndex);
        sortFromMiddle.quickSort(array,0,endIndex);
        printArray(array);
        System.out.println();

        Integer[] arrayHan = new Integer[]{80,100,30,50,200,210,150,30};
        List<Integer> list = Arrays.asList(arrayHan);
        SortIdeaHan sampleHan = new SortIdeaHan();
        List<Integer> result = sampleHan.quickSort(list);
        for(Integer i: result){
            System.out.print(i+" ");
        }

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
