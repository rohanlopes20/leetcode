package com.leetcode;

import java.util.Stack;

class StackPostFix {
    public static void main(String[] args) {
        System.out.println(new StackPostFix().evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(new StackPostFix().evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(new StackPostFix().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                Integer second = stack.pop();
                Integer first  = stack.pop();

                int result = 0;
                switch (tokens[i]) {
                    case "+":
                        result = first + second;
                    break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}