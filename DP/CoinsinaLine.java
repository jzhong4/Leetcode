/*
 Author:     Junjie
 Date:       June 23, 2017
 Problem:    Coins in a Line
 Difficulty: Medium
 Source:     lintcode 未解锁
 Solution:   记忆化搜索, dp[i] = 0, 未访问，1 false， 2 true
*/
public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        int[] dp = new int[n + 1];
        
        return MemorySearch(n, dp);
    }
    
    private boolean MemorySearch(int i, int[] dp){
        //记忆化部分
        if(dp[i] != 0){
           if(dp[i] == 1){
               return false;
           }else{
               return true;
           }
        }
        //边界条件
        if(i <= 0) {
            dp[i] = 1;
        } else if(i == 1) {
            dp[i] = 2;
        } else if(i == 2) {
            dp[i] = 2;
        } else if(i == 3) {
            dp[i] = 1;
        } else {
            if((MemorySearch(i - 2, dp) && MemorySearch(i - 3, dp)) || 
                (MemorySearch(i - 3, dp) && MemorySearch(i - 4, dp) )) {
                dp[i] = 2;
            } else {
                dp[i] = 1;
            }
        }
        if(dp[i] == 2) 
            return true;
        return false;
    }
    
}