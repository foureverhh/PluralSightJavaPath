package search.linear_search;

import java.util.Arrays;

public class TestSearch1 {
    public static void main(String[] args) {
        //给定分数数组
        int[] scoreArr = {89,45,78,45,100,98,86,100,65};
        //给定要查找的分数
        int target = 100;
        //完成查找

/*        //输出结果
        //Sequential sort
        System.out.println(sequentialSearch(scoreArr,100) == -1 ?"No result" : "target score index: " + sequentialSearch(scoreArr,target));*/
        //Binary sort
        //System.out.println(binarySearch(scoreArr,100) == -1 ?"No result" : "target score index: " + sequentialSearch(scoreArr,target));
        int[] array = bubbleSort(scoreArr);
        System.out.println(binarySearchRecursion(scoreArr,0,array.length-1,100) == -1 ?"No result" : "target score index: " + sequentialSearch(scoreArr,target));
    }

    public static int[] bubbleSort(int[] input){
        int temp = 0;
        for (int i = 0; i < input.length -1 ; i++) {
            for (int j = 0; j < input.length -i -1; j++) {
                if(input[j] > input[j+1]){
                    temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        return input;
    }

    public static int sequentialSearch(int[] input,int target){

        int index = -1;
        for (int i = 0; i < input.length ; i++) {
            if(input[i] == target ){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int binarySearch(int[] input, int target){
        int[] array = bubbleSort(input);
        System.out.println(Arrays.toString(array));
        int low = 0;
        int high = input.length -1;
        int mid = (low + high) / 2;
        while (low <= high){
            if(target == array[mid]) {
                return mid;
            }
            if(array[mid] > target){
                high = mid - 1;
            }
            if(array[mid] < target){
                low = mid + 1;
            }
            mid = (low + high)/2;
        }
        return -1;
    }

    public static int binarySearchRecursion(int[] input,int low,int high, int target){
        if(low<=high){
            int mid = (low + high) / 2;
            if(input[mid] == target ) {
                return mid;
            }
            if(input[mid] > target){
                return binarySearchRecursion(input,low,mid-1,target);
            }else {//if(input[mid] < target){
                return binarySearchRecursion(input,mid+1,high,target);
            }
        }
        return -1;
    }
}
