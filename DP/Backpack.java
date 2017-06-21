/*
 Author:     Junjie
 Date:       June 20, 2017
 Problem:    Backpack
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/backpack
 Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
 Example
 If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
 You function should return the max size we can fill in the given backpack. 
 Solution: DP
           state: f[i][j]表示前i个数，取出一些是否能组成和为j
           function:  f[i][j] = f[i - 1][j - A[i]] or f[i - 1][j] i这一位取或者不取的情况    
*/
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        boolean[][] f = new boolean[A.length + 1][m + 1];
        
        f[0][0] = true;
        for(int i = 1; i <= A.length; i++){
            for(int j = 0; j <= m; j++){
                f[i][j] = f[i - 1][j];
                if(j >= A[i - 1] && f[i - 1][j - A[i - 1]]){
                     f[i][j] = true;
                }
            }
        }
        
        for(int i = m; i >= 0; i--){
            if(f[A.length][i]){
                return i;
            }
        }
        
        return 0;
    }
}