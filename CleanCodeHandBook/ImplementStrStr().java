/*
 Author:     Junjie
 Date:       July 25, 2017
 Problem:    Implement strStr()
 Difficulty: Easy
 Source:     https://leetcode.com/problems/implement-strstr/#/description
 Implement strStr().
 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. Example
 Solution: O(nm) runtime, O(1) space – Brute force. The brute force method is straightforward to implement. We scan the needle with the haystack from its first position and start matching all subsequent letters one by one. If one of the letters does not match, we start over again with the next position in the haystack. Assume that n = length of haystack and m = length of needle, then the runtime complexity is O(nm). Have you considered these scenarios?
 i. needle or haystack is empty. If needle is empty, always return 0. If haystack is empty, then there will always be no match (return –1) unless needle is also empty which 0 is returned. ii. needle’s length is greater than haystack’s length. Should always return –1.*/

public class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0; ; i++){
            for(int j = 0; ; j++){
                if(j == needle.length()) return i;
                if(i + j == haystack.length()) return -1;
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }
}