package com.leetcode;

import java.util.Collections;

public class PriorityQueueTest {
    public static void main(String[] args) {
//        java.util.PriorityQueue queue = new java.util.PriorityQueue(Collections.reverseOrder());
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<Integer>((a, b) -> b - a);
        queue.add(1);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(2);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
