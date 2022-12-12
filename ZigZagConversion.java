package com.leetcode;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class ZigZagConversion {
    public static void main(String[] args) {
//        System.out.println(new ZigZagConversion().convert("jrqopubjguxhxdipfzwswybgfylqvjzharvrlyauuzdrcnjkphclffrkeecbpdipufhidjcxjhrnxcxmjcxohqanxdrmgzebhnlmwpmhwdvthsfqueeexgrujigskmvrzgfwvrftwapdtutpbztygnsrxajjngcomikjzsdwssznovdruypcnjulkfuzmxnafamespckjcazxdrtdgyrqscczybnvqqcqcjitlvcnvbmasidzgwraatzzwpwmfbfjkncvkelhhzjchpdnlunmppnlgjznkewwuysgefonexpmmsbaopmdgzqmkqzxuvtqvnxbslqzkglzamzpdnsjolvybwxxttqognrbaiakqllszkhfzconnmoqklpeefsnsmouwqhodsgcfohesyshmgxwtoayuvnojdjftqtwkbapriujimqwspslgvlcsaqbdbgwtbseettwdnfnbyjvpdjxyuzqxstatbzpctthoofremgfkrbcvkzvgbofthgojhdnaywpnbitoraaibednezwfpdawlohssvtqtkfvsylj", 70));
//        System.out.println(new ZigZagConversion().isSubsequence("abc", "ahbgdc"));

//        System.out.println(new ZigZagConversion().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        System.out.println(new ZigZagConversion().frequencySort("loveleetcode"));
    }

    class MyComparator implements Comparator<Character> {
        private String test;

        MyComparator(String test) {
            this.test = test;
        }

        @Override
        public int compare(Character o1, Character o2) {
            long count1 = test.chars().filter(ch -> ch == o1).count();
            long count2 = test.chars().filter(ch -> ch == o2).count();
            if(count1 < count2) {
                return 1;
            } else if(count1 > count2) {
                return -1;
            }
            return 0;
        }

    }

    public String frequencySort(String s) {
        int[] charsFrequency = new int[124];

        for(int i = 0; i < s.length(); i++) {
            charsFrequency[s.charAt(i)] = charsFrequency[s.charAt(i)] + 1;
        }

        StringBuffer sb = new StringBuffer();

        PriorityQueue<Pair<Character, Integer>> queue = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(int i = charsFrequency.length - 1; i >= 0; i--) {
            if(charsFrequency[i] != 0) {
                queue.add(new Pair<>((char)i, charsFrequency[i]));
            }
        }

        while (!queue.isEmpty()) {
            Pair<Character, Integer> characterIntegerPair = queue.poll();
            System.out.println(characterIntegerPair);
            int counter = 0;

            while (counter != characterIntegerPair.getValue()) {
                sb.append(characterIntegerPair.getKey());
                counter++;
            }
        }

        return sb.reverse().toString();
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integerList = new ArrayList<>();

        return integerList;
    }

    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        StringBuffer sb = new StringBuffer();

        String[][] arrays = new String[numRows][s.length()*numRows*100];

        int startRow    = 0;
        int startColumn = 0;
        int direction   = 0;
        int index = 0;

        while(s.length() != index) {
            String current = String.valueOf(s.charAt(index));

            if(startRow == numRows) {
                direction = 1;
                startRow -= 2;
            }

            if(startRow == 0) {
                direction = 0;
                if(index >= numRows)
                    startColumn++;
            }

            if(direction == 0) {
                arrays[startRow][startColumn] = current;
                startRow++;
            } else {
                startColumn++;
                arrays[startRow][startColumn] = current;
                startRow--;
            }

            index++;
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < 10; j++) {
                if (arrays[i][j] != null) {
                    sb.append(arrays[i][j]);
                }
            }
           // System.out.println(Arrays.toString(arrays[i}));
        }

        return sb.toString();
    }

    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) {
            return false;
        }

        int sIndex = 0;
        int tIndex = 0;

        while(sIndex != s.length() && tIndex != t.length()) {
            char sc = s.charAt(sIndex);
            char tc = t.charAt(tIndex);

            if(sc == tc) {
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }

        return sIndex == s.length();
    }
}
