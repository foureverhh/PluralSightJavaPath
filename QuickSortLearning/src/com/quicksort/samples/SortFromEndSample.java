package com.quicksort.samples;//https://www.geeksforgeeks.org/quick-sort/

public class SortFromEndSample {
    private int[] array;

    public SortFromEndSample(int[] array) {
        this.array = array;
    }

    private int partition(int[] array, int startIndex, int endIndex){
        int partitionIndex = startIndex - 1;
        int pivot = array[endIndex];
        for(int i = startIndex; i < endIndex; i++){
            if(array[i] < pivot){
                partitionIndex++;
                int temp = array[i];
                array[i] = array[partitionIndex];
                array[partitionIndex] = temp;
            }
        }
        int temp = array[partitionIndex + 1];
        array[partitionIndex+1] = array[endIndex];
        array[endIndex] =  temp;
        return partitionIndex+1;
    }

    public void quickSort(int[] array, int startIndex, int endIndex){
        if(startIndex<endIndex){
           int pi =  partition(array,startIndex,endIndex);
           quickSort(array,startIndex,pi-1);
           quickSort(array,pi+1,endIndex);
        }
    }
}
