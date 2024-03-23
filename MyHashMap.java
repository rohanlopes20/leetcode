package com.leetcode;

import javafx.util.Pair;

import java.util.Iterator;
import java.util.LinkedList;

class MyHashMap {
    int BUCKET_SIZE;

    LinkedList<Pair<Integer, Integer>>[] list;

    public MyHashMap() {
        BUCKET_SIZE = 16;
        list = new LinkedList[BUCKET_SIZE];
    }
    
    public void put(int key, int value) {
        int bucket = key%BUCKET_SIZE;
        LinkedList<Pair<Integer, Integer>> currentList = list[bucket];

        if(currentList != null) {
            LinkedList<Pair<Integer, Integer>> tmp = currentList;
            boolean existing = false;

            for (int i =0; i < tmp.size(); i++) {
                Pair<Integer, Integer> pair = tmp.get(i);

                if (pair.getKey() == key) {
                    tmp.set(i, new Pair<>(key, value));
                    existing = true;
                    break;
                }
            }

            if(!existing) {
                tmp.add(new Pair<>(key, value));
            }
        } else {
            LinkedList<Pair<Integer, Integer>> integers = new LinkedList<>();
            Pair<Integer, Integer> pair = new Pair<>(key, value);
            integers.add(pair);
            list[bucket] = integers;
        }
    }
    
    public int get(int key) {
        int bucket = key%BUCKET_SIZE;
        LinkedList<Pair<Integer, Integer>> currentList = list[bucket];

        if(currentList != null) {
            for (int i = 0; i < currentList.size(); i++) {
                Pair<Integer, Integer> pair = currentList.get(i);

                if (pair.getKey() == key) {
                    return pair.getValue();
                }
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int bucket = key%BUCKET_SIZE;
        LinkedList<Pair<Integer, Integer>> currentList = list[bucket];

        if(currentList != null) {
            for (Iterator<Pair<Integer, Integer>> it = currentList.iterator(); it.hasNext(); ) {
                Pair<Integer, Integer> pair = it.next();

                if(pair.getKey() == key) {
                    it.remove();
                    break;
                }
            }
        }
    }
}