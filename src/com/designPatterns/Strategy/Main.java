package com.designPatterns.Strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * As per our need we can substitute which ever strategy is needed let's say
 * we are working on input size of less than 100 then bubble sort and iterative sort are enough
 * @param <T> should be compatable
 */
public class Main<T extends Comparable<T>> extends FindNSort<T>{


    public Main(FindingStrategy<T> findingStrategy, SortingStrategy<T> sortingStrategy) {
        super(findingStrategy, sortingStrategy);
    }

    public static void main(String[] args) {
        Main<Integer> main = new Main<Integer>(new BinarySearchFindStrategy<>(),new QuickSortStrategy<>());
        List<Integer> list = new ArrayList<>(Arrays.asList(1,3,6,5,10,7));
        main.sortingStrategy.sort(list);
        System.out.println(list);
    }

}
