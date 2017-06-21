/*
 Author:     Junjie
 Date:       June 20, 2017
 Problem:    Minimum Adjustment Cost
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/minimum-adjustment-cost
 Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.
 If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
 Notice
 You can assume each number in the array is a positive integer and not greater than 100.
 Example
 Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.
 Return 2.
 Solution: DP
           state: f[i][j]表示第i个元素调整到j后，所需要付出的最小的代价和。所以其依赖于前一个元素调整到[j-target,j+target]范围内的最小代价和。
           function:  f[i][j]= Math.min(f[i][j], f[i-1][k]+tmpCost);  
*/
public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        int n = A.size();
        int[][] f = new int[n + 1][101];
        
        for(int i = 1; i<= 100; i++){
            f[1][i] = Math.abs(i - A.get(0));    
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 100; j++){
                f[i][j] = Integer.MAX_VALUE;
                int tmpCost = Math.abs(A.get(i - 1) - j);
                int min = Math.max(1, j - target);
                int max = Math.min(100, j + target);
                for(int k = min; k <= max; k++){
                    f[i][j] = Math.min(f[i][j], f[i-1][k]+tmpCost); 
                }
            }
        }
        
        int res = f[n][1];
        for(int i = 2; i <= 100; i++) {
            res = Math.min(res, f[n][i]);
        }
        return res;
    }
}