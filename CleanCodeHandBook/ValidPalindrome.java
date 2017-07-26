/*
 Author:     Junjie
 Date:       July 17, 2017
 Problem:    Valid Palindrome
 Difficulty: Easy
 Source:     https://leetcode.com/problems/valid-palindrome/#/description
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring  cases.
 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.
 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.
 For the purpose of this problem, we define empty string as valid palindrome.
 Solution: The idea is simple, have two pointers – one at the head while the other one at the tail. Move them towards each other until they meet while skipping non-alphanumeric characters. 两个CharacterAPI：1）isLetterOrDigit 2) toLowerCase. O(n) runtime, O(1) space:
*/
public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(i < j){
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }
}
