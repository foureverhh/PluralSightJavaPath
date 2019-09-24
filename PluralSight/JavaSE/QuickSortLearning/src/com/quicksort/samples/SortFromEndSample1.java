package com.quicksort.samples;

public class SortFromEndSample1 {

    private int[] array;

    public SortFromEndSample1(int[] array) {
        this.array = array;
    }

    private int partition(int[] array, int startIndex, int endIndex){
        int pivot = array[endIndex];
        for(int i = startIndex; i < endIndex; i++){
            if(array[i] < pivot){
                int temp = array[i];
                array[i] = array[startIndex];
                array[startIndex] = temp;
                startIndex++;
            }
        }
        int temp = array[endIndex];
        array[endIndex] = array[startIndex];
        array[startIndex] = temp;
        return startIndex;
    }

    public void quickSort(int[] array, int startIndex, int endIndex){
        if(startIndex < endIndex){
            int pi = partition(array,startIndex,endIndex);
            //check left part
            quickSort(array,startIndex,pi-1);
            //check right part
            quickSort(array,pi+1, endIndex);
        }
    }
}


