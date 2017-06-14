/*
 Author:     Junjie
 Date:       June 14, 2017
 Problem:    Word Break
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/word-break/
 Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.
 Example
 Given s = "lintcode", dict = ["lint", "code"].
 Return true because "lintcode" can be break as "lint code".
*/
// canBreak[i]能被切分成字典的词，一定能满足canBreak[j]能被切分成字典的词并且，j+1 ~ i也是字典的词。
public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0){
            return true;
        } 
        
        int maxLength = getMaxLength(dict);
        boolean[] canBreak = new boolean[s.length() + 1];
        
        canBreak[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++){
                if(!canBreak[i - lastWordLength]){
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if(dict.contains(word)){
                    canBreak[i] = true;
                    break;
                }
            }
        }
        
        return canBreak[s.length()];
    }
    
    private int getMaxLength(Set<String> dict){
        int maxLength = Integer.MIN_VALUE;
        for(String word : dict){
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}