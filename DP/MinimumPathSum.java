/*
 Author:     Junjie
 Date:       June 11, 2017
 Problem:    Minimum Path Sum
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/minimum-path-sum/
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 Notice
 You can only move either down or right at any point in time.
*/
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0){
            return -1;
        }
        
        if (grid[0] == null || grid[0].length == 0){
            return -1;
        }
        
        int m = grid.length, n = grid[0].length;
        int[][] minSum = new int[m][n];
        
        minSum[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            minSum[i][0] = minSum[i - 1][0] + grid[i][0];
        }
        
        for(int i = 1; i < n; i++){
            minSum[0][i] = minSum[0][i - 1] + grid[0][i];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                minSum[i][j] = Math.min(minSum[i - 1][j], minSum[i][j - 1]) + grid[i][j];
            }
        }
        
        return minSum[m - 1][n - 1];
    }
}