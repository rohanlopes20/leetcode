package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1,2,3,1}));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for(int i : nums) {
            if(numsSet.add(i)) {
                return true;
            }
        }
        return false;
    }
}
