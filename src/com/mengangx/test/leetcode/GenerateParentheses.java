package com.mengangx.test.leetcode;

import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * */

public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);
        return res;
    }
    //lps is the number of lefe Parentheses, while rps is the number of right Parentheses
    public void generate(ArrayList<String> res, String temp, int lps, int rps, int n){
        if (lps==n){
            for (int i=0; i<n-rps;i++){
                temp += ")";
            }
            res.add(temp);
            return;
        }
        generate(res, temp+"(", lps+1, rps, n);
        if (rps<lps)
        generate(res, temp+")", lps, rps+1, n);
    }
    
}