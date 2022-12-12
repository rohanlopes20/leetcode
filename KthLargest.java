package com.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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

    public static void main(String[] args) {
        KthLargest obj = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(obj.add(3));//2,3,4,5,8 ->4
        System.out.println(obj.add(5));//2,3,4,5,5,8 -> 5
        System.out.println(obj.add(10));//2,3,4,5,5,8,10 -> 5
        System.out.println(obj.add(9));//2,3,4,5,5,8,9,10 -> 8
        System.out.println(obj.add(4));//2,3,4,4,5,5,8,9,10 -> 8
    }
}