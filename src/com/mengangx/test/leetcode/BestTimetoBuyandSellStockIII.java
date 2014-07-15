package com.mengangx.test.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * */

public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int length = prices.length;
        if(length == 0) {
            return profit;
        }
        int [] m1 = new int[length]; //store max profit of 1 transction between 0 and i
        int [] m2 = new int[length]; //store max profit of 1 transction between i and n-1
        
        int minPrice = prices[0];
        for(int i=1; i<length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            m1[i] = Math.max(m1[i-1], prices[i] - minPrice);
        }
        
        int maxPrice = prices[length-1];
        for(int i=length-2; i>=0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            m2[i] = Math.max(m2[i+1], maxPrice - prices[i]);
        }
        
        for(int i=0; i<length; i++) {
            profit = Math.max(profit, m1[i]+m2[i]);
        }
        return profit;
    }
}