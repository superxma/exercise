package com.mengangx.test.leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * */

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int len = A.length;
        if (A == null || len == 0 || A[0] >= target) {
            return 0;
        }
        if (A[len - 1] < target) {
            return len;
        }
        
        int l = 0;
        int r = len - 1;
        int m;
        //invariant A[l] < target and A[r] >= target
        while (r - l > 1) {
            m = l + (r - l) / 2;
            if(A[m] < target) {
                l = m;
            } else {
                r = m;
            }
            
        }
        return r;
    } 
}