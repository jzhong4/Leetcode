/*
 Author:     Junjie
 Date:       June 20, 2017
 Problem:    Distinct Subsequences
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/distinct-subsequences
 Given a string S and a string T, count the number of distinct subsequences of T in S.(在S里面，有几个不同的T的子序列)
 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 Example
 Given S = "rabbbit", T = "rabbit", return 3. 
 Solution: DP
           state: f[i][j]表示S前i个字符配上T前j个字符的不同的子序列 
           function: f[i][j] = f[i-1][j-1] + + f[i - 1][j] // S[i] == T[j]                             
                             = f[i - 1][j] // S[i] != T[j]
*/
public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if (S == null || T == null){
            return 0;
        }
        
        int m = S.length(), n = T.length();
        int[][] f = new int[m + 1][n + 1];
        
        for(int i = 0; i <= m; i++){
            f[i][0] = 1;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                f[i][j] = f[i - 1][j]; 
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                   f[i][j] += f[i - 1][j - 1]; 
                }
            }
        }
        return f[m][n];
    }
}