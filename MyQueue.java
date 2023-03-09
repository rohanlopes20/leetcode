package com.leetcode;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(!stack2.isEmpty()) {
        return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        if(!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
       MyQueue obj = new MyQueue();
//        ["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
//        [[],[1],[2],[3],[4],[],[5],[],[],[],[]]
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.pop();
        obj.push(5);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
//        [null,null,null,null,null,1,null,5,2,3,4]
//        Expected:
//        [null,null,null,null,null,1,null,2,3,4,5]
    }
}