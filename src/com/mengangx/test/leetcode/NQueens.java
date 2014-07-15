package com.mengangx.test.leetcode;

import java.util.ArrayList;

/**
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [ 
 * [".Q..", // Solution 1 
 * "...Q", 
 * "Q...", 
 * "..Q."],
 * 
 * ["..Q.", // Solution 2 
 * "Q...", 
 * "...Q", 
 * ".Q.."] 
 * ]
 * */

public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> list = new ArrayList<String[]>();
        int [] col = new int[n]; //col[i] = 1 if ith column has a queen, col[i] else
        int [] row = new int[n]; //row[r] = j: rth row has queen at column j
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<n; i++) {
            builder.append(".");
        }
        String base = builder.toString();
        dfs(list, row, col, 0, n, base);
        return list;
    }
    
    public void dfs(ArrayList<String[]> result, int[] row, int[] col, int r, int n, String base) {
        int i, j;
        if(r == n) {
            String[] solution = new String[n];
            for(i=0; i<n; i++) {
                String temp = base.substring(0, row[i]) + "Q" +  base.substring(row[i] + 1);
                solution[i] = temp;
            }
            result.add(solution);
            return;
        }
        for(i=0; i<n; i++) {
            if(col[i] == 0) { //col i is not occupied
                for(j=0; j<r; j++) { //for each previous row
                    if(Math.abs(j-r) == Math.abs(i-row[j])) { //check diagonal line
                        break;
                    }
                }
                if(j == r) { //no diagonal conflict
                    col[i] = 1;
                    row[r] = i;
                    dfs(result, row, col, r+1, n, base);
                    col[i] = 0; //reset 
                    row[r] = 0;
                }
            }
        }
        return;
    }    
}