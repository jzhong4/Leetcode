/*
 Author:     Junjie
 Date:       June 15, 2017
 Problem:    Edit Distance
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/edit-distance/
 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 You have the following 3 operations permitted on a word:
 Insert a character
 Delete a character
 Replace a character
 Example
 Given word1 = "mart" and word2 = "karma", return 3. 
 Solution: DP, insert 和 delete其实是等价的
           state: f[i][j]a的前i个字符“配上”b的前j个字符 最少要用几次编辑使得他们相等
           function: f[i][j] = f[i-1][j-1]                                // a[i] == b [j]                             = MIN(f[i-1][j], f[i][j-1], f[i-1][j-1]) + 1 // a[i] != b[j]
*/
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        
        
        for(int i = 0; i <= m; i++){
            f[i][0] = i;
        }
        
        for(int i = 0; i <= n; i++){
            f[0][i] = i;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    f[i][j] = f[i - 1][j - 1]; 
                }else{
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j],f[i][j - 1])) + 1;
                }
            }
        }
        return f[m][n];
    }
}