package com.mengangx.test.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * */

public class JumpGame {
    public boolean canJump(int[] A) {
        if(A == null || A.length == 0) {
            return false;
        }
        int len = A.length - 1;
        int limit = 0; 
        int cur = 0;
        while (cur <= limit) {
            if(cur + A[cur] > limit) {
                limit = cur + A[cur];
            }
            if (limit >= len) {
                return true;
            }
            cur++;
        }
        return false;
    }     
}