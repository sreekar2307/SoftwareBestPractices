package com.company;

import java.util.*;

public class LruCache<K, V> {
    private Node<K, V> first;
    private Node<K, V> last;
    private final Map<K, Node<K, V>> map;
    private int currentSize;
    private final int capacity;
    public LruCache(int capacity) {
        this.first = null;
        this.map = new HashMap<>();
        currentSize = 0;
        this.capacity = capacity;
    }

    public static void main(String[] args) throws Exception {
        LruCache<String,String>  lruCache = new LruCache<>(100);
        lruCache.set("U101116FCS020","Sreekar");
        lruCache.set("U101116FCS019","Reddy");
        lruCache.set("U101116FCS021","Vipul");
        lruCache.set("U101116FCS022","Shravya");
    }
    
    public void set(K key, V value) throws Exception {
        if (!map.containsKey(key)) {
            Node<K,V> node = new Node<>(key,value);
            addAtFirst(node);
        } else if (map.containsKey(key)) {
            throw new Exception("Key already present");
        }
    }

    public V get(K key) throws Exception {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            remove(node);
            addAtFirst(node);
            return node.value;
        }
        throw new Exception("Key not found");
    }

    // this is generic enough to remove any node irrespective of its placement
    public void remove(Node<K, V> node) {
        if (node.prev != null)
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        else { // this means we are removing last node so update the last pointer
            last = node.prev;
        }
        map.remove(node.key);
        currentSize--;
    }

    public boolean isCapacityFull() {
        return this.currentSize >= this.capacity;
    }


    public void addAtFirst(Node<K, V> node) {
        if (isCapacityFull()){
            remove(last);
        }
        node.next = first;
        node.prev = null;
        if(first!=null)
            first.prev = node;
        else
            last = node;
        first = node;
        map.put(node.key, first);
        currentSize++;
    }


    private static class Node<K, V> {
        K key;
        Node<K,V> next;
        Node<K,V> prev;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public List<V> getContents() {
        List<V> list = new LinkedList<>();
        getLruContents(first, list);
        return list;
    }

    private void getLruContents(Node<K, V> node, List<V> list) {
        if (node != null) {
            list.add(node.value);
            getLruContents(node.next, list);
        }
    }

}
