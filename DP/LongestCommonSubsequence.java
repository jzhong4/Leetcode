/*
 Author:     Junjie
 Date:       June 15, 2017
 Problem:    Longest Common Subsequence
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/longest-common-subsequence
 Given two strings, find the longest common subsequence (LCS).
 Your code should return the length of LCS.
 Clarification
 What's the definition of Longest Common Subsequence?
 https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 http://baike.baidu.com/view/2020307.htm
 Example
 For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
 For "ABCD" and "EACB", the LCS is "AC", return 2.
 Solution: DP
           state: f[i][j]表示前i个字符配上前j个字符的LCS的长度 
           function: f[i][j] = f[i-1][j-1] + 1 // a[i] == b[j]                             = MAX(f[i-1][j], f[i][j-1]) // a[i] != b[j]
*/
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        int m = A.length(), n = B.length();
        int[][] f = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    f[i][j] = f[i - 1][j - 1] + 1; 
                }else{
                    f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
                }
            }
        }
        
        return f[m][n];
    }
}
