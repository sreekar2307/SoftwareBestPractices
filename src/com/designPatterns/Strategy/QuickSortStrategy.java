package com.designPatterns.Strategy;

import java.util.Collections;
import java.util.List;

public class QuickSortStrategy<T extends Comparable<T>> implements SortingStrategy<T> {
    @Override
    public void sort(List<T> list) {
        Collections.sort(list);
    }
}
