package com.mengangx.test.leetcode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class MergeSortWithLinkedList {
	
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		 }
	
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) { 
        	return head; 
        }
        ListNode middle = getMiddle(head);      //get the middle of the list
        ListNode sHalf = middle.next; 
        middle.next = null;   //split the list into two halfs

        return merge(sortList(head), sortList(sHalf));  //recurse on that
    }
    
    //Merge subroutine to merge two sorted lists
    public static ListNode merge(ListNode a, ListNode b) {
    	ListNode dummyHead, curr; dummyHead = new ListNode(0); curr = dummyHead;
        while(a !=null && b!= null) {
            if(a.val <= b.val) { curr.next = a; a = a.next; }
            else { curr.next = b; b = b.next; }
            curr = curr.next;
        }
        curr.next = (a == null) ? b : a;
        return dummyHead.next;
    }
    
    //Finding the middle element of the list for splitting
    public static ListNode getMiddle(ListNode head) {
        if(head == null) { return head; }
        ListNode slow, fast; slow = fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next; fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(13);
    	head.next = new ListNode(6);
    	head.next.next = new ListNode(7);
    	head.next.next.next = new ListNode(2);
    	head.next.next.next.next = new ListNode(1);
    	
    	ListNode newHead = sortList(head);
    	while(newHead != null) {
    		System.out.println(newHead.val);
    		newHead = newHead.next;
    	}
    }
    
}