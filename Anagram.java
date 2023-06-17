package com.leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {
    public static void main(String[] args) {
//        System.out.println(new Anagram().isAnagram("anagram","nagaram"));

        int bucketSize = BigDecimal.valueOf(100_000)
                .divide(BigDecimal.valueOf(10_000), 0, java.math.RoundingMode.CEILING)
                .intValue();

        System.out.println(bucketSize);

        for(int i = 0; i < bucketSize; i++) {
            System.out.println(i + 1 + " " + 100);
        }
//
//        System.out.println(new Anagram().minFlips(3040,7257,4934));

        System.out.println(new Anagram().summaryRanges(new int[] {0,1,2,4,5,7}));
        System.out.println(new Anagram().summaryRanges(new int[] {0,2,3,4,6,8,9}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> stringList = new ArrayList<>();
        int index = 0;
        int start = 0;
        while(index < nums.length) {
            start = index;
            while (index+1 < nums.length && nums[index]+1 == nums[index+1]) index++;
            System.out.println(nums[start] + " " + nums[index]);
            stringList.add(nums[start] != nums[index] ? (nums[start]  + "->" + nums[index]) : nums[start] + "");
            index++;
        }

        return stringList;
    }

    public int minFlips(int a, int b, int c) {
        String binaryA = Integer.toBinaryString(a);
        String binaryB = Integer.toBinaryString(b);
        String binaryC = Integer.toBinaryString(c);

        int count = 0;

        int max = (binaryA.length() > binaryB.length())
                ? (Math.max(binaryA.length(), binaryC.length())) :
                (Math.max(binaryB.length(), binaryC.length()));

        binaryA = String.format("%" + max + "s", binaryA).replace(' ', '0');
        binaryB = String.format("%" + max + "s", binaryB).replace(' ', '0');
        binaryC = String.format("%" + max + "s", binaryC).replace(' ', '0');
        System.out.println(binaryA + "-" + binaryB + "-" + binaryC);

        for(int i = 0; i < binaryC.length(); i++) {
            if(binaryC.charAt(i) == '0') {
                if(binaryA.charAt(i) == '0' && binaryB.charAt(i) == '0') {
                    continue;
                }
                if(binaryA.charAt(i) == '1' && binaryB.charAt(i) == '1') {
                    count +=2;
                    continue;
                }
                if(binaryA.charAt(i) == '1' || binaryB.charAt(i) == '1') {
                    count +=1;
                }
            } else {
                if(binaryA.charAt(i) == '0' && binaryB.charAt(i) == '0') {
                    count +=1;
                }
            }
        }

        return count;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        s = String.valueOf(sChar);

        char[] tChar = t.toCharArray();
        Arrays.sort(tChar);
        t = String.valueOf(tChar);

        if(s.equals(t)) {
            return true;
        }

        char[] one = new char[256];
        char[] two = new char[256];

        for(int i = 0 ; i < s.length(); i++) {
            one[s.charAt(i)]++;
        }

        for(int i = 0 ; i < t.length(); i++) {
            two[t.charAt(i)]++;
        }

        System.out.println(Arrays.toString(one));
        System.out.println(Arrays.toString(two));

        return Arrays.equals(one, two);
    }
}
