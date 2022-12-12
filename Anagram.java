package com.leetcode;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(new Anagram().isAnagram("anagram","nagaram"));
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
