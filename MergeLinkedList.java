package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeLinkedList {

    public static void main(String[] args) {
        ListNode four4 = new ListNode(5, null);
        ListNode three = new ListNode(3 , four4);
        ListNode one1 = new ListNode(1 , three);
        ListNode four = new ListNode(4, null);
        ListNode two = new ListNode(2, four);
        ListNode one = new ListNode(1, two);

//        System.out.println(new MergeLinkedList().mergeTwoLists(one1, one));


        ListNode four41 = new ListNode(4, null);
        ListNode two2 = new ListNode(2, four41);
        ListNode one12 = new ListNode(1, two2);
        ListNode one11 = new ListNode(1, one12);
//        System.out.println(new MergeLinkedList().deleteDuplicates(one11));
        System.out.println(new MergeLinkedList().oddEvenList(one11));
    }

    public ListNode oddEvenList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        ListNode head1 = null;
        ListNode head1prev = null;
        ListNode head2 = null;
        ListNode head2prev = null;
        int counter = 1;

        for(Integer val : list) {
            ListNode node = new ListNode(val);
            if(counter % 2 == 0) {
                if(head2 == null) {
                    head2 = node;
                    head2prev = head2;
                } else {
                    head2prev.next = node;
                    head2prev = node;
                }
            } else {
                if(head1 == null) {
                    head1 = node;
                    head1prev = head1;
                } else {
                    head1prev.next = node;
                    head1prev = node;
                }
            }
            counter++;
        }

        head1prev.next = head2;

        return head1;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while(head != null && head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return temp;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 != null) {
            return list2;
        }
        if(list2 == null && list1 != null) {
            return list1;
        }
        if(list1 == null && list2 == null) {
            return null;
        }

        ListNode merged  = null;
        ListNode temp1  = list1;
        ListNode temp2  = list2;
        ListNode prevTemp  = null;

        while (temp1 != null || temp2 != null) {
            if(temp1 != null && temp2 == null) {
                ListNode node = new ListNode(temp1.val, null);
                prevTemp.next = node;
                prevTemp = node;
                temp1 = temp1.next;
                continue;
            }
            if(temp1 == null && temp2 != null) {
                ListNode node = new ListNode(temp2.val, null);
                prevTemp.next = node;
                prevTemp = node;
                temp2 = temp2.next;
                continue;
            }

            if(temp1.val < temp2.val) {
                if(merged == null) {
                    merged = new ListNode(temp1.val, null);
                    prevTemp = merged;
                    temp1 = temp1.next;
                } else {
                    ListNode node = new ListNode(temp1.val, null);
                    prevTemp.next = node;
                    prevTemp = node;
                    temp1 = temp1.next;
                }
            } else {
                if(merged == null) {
                    merged = new ListNode(temp2.val, null);
                    prevTemp = merged;
                    temp2 = temp2.next;
                } else {
                    ListNode node = new ListNode(temp2.val, null);
                    prevTemp.next = node;
                    prevTemp = node;
                    temp2 = temp2.next;
                }
            }
        }

        return merged;
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
