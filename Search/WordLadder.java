/*
 Author:     Junjie
 Date:       June 27, 2017
 Problem:    Word Ladder
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/word-ladder/
 Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 Notice
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 Example
 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5. 
 Solution: BFS, Queue 
*/
public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict){
        if(dict == null){ 
            return 0;
        }
        
        if(start.equals(end)){ 
            return 1;
        }
        
        dict.add(start);
        dict.add(end);
        
        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        hash.add(start);
        queue.offer(start);
        
        int length = 1;
        while(!queue.isEmpty()){
            length++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                for(String nextWord : getNextWords(word, dict)){
                    if(hash.contains(nextWord)){
                        continue;
                    }
                    
                    if(nextWord.equals(end)){
                        return length;
                    }
                    
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }
    
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}