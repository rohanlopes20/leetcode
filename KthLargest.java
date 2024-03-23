package com.leetcode;

import java.util.*;

class KthLargest {
    PriorityQueue<Integer> integers;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        integers = new PriorityQueue<>(k);

        for(int num : nums) {
            integers.offer(num);

            if(integers.size() > k) {
                integers.poll();
            }
        }
    }
    
    public int add(int val) {
        integers.offer(val);

        if(integers.size() > k) {
            integers.poll();
        }

        return integers.peek();
    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        int left  = 0;
        int right = left + k - 1;

        System.out.println(Arrays.toString(nums));
        //1,4,7,9 //2

        while(right < nums.length) {
            int firstScore  = nums[left];
            int secondScore = nums[right];
            System.out.println(firstScore + " - " + secondScore);
            int tmpDiff = Math.abs(firstScore - secondScore);
            diff = Math.min(tmpDiff, diff);
            left++;
            right++;
        }


        return 0;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {9,4,1,7};
        System.out.println(minimumDifference(arr, 2));

        KthLargest obj = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(obj.add(3));//2,3,4,5,8 ->4
        System.out.println(obj.add(5));//2,3,4,5,5,8 -> 5
        System.out.println(obj.add(10));//2,3,4,5,5,8,10 -> 5
        System.out.println(obj.add(9));//2,3,4,5,5,8,9,10 -> 8
        System.out.println(obj.add(4));//2,3,4,4,5,5,8,9,10 -> 8
    }
}