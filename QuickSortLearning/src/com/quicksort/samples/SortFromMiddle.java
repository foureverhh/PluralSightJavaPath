package com.quicksort.samples;

public class SortFromMiddle {


    public void quickSortFromMiddle(int[] array, int start, int end){

        if(array == null || array.length == 0)
            return;
        if(start >= end)
            return;
        int pivot = array[start + (end - start) / 2];
        int i = start, j = end;
        while(i <= j){
            while(array[i] < pivot){
                i++;
            }
            while(array[j] > pivot){
                j--;
            }
            if(i<=j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if(start<j){
            quickSortFromMiddle(array,start,j-1);
        }
        if(end > i){
            quickSortFromMiddle(array,i+1,end);
        }
    }
}
