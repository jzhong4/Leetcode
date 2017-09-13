/*
 Author:     Junjie
 Date:       Aug 22, 2017
 Problem:    Maximal Square
 Difficulty: Medium
 Source:     https://leetcode.com/problems/maximal-square/description/
 Solution:   f[i][j] 表示以i和j作为正方形右下角可以拓展的最大边长
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return ans;
        }
        
        int n = matrix.length, m = matrix[0].length;
        int[][] res = new int[n][m];
        
        for(int i = 0; i < n; i++){
            if(matrix[i][0] == '1'){
                res[i][0] = 1;
            }
            ans = Math.max(res[i][0] , ans);
            for(int j = 1; j < m; j++){
                if(i > 0){
                if(matrix[i][j] == '1') {
                        res[i][j] = Math.min(res[i - 1][j],Math.min(res[i][j-1], res[i-1][j-1])) + 1;
                    } else {
                        res[i][j] = 0;
                }
                }else{
                    if(matrix[i][j] == '1'){
                        res[i][j] = 1;
                    }
                }
               ans = Math.max(res[i][j], ans); 
            }
        }
        return ans * ans;
    }
}