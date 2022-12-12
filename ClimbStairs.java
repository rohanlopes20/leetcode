package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    private Map<Integer, Integer> cache = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(7));
        System.out.println(new ClimbStairs().countWays(100, new int[]{5, 50, 100}));
        System.out.println(new ClimbStairs().tribonacci(25));
    }

    public int tribonacci(int n) {
        if (n < 0)
            return 0;

        if (n == 1)
            return 1;

        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }

    private int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    private int fib(int n, int[] ways) {
        if (n < 0)
            return 0;

        if (n == 0)
            return 1;

        if(cache.get(n) != null) {
            return cache.get(n);
        }

        int count = 0;
        for(int i = 0; i < ways.length; i++) {
            count += fib(n - ways[i], ways);
        }

        cache.put(n , count);

        return count;
    }

    private int countWays(int s, int[] ways) {
        return fib(s , ways);
    }
}
