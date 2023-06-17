package com.leetcode;

import java.util.Stack;

class BrowserHistory {
    class DLL {
        private DLL next;
        private DLL prev;
        private String value;

        public DLL(String value, DLL prev, DLL next){
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

    }
    private DLL current;
    public BrowserHistory(String homepage) {
        this.current = new DLL(homepage, null, null);
    }
    
    public void visit(String url) {
        // x->y
        // x<-y
        this.current.next = new DLL(url, this.current, null);
        this.current = this.current.next;
        System.out.println(this.current.value);
    }
    
    public String back(int steps) {
        DLL tmp = this.current;
        int counter = 0;

        while(counter != steps && tmp.prev != null) {
            tmp = tmp.prev;
            counter++;
        }

        this.current = tmp;

        System.out.println(tmp.value);
        return tmp.value;
    }
    
    public String forward(int steps) {
        DLL tmp = this.current;
        int counter = 0;

        while(counter != steps && tmp.next != null) {
            tmp = tmp.next;
            counter++;
        }
        System.out.println(tmp.value);
        this.current = tmp;
        return tmp.value;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"

    }
}