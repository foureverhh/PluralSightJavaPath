package com.quicksort.samples;

import java.util.ArrayList;
import java.util.List;

public class SortIdeaHan {
    public List<Integer> quickSort(List<Integer> list){

        if(list.size() <2)
            return list;

        int pivot = list.get(0);
        List<Integer> leftSide = new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();

        for(int i = 1; i < list.size(); i++) {

            if (list.get(i) <= pivot)
                leftSide.add(list.get(i));
            else if (list.get(i) > pivot)
                rightSide.add(list.get(i));

        }

        List<Integer> left = new ArrayList<>();
        left.addAll(quickSort(leftSide));
        left.add(pivot);
        left.addAll(quickSort(rightSide));

        return left;
    }
}
