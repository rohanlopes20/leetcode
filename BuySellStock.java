package com.leetcode;

public class BuySellStock {
    public static void main(String[] args) {
//        System.out.println(new BuySellStock().maxProfit(new int[]{7,1,5,3,6,4}));
//        System.out.println(new BuySellStock().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new BuySellStock().maxProfit(new int[]{2,4,1}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0, r = 1;

        while (r < prices.length) {
            if(prices[l] < prices[r]) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
                r++;
            } else {
                l = r;
                r++;
            }
        }

        return maxProfit;
    }
}
