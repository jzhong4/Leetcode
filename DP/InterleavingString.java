/*
 Author:     Junjie
 Date:       June 15, 2017
 Problem:    Interleaving String
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/interleaving-string
 Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
 Example
 For s1 = "aabcc", s2 = "dbbca"
 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false. 
 Solution: DP
           state: f[i][j]表示s1前i个字符配上s2前j个字符能否组成交叉字符串
           function:  f[i][j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[i - 1][j])||(s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[i][j - 1]));               
*/
public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @param : A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        boolean[][] isInterleave = new boolean[s1.length() + 1][s2.length() + 1];
        isInterleave[0][0] = true;
        
        for(int i = 1; i <= s1.length(); i++){
            isInterleave[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1) && isInterleave[i - 1][0]);
        }
        
        for(int i = 1; i <= s2.length(); i++){
            isInterleave[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1) && isInterleave[0][i - 1]);
        }
        
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                isInterleave[i][j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && isInterleave[i - 1][j])||(s2.charAt(j - 1) == s3.charAt(i + j - 1) && isInterleave[i][j - 1]));
            }
        }
        return isInterleave[s1.length()][s2.length()];
    }
};