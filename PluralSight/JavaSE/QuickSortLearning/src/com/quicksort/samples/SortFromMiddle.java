package com.quicksort.samples;

//https://www.programcreek.com/2012/11/quicksort-array-in-java/

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
            quickSortFromMiddle(array,start,j);
        }
        if(end > i){
            quickSortFromMiddle(array,i,end);
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }
}
