/*
 Author:     Junjie
 Date:       June 20, 2017
 Problem:    Backpack II
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/backpack-ii
 Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?
 Example
 Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
 Solution: DP
           state: f[i][j]表示前i个数，取出一些组成j的体积最大值
           function:  f[i][j] = max(f[i - 1][j - A[i]] + V[i - 1], f[i - 1][j]) i这一位取或者不取的情况    
*/
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        
        int[][] f = new int[A.length + 1][m + 1];
        
        for(int i = 1; i <= A.length; i++){
            for(int j = 0; j <= m; j++){
                f[i][j] = f[i - 1][j];
                if(j >= A[i - 1]){
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i <= m; i++){
            maxValue = Math.max(maxValue, f[A.length][i]);
        }
        return maxValue;
    }
}