package com.designPatterns.Strategy;

import java.util.Collections;
import java.util.List;

public class BinarySearchFindStrategy<T extends Comparable<T>> implements FindingStrategy<T> {

    @Override
    public int find(T element, List<T> list) {
        int position = Collections.binarySearch(list,element);
        return position>=0?position:-1;
    }
}
