package com.company;

import com.sun.istack.internal.NotNull;

import java.util.function.BiFunction;

public class SegmentTree<T> {

    private final int N;
    private final T[] array;
    private final BiFunction<T, T, T> biFunction;
    private final int NODE_START;
    private final int SEARCH_LEFT;
    private final int SEARCH_RIGHT;
    private final T defaultObject;
    private final IncorrectLengthException INCORRECT_LENGTH_EXCEPTION =
            new IncorrectLengthException("Length of segment tree is incorrect");

    SegmentTree(@NotNull T[] array,@NotNull BiFunction<T, T, T> biFunction,@NotNull T defaultObject) {
        this.array = array;
        N = array.length;
        SEARCH_LEFT = 0;
        SEARCH_RIGHT = N - 1;
        NODE_START = 1;
        this.biFunction = biFunction;
        this.defaultObject = defaultObject;
    }

    public void buildTree(@NotNull T[] tree) throws IncorrectLengthException {
        if (checkLengthOfTree(tree))
            build(array, tree, SEARCH_LEFT, SEARCH_RIGHT, NODE_START, biFunction);
    }

    private void build(T[] array, T[] tree, int start, int end, int node, BiFunction<T, T, T> biFunction) {
        if (start == end) {
            tree[node] = array[start];
        } else {
            int mid = (start + end) / 2;
            build(array, tree, start, mid, 2 * node, biFunction);
            build(array, tree, mid + 1, end, 2 * node + 1, biFunction);
            tree[node] = biFunction.apply(tree[2 * node], tree[2 * node + 1]);
        }
    }

    private boolean checkLengthOfTree(T[] tree) throws IncorrectLengthException {
        if (tree.length == getTreeSize())
            return true;
        throw INCORRECT_LENGTH_EXCEPTION;
    }

    public void update(int inx,@NotNull T value,@NotNull T[] tree) throws IncorrectLengthException {
        if (checkLengthOfTree(tree))
            updateTree(inx, SEARCH_LEFT, SEARCH_RIGHT, tree, value, NODE_START);
    }

    private void updateTree(int indx, int start, int end, T[] tree, T value, int node) {
        if (start == end && start == indx) {
            tree[node] = value;
        } else if (indx >= start && indx <= end) {
            tree[node] = biFunction.apply(tree[node], value);
            int mid = (start + end) / 2;
            updateTree(indx, start, mid, tree, value, 2 * node);
            updateTree(indx, mid + 1, end, tree, value, 2 * node + 1);
        }
    }

    public T query(int l, int r,@NotNull T[] tree) throws IncorrectLengthException {
        if (checkLengthOfTree(tree))
            return queryTree(l, r, SEARCH_LEFT, SEARCH_RIGHT, tree, NODE_START);
        return null;
    }

    private T queryTree(int l, int r, int start, int end, T[] tree, int node) {
        if (r < start || l > end)
            return defaultObject;
        if (l <= start && end <= r)
            return tree[node];
        else {
            int mid = (start + end) / 2;
            T p1 = queryTree(l, r, start, mid, tree, 2 * node);
            T p2 = queryTree(l, r, mid + 1, end, tree, 2 * node + 1);
            return biFunction.apply(p1, p2);
        }
    }

    public int getTreeSize() {
        return 2 * N;
    }

    final static class IncorrectLengthException extends Exception{
        IncorrectLengthException(String message){
            super(message);
        }
    }
}


