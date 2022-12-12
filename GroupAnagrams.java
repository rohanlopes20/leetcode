package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();


        for(String s : strs) {
            int[] chars = s.chars().sorted().toArray();
            String key = Arrays.toString(chars);

            if(map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> lis = new ArrayList<>();
                lis.add(s);
                map.put(key, lis);
            }
        }

        return map.values().stream().collect(Collectors.toList());
    }
}
