package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
//        System.out.println(new PascalTriangle().generate(100));
//        System.out.println(new PascalTriangle().divisorGame(2));
//        System.out.println(new PascalTriangle().divisorGame(3));
//        System.out.println(new PascalTriangle().divisorGame(6));
//        System.out.println(new PascalTriangle().divisorGame(4));
        System.out.println(new PascalTriangle().searchInsert(new int[] {1,3,5,6}, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int pos = -1;
        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            int mid = (l + h) / 2;

            if(h - l == 1 ) {
                if(target > nums[h]) {
                    return h+1;
                } else if(target > nums[l]) {
                    return l+1;
                } else {
                    return l;
                }
            }

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                l = mid;
            } else {
                h = mid;
            }
        }

        return pos;
    }

    public boolean divisorGame(int n) {
        int counter = 0;
        int num = n;

        for(int i = n - 1; i > 0; i--) {
            if(num % i == 0) {
                num = num - i;
                counter++;
            }
        }

        return counter % 2 != 0 && num !=0;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                    continue;
                }
                List<Integer> row = ans.get(i - 1);
                int num1 = j - 1;
                int num2 = j;
                int sum = row.get(num1) + row.get(num2);
                list.add(sum);
            }
            ans.add(list);
        }

        return ans;
    }
}
