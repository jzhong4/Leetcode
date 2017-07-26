/*
 Author:     Junjie
 Date:       July 25, 2017
 Problem:    Reverse Words in a String
 Difficulty: Medium
 Source:     https://leetcode.com/problems/reverse-words-in-a-string/#/description
 Given an input string, reverse the string word by word.
 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 Solution: O(n) runtime, O(n) space. One simple approach is: Split the string by spaces into an
array of words, then to extract the words in reversed order.
*/
// input: " 1" ---> [0] = ""(空字符串), [1] = 1
// input: " "  ---> array.length = 0
// 注意空串和空格串的区别
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        String[] array = s.split(" ");
        StringBuilder reversed = new StringBuilder();
        
        for(int i = array.length - 1; i >= 0; i--){
            if(!array[i].equals("")){
                reversed.append(array[i]).append(" ");
            }
        }
        
        return reversed.length() == 0 ? "" : reversed.substring(0, reversed.length() - 1);
    }
}
