/*
 Author:     Junjie
 Date:       July 14, 2017
 Problem:    Sort Letters by Case
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/sort-letters-by-case/
 Given a string which contains only letters. Sort it by lower case first and upper case second.
 Notice
 It's NOT necessary to keep the original order of lower-case letters and upper case letters.
 Example
 For "abAcD", a reasonable answer is "acbAD"
*/
public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        int i = 0, j = chars.length - 1;
        char temp;
        while(i <= j){
            while(i <= j && Character.isLowerCase(chars[i])){
                i++;
            }
            while(i <= j && Character.isUpperCase(chars[j])){
                j--;
            }
            if(i <= j){
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return;
    }
}
