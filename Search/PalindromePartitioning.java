/*
 Author:     Junjie
 Date:       June 26, 2017
 Problem:    Palindrome Partitioning
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/palindrome-partitioning/
 Given a string s, partition s such that every substring of the partition is a palindrome.
 Return all possible palindrome partitioning of s.
 Example
 Given s = "aab", return:
 [
  ["aa","b"],
  ["a","a","b"]
 ]
 Solution: DFS, 搜索树，n个数，n - 1划分，要么划分，要么不划分，时间复杂度：O(2^n)
 */
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<List<String>>();
        if(s == null || s.length() == 0){
            return results;
        }
        partitionHelper(results, new ArrayList<String>(), s, 0);
        return results;
    }
    
    private void partitionHelper(List<List<String>> results, List<String> partition, String s, int startIndex){
        if(startIndex == s.length()){
            results.add(new ArrayList<String>(partition));
            return;
        }
        
        for(int i = startIndex; i < s.length(); i++){
            String subString = s.substring(startIndex, i + 1);
            if(!isPalindrome(subString)){
                continue;
            }
            partition.add(subString);
            partitionHelper(results, partition, s, i + 1);
            partition.remove(partition.size() - 1);
        }
        return;
    }
    
    private boolean isPalindrome(String s){
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;    
            }
        }
        return true;
    }
}

	