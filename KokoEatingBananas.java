package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KokoEatingBananas {
    public static void main(String[] args) {
//        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{3,6,7,11}, 8));
//        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{ 30,11,23,4,20 }, 5));
//        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{ 30,11,23,4,20 }, 6));
//        System.out.println(new KokoEatingBananas().isUgly(6));
//        System.out.println(new KokoEatingBananas().isUgly(1));
        System.out.println(new KokoEatingBananas().isUgly(14));
//        System.out.println(new KokoEatingBananas().isUgly(8));
    }

    public boolean isUgly(int n) {
        if(n==0)return false;
        if(n==1)return true;
        if (n%2==0) return isUgly(n/2);
        else if(n%3==0) return isUgly(n/3);
        else if(n%5==0) return isUgly(n/5);
        return false;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();

        int speed = max;

        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = (high + low) / 2;
            int counter = 0;

            for(int i : piles) {
                counter += Math.ceil(i /(double) mid);
            }

            if(counter <= h) {
                high = mid - 1;
                speed = Math.min(mid, speed);
            } else {
                low = mid + 1;
            }
        }

        return speed;
    }

}
