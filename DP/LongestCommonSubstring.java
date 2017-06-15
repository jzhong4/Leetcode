/*
 Author:     Junjie
 Date:       June 15, 2017
 Problem:    Longest Common Substring
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/longest-common-substring
 Given two strings, find the longest common substring.
 Return the length of it.
 Notice
 The characters in substring should occur continuously in original string. This is different with subsequence.
 Example
 Given A = "ABCD", B = "CBCE", return 2. 
 Solution: Substring vs Subsequence
	   DP
           state: f[i][j]表示前i个字符配上前j个字符的LCS‘的长度 (一定以第i个和第j个结尾的LCS’) 
           function: f[i][j] = f[i-1][j-1] + 1 // a[i] == b[j]                             = 0 // a[i] != b[j]
*/
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        int m = A.length(), n = B.length();
        int maxLength = 0;
        int[][] f = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    f[i][j] = f[i - 1][j - 1] + 1;
                }else{
                    f[i][j] = 0;
                }
                maxLength = Math.max(f[i][j], maxLength);
            }
        }
        return maxLength;    
    }
}