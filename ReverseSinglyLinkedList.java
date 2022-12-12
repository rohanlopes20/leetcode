package com.leetcode;

import java.util.List;

public class ReverseSinglyLinkedList {
    public static void main(String[] args) {
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3 , four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

//        System.out.println(new ReverseSinglyLinkedList().reverseList2(one));

        ListNode three1 = new ListNode(3 , null);
        ListNode one1 = new ListNode(1, three1);
        ListNode two1 = new ListNode(2, one1);
        ListNode four1 = new ListNode(4, two1);

        System.out.println(new ReverseSinglyLinkedList().sortList(four1));
    }

    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        ListNode listNode = sortListHelper(head);
        return listNode;
    }

    public ListNode sortListHelper(ListNode head) {
        if(head.next == null) {
            System.out.println(head.val);
            return head;
        }

        int length = 0;
        ListNode tmp = head;
        ListNode tmp2 = head;

        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }

        int mid = length / 2;

        int counter = 0;

        ListNode fistNode   = head;
        ListNode secondNode = head;
        ListNode prev = null;

        while (counter != mid) {
            //1-2-3-4-5
            prev = secondNode;
            secondNode = secondNode.next;
            counter++;
        }

        prev.next = null;

        ListNode leftHalf = sortListHelper(fistNode);
        ListNode rightHalf = sortListHelper(secondNode);

        ListNode result = mergeLists(leftHalf, rightHalf);

        return result;
    }

    public ListNode mergeLists(ListNode left, ListNode right) {
        if(left == null) return right;
        if( right == null) return left;

        //1-2 3-4
        //
        if(left.val < right.val) {
            left.next = mergeLists(left.next, right);
            return left;
        } else {
            right.next = mergeLists(right.next, left);
            return right;
        }
    }



    public ListNode reverseList2(ListNode head) {
        ListNode node  = reverseListHelper(head, null);
        return node;
    }

    public ListNode reverseListHelper(ListNode head, ListNode prev) {
        if(head == null) {
            return prev;
        }
        //1->2->3
        ListNode temp = head.next;
        head.next = prev;

        return reverseListHelper(temp, head);
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode next = head.next;
        ListNode prev = null;

        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;

            if(next == null) {
                current.next = prev;
            }
        }

        return current;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
        }
    }
}
