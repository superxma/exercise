package com.mengangx.test.leetcode;

import com.mengangx.test.leetcode.MergeSortWithLinkedList.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * */

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode d1 = new ListNode(0);
        d1.next = null;
        ListNode d2 = new ListNode(0);
        d2.next = null;
        
        ListNode p = head;
        ListNode p1 = d1;
        ListNode p2 = d2;
        
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p = p.next;
                p1 = p1.next;
                p1.next = null;
            } else {
                p2.next = p;
                p = p.next;
                p2 = p2.next;
                p2.next = null;
            }
        }
        p1.next = d2.next;
        return d1.next;
    }    
}