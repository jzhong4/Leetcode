/*
 Author:     Junjie
 Date:       Aug 22, 2017
 Problem:    Minimum Window Substring
 Difficulty: Hard
 Source:     https://leetcode.com/problems/minimum-window-substring/description/
 Solution:   前向型指针。（target字母可能重复）
*/
class Solution {
    private void initTargetHash(int[] targethash, String target){
        for(int i = 0; i < target.length(); i++){
            targethash[target.charAt(i)]++;
        }
    }
    
    private boolean valid(int[] targethash, int[] sourcehash){
        for(int i = 0; i < 256; i++){
            if(targethash[i] > sourcehash[i]){
                return false;
            }
        }
        return true;
    }
    
    public String minWindow(String s, String t) {
        int[] sourcehash = new int[256];
        int[] targethash = new int[256];
        int sourceLength = s.length(), j = 0;
        String result = "";
        int count = Integer.MAX_VALUE;
        
        initTargetHash(targethash, t);
        
        for(int i = 0; i < s.length(); i++){
            while(j < s.length() && !valid(targethash, sourcehash)){
                sourcehash[s.charAt(j)]++;
                j++; 
            }
	    // 剔除没有找到的可能
            if(valid(targethash, sourcehash)){
                if(count > (j - i)){
               count = Math.min(count, j - i); 
               result = s.substring(i, j); 
              }  
            }
            sourcehash[s.charAt(i)]--;
        }    
        return result;
    }
}