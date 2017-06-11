/*
 Author:     Junjie
 Date:       June 11, 2017
 Problem:    Triangle
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/triangle
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 Notice
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 Example
 Given the following triangle:
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
 */
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0){
            return -1;
        }
        
        if (triangle[0] == null || triangle[0].length == 0){
            return -1;
        }
        
        int n = triangle.length;
        int[][] minSum = new int[n][n];
        
        minSum[0][0] = triangle[0][0];
        for(int i = 1; i < n; i++){
            minSum[i][0] = minSum[i - 1][0] + triangle[i][0];
            minSum[i][i] = minSum[i - 1][i - 1] + triangle[i][i];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < i; j++){
               minSum[i][j] =  Math.min(minSum[i - 1][j - 1], minSum[i - 1][j]) + triangle[i][j];
            }
        }
        
        int minTotal = minSum[n - 1][0];
        for(int i  = 1; i < n; i++){
            minTotal = Math.min(minTotal, minSum[n - 1][i]);
        }
        
        return minTotal;
    }
}
