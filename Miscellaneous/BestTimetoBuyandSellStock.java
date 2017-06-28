/*
 Author:     Junjie
 Date:       June 28, 2017
 Problem:    Best Time to Buy and Sell Stock
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock/
 Say you have an array for which the ith element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 Example
 Given array [3,2,3,1,2], return 1.
 Solution: 扫描卖出的点，并且记录每个点之前的最小值。
 */
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int maxProfit = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            min = min < prices[i]? min : prices[i];
            maxProfit = maxProfit > prices[i] - min? maxProfit : prices[i] - min;
        }
        return maxProfit;
    }
}