/*
 Author:     Junjie
 Date:       June 11, 2017
 Problem:    Unique Paths
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/unique-paths/
 A robot is located at the top-left corner of a m x n grid.
 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
 How many possible unique paths are there?
 Notice
 m and n will be at most 100.
 Example
 Given m = 3 and n = 3, return 6.
 Given m = 4 and n = 5, return 35.
*/
public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        int[][] sum = new int[m][n];
        
        sum[0][0] = 1;
        for(int i = 0; i < m; i++){
           sum[i][0] = 1; 
        }
        
        for(int i = 0; i < n; i++){
           sum[0][i] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];        
            }
        }
        
        return sum[m - 1][n - 1];
    }
}
