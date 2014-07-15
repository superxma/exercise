package com.mengangx.test.leetcode;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * */

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(n < k) {
            return null;
        }
        if (k == 1) {
            for(int i=1; i<= n; i++){
                ArrayList<Integer> cur = new ArrayList<Integer>();
                cur.add(i);
                result.add(cur);
            }
            return result;
        } else {
            for (int i=n; i>=k; i--) {
                for(ArrayList<Integer> cur : combine(i-1, k-1)) {
                    cur.add(i);
                    result.add(cur);
                }
            }
            return result;
        }
    }
}