/*
 Author:     Junjie
 Date:       June 11, 2017
 Problem:    Unique Paths II
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/unique-paths-ii
 Follow up for "Unique Paths":
 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 Notice
 m and n will be at most 100.
 Example
 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2. 
*/
public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0){
            return -1;
        }
        
        if(obstacleGrid[0] == null || obstacleGrid[0].length == 0){
            return -1;
        }
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] sum = new int[m][n];
        
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            sum[i][0] = 1; 
        }
        
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
           sum[0][i] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    sum[i][j] = 0;
                    continue;
                }
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];        
            }
        }
        
        return sum[m - 1][n - 1];
    }
}
