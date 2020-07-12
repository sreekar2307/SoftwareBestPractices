package com.company;

import java.util.ArrayList;
import java.util.List;

public class Queue<T>{
    private final List<T> elements;
    private static final Exception QUEUE_EMPTY = new Exception("Queue Empty");
    private int rear;
    public Queue(){
        elements = new ArrayList<>();
        rear = -1;
    }
    public void enQueue(T element){
        elements.add(0,element); // always adding at front
        rear++;
    }
    public T deQueue() throws Exception {
        if(rear!=-1)
          return elements.remove(rear--);
        throw QUEUE_EMPTY;
    }
    public T peek() throws Exception {
        if(rear!=-1)
            return elements.get(rear);
        throw QUEUE_EMPTY;
    }
}
