package com.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
//        System.out.println(new ValidParentheses().isValid("[](){}"));
//        System.out.println(new ValidParentheses().isValid("{{(({{{{[[[](){}]]}}}}))}}"));
//        System.out.println(new ValidParentheses().isValid("}("));
        Stack<String> stack = new Stack<>();
//        stack.add("com.ofss.digx.app.card.service.Status.blockCard");
//        stack.add("com.ofss.digx.app.accountaccess.service.AccountAccess.checkAccountAccess");
//        stack.add("com.ofss.digx.app.accountaccess.service.AccountAccess.getAllowedAccounts");
//        stack.add("performAction");
        stack.add("com.ofss.digx.app.card.service.Status.blockCard");
        stack.add("com.ofss.digx.app.accountaccess.service.AccountAccess.getAllowedAccounts");
        int i = 0;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && ((s.charAt(i) == ']' && stack.peek() == '[')
                        || (s.charAt(i) == '}' && stack.peek() == '{')
                        || (s.charAt(i) == ')' && stack.peek() == '('))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
