package com.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class Rocks {
    public static void main(String[] args) {
//        capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
//        System.out.println(new Rocks().maximumBags(new int[]{2,3,4,5},new int[]{1,2,4,4},2));
//        [10,2,2], rocks = [2,2,0], additionalRocks = 100
//        System.out.println(new Rocks().maximumBags(new int[]{10,2,2},new int[]{2,2,0},100));
//        System.out.println(new Rocks().maximumBags(new int[]{1000000000},new int[]{0},1000000000));
//        [1000000000] [0] 1000000000
//        System.out.println(new Rocks().detectCapitalUse("USA"));
//        System.out.println(new Rocks().detectCapitalUse("FLaG"));
//        System.out.println(new Rocks().detectCapitalUse("ffffF"));
//        System.out.println(new Rocks().minDeletionSize(new String[]{"cba","daf","ghi"}));
//        System.out.println(new Rocks().minDeletionSize(new String[]{"rrjk","furt","guzm"}));
        System.out.println(new Rocks().findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(new Rocks().isPrime(7));
        System.out.println(new Rocks().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));

        List<String> stringList = new ArrayList<>();
        stringList.add("123123");
        stringList.add("12313");
        stringList.add("12123");

        Iterator<String> strings = stringList.iterator();

        while (strings.hasNext()) {
            String s = strings.next();
            strings.remove();
            System.out.println(stringList.isEmpty());
        }

    }

    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < operations.length; i++) {
            System.out.println(stack);
            if("+".equals(operations[i])) {
                int num1 = stack.pop();
                int num2 = stack.pop();

                stack.push(num2);
                stack.push(num1);
                stack.push(num1 + num2);
            } else if("D".equals(operations[i])) {
                int num1 = stack.pop();

                stack.push(num1);
                stack.push(num1 * 2);
            } else if("C".equals(operations[i])) {
                if(!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(Integer.valueOf(operations[i]));
            }

        }

        int sum = 0;

        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    private boolean isPrime(int num) {
        return num > 1 && IntStream.rangeClosed(2, (int)Math.sqrt(num)).noneMatch(divisor -> divisor % num == 0);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        System.out.println(points);

        return 0;
    }

    public int minDeletionSize(String[] strs) {
        int count = 0;

        if(strs.length == 0) {
            return count;
        }

        int columnLength = strs[0].length();

        for(int i = 0; i < columnLength; i++) {
            int currentColumn = i;
            int prev = 0;

            for(int j = 0; j < strs.length; j++) {
                if(prev <=  strs[j].charAt(currentColumn)) {
                    prev = strs[j].charAt(currentColumn);
                    continue;
                }
                count++;
                break;
            }

        }

        return count;
    }

    public boolean detectCapitalUse(String word) {
//        All letters in this word are capitals, like "USA".
//                All letters in this word are not capitals, like "leetcode".
//                Only the first letter in this word is capital, like "Google".
        boolean isFirstLetterUpper = false;
        int allLettersUpperCount  = 0;
        int allLetterLowerCount  = 0;

        for(int i = 0; i < word.length(); i++) {
            if(i == 0 && Character.isUpperCase(word.charAt(i))) {
                isFirstLetterUpper = true;
            }
            if (Character.isUpperCase(word.charAt(i))) {
                allLettersUpperCount++;
            } else {
                allLetterLowerCount++;
            }
        }

        if(allLettersUpperCount == word.length() || allLetterLowerCount == word.length()) {
            return true;
        }

        if(isFirstLetterUpper && allLettersUpperCount == 1) {
            return true;
        }

        return false;
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int fullCounter = 0;
        int[] remaining = new int[capacity.length];

        for(int i = 0; i < remaining.length; i++) {
            remaining[i] = capacity[i] -  rocks[i];
        }

        Arrays.sort(remaining);

        for(int i = 0; i < remaining.length; i++) {
            while (additionalRocks != 0 && remaining[i] != 0) {
                if(remaining[i] <= additionalRocks) {
                    additionalRocks = additionalRocks - remaining[i];
                    remaining[i] = 0;
                } else {
                    remaining[i] -= 1;
                    additionalRocks --;
                }
            }

            if(remaining[i] == 0) {
                fullCounter++;
            }
        }

        return fullCounter;
    }
}
