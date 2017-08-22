/*
 Author:     Junjie
 Date:       Aug 22, 2017
 Problem:    Longest Substring Without Repeating Characters
 Difficulty: Medium
 Source:     https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 Solution:   追击性指针类
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int j = 0, count = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            while(j < n && map[s.charAt(j)] == 0){
                map[s.charAt(j)] = 1;
                count = Math.max(count, j - i + 1);
                j++;
            }
            map[s.charAt(i)] = 0;
        }
        return count;
    }
}
