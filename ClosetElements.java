package com.leetcode;

import java.util.*;

public class ClosetElements {
    public static void main(String[] args) {
//        [1,1,1,10,10,10]
//        System.out.println(new ClosetElements().findClosestElements(new int[]{1,1,1,10,10,10}, 1, 9));
        System.out.println(new ClosetElements().findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
//        System.out.println(new ClosetElements().findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
        //find closest with binary search
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-1;

        int val = arr[0];
        int index = 0;
        while (left < right) {
            int mid = left+right/2;
            int curDiff = Math.abs(arr[mid] - x);
            int resDiff  = Math.abs(val - x);

            if (curDiff < resDiff || (curDiff == resDiff && arr[mid] < val)){
                val = arr[mid];
                index = mid;
            }

            if(arr[mid] < x) {
                left = mid + 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                break;
            }
        }

        System.out.println(index + " " + left + " " + right);

        List<Integer> ans = new ArrayList<>();

        Collections.sort(ans);

        return ans;
    }
}
