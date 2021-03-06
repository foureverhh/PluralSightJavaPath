package com.quicksort.samples;

public class SortFromStart {
    private int[] array;

    public SortFromStart(int[] array) {
        this.array = array;
    }

    private int partition(int[] array, int start, int end){
        int pivot = array[start];
        for(int j = end;j > start; j--){
            if(array[j] > pivot){
                int temp = array[j];
                array[j] = array[end];
                array[end] = temp;
                end--;
            }
        }
        int temp = array[end];
        array[end] = array[start];
        array[start] = temp;
        return end;
    }

    public void quickSortFromStart(int[] array, int start, int end){

            int partition = partition(array,start,end);
            if(partition -1 > start)
                quickSortFromStart(array,start,partition-1);
            if(partition +1 < end)
                quickSortFromStart(array,partition+1,end);

    }
}
