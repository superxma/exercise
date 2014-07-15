package com.mengangx.test.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * */

public class JumpGameII {
    public int jump(int[] A) {
        int len = A.length;
        if (len <= 1) {
            return 0;
        }
        
        int start = 0;
        int end = 0;
        int count = 0;
        
        while(end < len) {
            int max = 0;
            count++;
            for(int i = start; i<=end; i++) {
                int temp = A[i] + i;
                if (temp >= len - 1) {
                    return count;
                } 
                if (temp > max) {
                    max = temp;
                }
            }
            start = end + 1;
            end = max;
        }
        return -1;
    }
}