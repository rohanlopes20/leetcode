package com.leetcode;

import java.util.ArrayDeque;

public class ValidStackSequence {
    public static void main(String[] args) {
        int[] pushed =  {1,2,3,4,5}, popped = {4,3,5,1,2};
        System.out.println(new ValidStackSequence().validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++) {
            deque.add(pushed[i]);

            while(deque.peekLast() != null && deque.peekLast() == popped[j]) {
                deque.pollLast();
                System.out.println(pushed[i] + " " + popped[j]);
                j++;
            }
        }
        return deque.isEmpty();
    }
}
