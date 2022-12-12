package com.leetcode;

import java.math.BigDecimal;

class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ListNode{");
            sb.append("val=").append(val);
            sb.append('}');
            return sb.toString();
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final StringBuffer num1 = new StringBuffer();
        final StringBuffer num2 = new StringBuffer();

        ListNode tmp1 = l1;
        ListNode tmp2 = l2;

        while (tmp1 != null) {
            num1.append(tmp1.val);
            tmp1 = tmp1.next;
        }

        while (tmp2 != null) {
            num2.append(tmp2.val);
            tmp2 = tmp2.next;
        }

        BigDecimal num11 = new BigDecimal(String.valueOf(num1.reverse()));
        BigDecimal num22 = new BigDecimal(String.valueOf(num2.reverse()));

        BigDecimal sum = num11.add(num22);

        String nums = String.valueOf(sum);
        int lengthOfList = nums.length();

        String numReverse = new StringBuffer(nums).reverse().toString();

//        System.out.println(Integer.parseInt(String.valueOf(num1.reverse())));
//        System.out.println(Integer.parseInt(String.valueOf(num2.reverse())));

        ListNode ll = new ListNode();
        ListNode prev = null;

        for(int i = 0 ; i < lengthOfList; i++) {
            if(i == 0) {
                ll.val = Integer.parseInt(String.valueOf(numReverse.charAt(i)));
                prev = ll;
            } else {
                ListNode newll = new ListNode();
                newll.val = Integer.parseInt(String.valueOf(numReverse.charAt(i)));
                prev.next = newll;
                prev = newll;
            }
        }

        return ll;
    }

    public static void main(String[] args) {
        //[2,4,3]
        //[5,6,4]
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l12 = a.new  ListNode();
        ListNode l14 = a.new  ListNode();
        ListNode l13 = a.new  ListNode();
        ListNode l25 = a.new  ListNode();
        ListNode l26 = a.new  ListNode();
        ListNode l24 = a.new  ListNode();
        l12.val = 2; l12.next = l14;
        l14.val = 4; l14.next = l13;
        l13.val = 3; l13.next = null;
        l25.val = 5; l25.next = l26;
        l26.val = 6; l26.next = l24;
        l24.val = 4; l24.next = null;



        ListNode node = a.addTwoNumbers(l12, l25);
        int i=0;
    }
}