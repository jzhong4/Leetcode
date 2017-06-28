/*
 Author:     Junjie
 Date:       June 28, 2017
 Problem:    Best Time to Buy and Sell Stock II
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-ii/
 Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 Example
 Given an example [2,1,2,0,1], return 2 
 Solution: 因为可以买卖多次，所以只要是增长的都买卖一次。
*/
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i - 1];
            if(diff > 0){
                profit += diff;
            }
        }
    return profit;
 }
}