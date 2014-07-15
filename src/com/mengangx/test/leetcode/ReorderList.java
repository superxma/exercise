package com.mengangx.test.leetcode;

import com.mengangx.test.leetcode.MergeSortWithLinkedList.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        //find the middle element of the list
        ListNode slow=head, fast=head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //divide the list into two parts at middle
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;
        //reverse the second list
        ListNode dummy = new ListNode(0);
        ListNode cur = l2;
        ListNode temp;
        while(cur != null) {
            temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }
        l2 = dummy.next;
        //combine the two lists
        cur = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null) {
            cur.next = cur1;
            temp = cur1.next;
            cur1.next = cur2;
            cur1 = temp;
            cur2 = cur2.next;
            cur = cur.next.next;
        }
        if(cur1 != null) {
            cur.next = cur1;
        }
        head = dummy.next;
        return;
    }    
}