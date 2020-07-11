package com.designPatterns.Strategy;

import java.util.List;

public interface FindingStrategy<T extends Comparable<T>> {
    int find(T element, List<T> list);
}
