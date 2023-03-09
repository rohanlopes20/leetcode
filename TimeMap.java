package com.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    private Map<String, List<Pair<String, Integer>>> map;
        
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            map.get(key).add(new Pair<String, Integer>(value, timestamp));
        } else {
            map.put(key, new ArrayList<>());
            map.get(key).add(new Pair<String, Integer>(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        String value = "";

        if(map.containsKey(key)) {
            List<Pair<String, Integer>> pairs = map.get(key);
            int low = 0, high = pairs.size() - 1;
            int mid = high;

            while (low <= high) {
                mid = (low + high) / 2;

                if(pairs.get(mid).getValue() == timestamp) {
                    return pairs.get(mid).getKey();
                }

                if(pairs.get(mid).getValue() <= timestamp) {
                    value = pairs.get(mid).getKey();
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return value;
    }

    public static void main(String[] args) {
//        ["TimeMap", "set", "get", "get", "set", "get", "get"]
//[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        timeMap.get("foo", 1);
        timeMap.get("foo", 3);
        timeMap.set("foo", "bar2", 4);
        timeMap.get("foo", 4);
        timeMap.get("foo", 5);

    }
}