package com.leetcode;

public class OneEditDistance {
    public static void main(String[] args) {
        System.out.println(new OneEditDistance().isOneEditDistance("ROHAAAAAAAAAAN", "ROHAAAAAAAAAN"));
    }

    private boolean isOneEditDistance(String s, String t) {
        int s_length = s.length();
        int t_length = t.length();
        if(s_length - t_length > 1) return false;

        int i = 0, shift = s_length - t_length;
        while (i < s_length && s.charAt(i) == t.charAt(i)) i++;
        if(shift == 1) i++;
        while (i < s_length && s.charAt(i) == t.charAt(i-shift)) i++;
        return i == s_length;
    }
}
