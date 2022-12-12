package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestPrefix {

    public static void main(String[] args) {
        System.out.println(new LongestPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));

        String s= "004430@@OBDX_BU@@0510469C0908";
    }


    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";
        boolean stop = true;
        int j = 0;

        while(stop) {
            if(checkPrefix(strs, j)) {
                commonPrefix = strs[0].substring(0, j+1);
                j++;
            } else {
                stop = false;
            }
        }

        return commonPrefix;
    }

    private boolean checkPrefix(String[] strs, int index) {
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < strs.length; i++) {
            if(index < strs[i].length()) {
                set.add(strs[i].charAt(index));
            } else {
                return false;
            }
        }

        return set.size() == 1;
    }
}