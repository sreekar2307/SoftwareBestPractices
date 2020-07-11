package com.designPatterns.Strategy;

import java.util.List;

public class BubbleSortStrategy<T extends Comparable<T>> implements SortingStrategy<T>{

    @Override
    public void sort(List<T> list) {
        for (int i = 0; i <list.size(); i++) {
            for (int j = 0; j <list.size()-1; j++) {
                if(list.get(j).compareTo(list.get(j+1))>0){
                    T temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
    }
}
