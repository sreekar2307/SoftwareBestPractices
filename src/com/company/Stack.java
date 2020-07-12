package com.company;

import java.util.ArrayList;
import java.util.List;

public class Stack<T>{
    private final List<T> elements;
    private int topIndex;
    private static final Exception STACK_EMPTY = new Exception("Stack Empty");

    public Stack() {
        elements = new ArrayList<T>();
        topIndex = -1;
    }

    public synchronized void push(T element) {
        elements.add(element);
        ++topIndex;
    }

    public synchronized T pop() throws Exception {
        if (elements.size() == 0) {
            throw STACK_EMPTY;
        }
        return elements.remove(topIndex--);
    }

    public T peek() throws Exception {
        if (elements.size() == 0)
            throw STACK_EMPTY;
        return elements.get(topIndex);
    }
}
