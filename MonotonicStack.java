package com.leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MonotonicStack().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int j = 0;

        for(int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek().getKey() < temperatures[i]) {
                Pair<Integer, Integer> tmp = stack.pop();
                ans[tmp.getValue()] = i - tmp.getValue();
            }
            stack.push(new Pair<>(temperatures[i], i));
        }

        return ans;
    }
}
