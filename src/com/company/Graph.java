package com.company;

import java.util.*;
import java.util.Stack;
import java.util.Queue;
import java.util.stream.IntStream;

public class Graph {
    static boolean[] visitedArray;

    public static void main(String[] args) throws Exception {
        ArrayList[] graph = new ArrayList[6];
        IntStream.range(0, 6).forEach(i -> graph[i] = new ArrayList<Integer>());
        visitedArray = new boolean[6];
        Arrays.fill(visitedArray, false);
        graph[5].add(2);
        graph[5].add(0);
        graph[4].add(0);
        graph[4].add(1);
        graph[2].add(3);
        graph[3].add(1);
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < 6; i++) {
            if (!visitedArray[i]) {
                visitedArray[i] = true;
                topoSort(graph, result, i);
            }
        }
        ListIterator<? extends Integer> listIterator = result.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        // to print in reverse order
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
        Arrays.fill(visitedArray, false);
        for (int i = 0; i < 6; i++) {
            if (!visitedArray[i]) {
                visitedArray[i] = true;
                DFS(graph, i);
            }
        }
        System.out.println();
        Arrays.fill(visitedArray, false);
        for (int i = 5; i >= 0; i--) {
            if (!visitedArray[i]) {
                visitedArray[i] = true;
                BFS(graph, new PriorityQueue<>(Collections.singletonList(i)));
            }
        }

    }

    static void topoSort(List<Integer>[] graph, Stack<Integer> stack, int currentNode) {
        for (int adjNode :
                graph[currentNode]) {
            if (!visitedArray[adjNode]) {
                visitedArray[adjNode] = true;
                topoSort(graph, stack, adjNode);
            }
        }
        stack.push(currentNode);
    }

    static void DFS(List<Integer>[] graph, int currentNode) {
        System.out.print(currentNode + " ");
        for (int adjNode : graph[currentNode]) {
            if (!visitedArray[adjNode]) {
                visitedArray[adjNode] = true;
                DFS(graph, adjNode);
            }
        }
    }

    static void BFS(List<Integer>[] graph, Queue<Integer> queue) throws Exception {
        while (!queue.isEmpty()) {
            System.out.print(queue.peek() + " ");
            for (int adjNode : graph[queue.poll()]) {
                if (!visitedArray[adjNode]) {
                    visitedArray[adjNode] = true;
                    queue.add(adjNode);
                }
            }
        }

    }
}
