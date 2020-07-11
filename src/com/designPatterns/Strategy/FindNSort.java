package com.designPatterns.Strategy;

public abstract class FindNSort<T extends Comparable<T>>{
    protected final FindingStrategy<T> findingStrategy;
    protected final SortingStrategy<T> sortingStrategy;

    public FindNSort(FindingStrategy<T> findingStrategy, SortingStrategy<T> sortingStrategy) {
        this.findingStrategy = findingStrategy;
        this.sortingStrategy = sortingStrategy;
    }
}
