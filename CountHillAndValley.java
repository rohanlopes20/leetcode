package com.leetcode;

import java.util.Arrays;

public class CountHillAndValley {
    public static void main(String[] args) {
        System.out.println(new CountHillAndValley().countHillValley(new int[]{2,4,1,1,6,5}));
        System.out.println(new CountHillAndValley().countHillValley(new int[]{6,6,5,5,4,1}));
    }

    public int countHillValley(int[] nums) {
        int hillValley = 0;
        for(int i = 1; i < nums.length-1;i++) {
            if (nums[i] == nums[i + 1])
                nums[i] = nums[i - 1];
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])//    #hill check
                hillValley += 1;
            if (nums[i] < nums[i - 1] && nums[i] <nums[i + 1])//     #valley check
                hillValley += 1;
        }
        return hillValley;
    }
}
