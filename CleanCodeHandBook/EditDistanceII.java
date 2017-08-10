/*
 Author:     Junjie
 Date:       August 10, 2017
 Problem:    Edit Distance II
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/edit-distance-ii/
 Given two strings S and T, determine if they are both one edit distance apart. 
 Example
 Given s = "aDb", t = "adb"
 return true
 Solution: 1. DP, Edit distance最少需要多少steps，可以使两个字符串相等。最后判断是不是1。
           2. O(n) runtime, O(1) space – Simple one-pass
              We make a first pass over S and T concurrently and stop at the first non-matching character between S and T.(假设s的长度小于t的长度，不然可以交换位置)
              长度相同：同时跳过非匹配的字符，看剩下的是否相等
              长度不同：T跳过非匹配字符，看剩下的是否相等
              最后:如果全部相同是false，或者T多出最后一位(可以通过 m！=n关系得到)           
*/
public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
	    if(m > n) return isOneEditDistance(word2, word1);
        if(Math.abs(m - n) > 1) return false;
        
        for(int i = 0; i < m; i++){
            if(word1.charAt(i) != word2.charAt(i)){
                if(m == n){
                    return word1.substring(i + 1).equals(word2.substring(i + 1));
                }else{
                    return word1.substring(i).equals(word2.substring(i + 1));
                }
            }
        }
        return m != n;
    }
}