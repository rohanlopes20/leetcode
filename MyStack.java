package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class MyStack {
    private List<Integer> first;

    public MyStack() {
        first = new ArrayList<>();
    }
    
    public void push(int x) {
        first.add(x);
    }
    
    public int pop() {
        return first.remove(first.size()-1);
    }
    
    public int top() {
      return first.get(first.size()-1);
    }
    
    public boolean empty() {
        return first.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

//        ["MyStack","push","push","top","pop","empty"]
//[[],[1],[2],[],[],[]]
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

    }
}