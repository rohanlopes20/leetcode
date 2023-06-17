package com.leetcode;

import javafx.util.Pair;

import java.util.*;

public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
//        System.out.println(stringToInteger.parseInt("1234567"));
//        System.out.println(stringToInteger.maxVowels("leetecode", 4));
        System.out.println(Arrays.toString(stringToInteger.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];

        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums) {
            if(countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        List<Pair<Integer, Integer>> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> keyval : countMap.entrySet()) {
            list.add(new Pair<>(keyval.getKey(), keyval.getValue()));
        }

        System.out.println(countMap);

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        int count = 0;

        for (Pair<Integer, Integer> pair : list) {
            queue.add(pair);
        }

        count = 0;
        while (count < k) {
            arr[count]= queue.poll().getKey();
            count++;
        }

        return arr;
    }

    public int maxVowelsV2(String s, int k) {
        int count = 0;
        int i = 0;
        int j = i + k - 1;

        while(j < s.length()) {
            int newCount = countVowels(s, i, j);
            count = Math.max(count, newCount);
            i++;
            j++;
        }
        return count;
    }

    public int maxVowels(String s, int k) {
        int ans = 0;
        int count = 0;

        for(int i = 0; i < s.length(); i ++) {
            if(i >= k && isVowel(s.charAt(i-k))) {
                count -=1;
            }

            if(isVowel(s.charAt(i))) {
                count +=1;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private Map<String, Integer> cache = new HashMap<>();
    private int countVowels(String str, int start, int end) {
        int vowels = 0;

        if(cache.containsKey(str.substring(start, end + 1))) {
            return cache.get(str.substring(start, end + 1));
        }

        for(int i = start; i <= end; i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                vowels++;
            }
        }
        cache.put(str.substring(start, end + 1), vowels);
        return vowels;
    }

    private int parseInt(String str) {
        int num = 0;
        int i = 0;

        while(i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            num = num*10 + digit;
            i++;
        }

        return num;
    }
}
