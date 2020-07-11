package com.designPatterns.Strategy;

import java.util.List;

public class IterativeFindStrategy<T extends Comparable<T>> implements FindingStrategy<T> {

    @Override
    public int find(T element, List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(element)==0)
                return i;
        }
        return -1;
    }
}
