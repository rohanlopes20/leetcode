package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
    private Map<Integer, Integer> cache;
    LinkedList<Integer> queue;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        queue = new LinkedList<>();
    }
    
    public int get(int key) {
        if(queue.contains(key)) {
            queue.remove(queue.indexOf(key));
            queue.addFirst(key);
        }
        if(cache.containsKey(key)) return cache.get(key);
        return -1;
    }
    
    public void put(int key, int value) {
        if(queue.contains(key)) {
            queue.remove(queue.indexOf(key));
        }

        if(queue.size() >= capacity) {
            int val = queue.removeLast();
            cache.remove(val);
        }

        queue.addFirst(key);
        cache.put(key, value);
    }

    public static void main(String[] args) {
        /*LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(assertValue(lruCache.get(1), 1));
        lruCache.put(3,3);
        System.out.println(assertValue(lruCache.get(2), -1));
        lruCache.put(4,4);
        System.out.println(assertValue(lruCache.get(1),-1));
        System.out.println(assertValue(lruCache.get(3),3));
        System.out.println(assertValue(lruCache.get(4),4));*/

        //["LRUCache","put","put","put","put","get","get"]
        //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(assertValue(lruCache.get(1),-1));
        System.out.println(assertValue(lruCache.get(2),-1));
    }

    private static Integer assertValue(int a, int b) {
        if(a != b) return null; return a;
    }
}