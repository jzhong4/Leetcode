/*
 Author:     Junjie
 Date:       June 28, 2017
 Problem:    Best Time to Buy and Sell Stock III
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-iii/
 Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete at most two transactions.
 Notice
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 Example
 Given an example [4,4,6,1,1,4,2,5], return 6.
 Solution: 枚举每个位置左边最大利润，右边最大利润之和
*/
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        //当前位置下的最大利润
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        int min = prices[0];
        left[0] = 0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        
        int max = prices[prices.length - 1];
        right[prices.length - 1] = 0;
        for(int i = prices.length - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }
}