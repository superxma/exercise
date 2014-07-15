package com.mengangx.test.leetcode;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example, Given height = [2,1,5,6,2,3], return 10.
 * */

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while(i < height.length) {
            if(stack.empty() || stack.peek() <= height[i]) {
                stack.push(height[i]);
                i++;
            } else {
                int count = 0;
                while(!stack.empty() && stack.peek() > height[i]) {
                    count++;
                    max = Math.max(max, count * stack.pop());
                }
                for(int j=0; j<count+1; j++) {
                    stack.push(height[i]);
                }
                i++;
            }
        }
        int count = 0;
        while(!stack.isEmpty()) {
            count++;
            max = Math.max(max, stack.pop() * count);
        }
        return max;
    }    
}