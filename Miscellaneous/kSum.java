/*
 Author:     Junjie
 Date:       July 03, 2017
 Problem:    k Sum
 Difficulty: Hard
 Source:     http://www.lintcode.com/en/problem/k-sum/
 Given n distinct positive integers, integer k (k <= n) and a number target.
 Find k numbers where sum is target. Calculate how many solutions there are?
 Example
 Given [1,2,3,4], k = 2, target = 5. 
 There are 2 solutions: [1,4] and [2,3].
 Return 2. 
Solution:  DP
           state: f[i][j][target]表示前i个数，取j个数，组成和为target的方案有多少个
           function: f[i][j][target] = f[i - 1][j - 1][target - A[i - 1]] // 取第i个数                             = f[i - 1][j][target] // 不取第i个数
*/
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        int n = A.length;
        
        int[][][] f = new int[n + 1][k + 1][target + 1];
        for(int i = 0; i <= n; i++){
            f[i][0][0] = 1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k && j <= i; j++){
                for(int t = 1; t <= target; t++){
                    f[i][j][t] = f[i - 1][j][t];
                    if(t >= A[i - 1]){
                       f[i][j][t] += f[i - 1][j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        
        return f[n][k][target];
    }
}
