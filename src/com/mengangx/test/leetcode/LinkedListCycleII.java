package com.mengangx.test.leetcode;

import com.mengangx.test.leetcode.MergeSortWithLinkedList.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Follow up: Can you solve it without using extra space?
 * */

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow=head, fast=head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                fast = head;
                while(fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
            
        }
        return null;
    }    
}