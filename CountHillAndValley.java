package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountHillAndValley {
    public static void main(String[] args) {
//        System.out.println(new CountHillAndValley().countHillValley(new int[]{2,4,1,1,6,5}));
//        System.out.println(new CountHillAndValley().countHillValley(new int[]{6,6,5,5,4,1}));
        System.out.println(new CountHillAndValley().countHillValley(new int[]{6,6,5,5,4,1}));
        System.out.println(new CountHillAndValley().kidsWithCandies(new int[]{2,3,5,1,3},3));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
//[true,true,true,false,true]
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> list = new ArrayList<>();

        for(int i = 0; i < candies.length; i ++) {
            if(candies[i] + extraCandies >= max) {
                list.add(Boolean.TRUE);
            } else {
                list.add(Boolean.FALSE);
            }
        }
        return list;
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
