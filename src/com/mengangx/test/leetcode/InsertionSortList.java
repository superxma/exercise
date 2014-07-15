package com.mengangx.test.leetcode;

/**
 * Sort a linked list using insertion sort.
 */

import com.mengangx.test.leetcode.MergeSortWithLinkedList.ListNode;


public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head; //add a dummy head to facilitate inserting
        ListNode prev = head, cur = head.next, temp, low;
        while(cur != null) {
            low = dummy;
            while(low.next.val <= cur.val && low.next != cur) {
                low = low.next;
            }
            if(low == prev) { //already sorted
                prev = cur;
                cur = cur.next;
                continue;
            }
            //insert after low;
            temp = cur.next;
            cur.next = low.next;
            low.next = cur;
            prev.next = temp;
            cur = temp;
        }
        return dummy.next;
    }    
}