package com.mengangx.test.leetcode;

import com.mengangx.test.leetcode.MergeSortWithLinkedList.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * */

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp;
        ListNode revHead;
        int i;
        for(i=1; i<m; i++) {
            pre = cur;
            cur = cur.next;
        }
        revHead = cur;
        ListNode dummy = new ListNode(0);
        for(i=m; i<=n; i++) {
            temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }
        revHead.next = cur;
        if(pre != null) {
            pre.next = dummy.next;
            return head;
        }
        return dummy.next;
    }    
}