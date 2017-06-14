/*
 Author:     Junjie
 Date:       June 13, 2017
 Problem:    Palindrome Partitioning II
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/palindrome-partitioning-ii/
 Given a string s, cut s into some substrings such that every substring is a palindrome.
 Return the minimum cuts needed for a palindrome partitioning of s.
 Example
 Given s = "aab",
 Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.
*/
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    // f[i] 表示前i个字母，最少被切割几次可以切割为都是回文串，最后return f[n]
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        //这里f[0]表示前0个字符串，指空串
        int[] f = new int[s.length() + 1];
        for(int i = 0; i <= s.length(); i++){
            f[i] = i - 1;
        }
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(isPalindrome[j][i - 1]){
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            } 
        }
        
        return f[s.length()];    
        
    }
    // 判断一个字符串是否为回文串
    private boolean isPalindrome(String s, int start, int end){
        for (int i = start, j = end; start < end; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    
    // 判断s[i][j],字符串i到j位是否是回文串
    private boolean[][] getIsPalindrome(String s){
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        //只有一个字符
        for(int i = 0; i < s.length(); i++){
           isPalindrome[i][i] = true; 
        }
        //两个字符
        for(int i = 0; i < s.length() - 1; i++){
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        //两个字符以上，s[i][j]是否为回文串，取决于s[i + 1][j - 1]是否是回文串 && i和j位是否相等
        for(int length = 2; length < s.length(); length++){
            for(int start = 0; start + length < s.length(); start++){
                isPalindrome[start][start + length] = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
        return isPalindrome;
    }
}