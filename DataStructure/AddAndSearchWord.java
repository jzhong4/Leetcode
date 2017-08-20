/*
 Author:     Junjie
 Date:       Aug 19, 2017
 Problem:    Add and Search Word
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/add-and-search-word/
 Design a data structure that supports the following two operations: addWord(word) and search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or ..
 A . means it can represent any one letter.
 Notice
 You may assume that all words are consist of lowercase letters a-z.
 Have you met this question in a real interview? Yes
 Example
 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad")  // return false
 search("bad")  // return true
 search(".ad")  // return true
 search("b..")  // return true 
 Solution: 递归去判断.的情况。考虑26个小写字母。
*/
class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean hasWord;
    
    public TrieNode(){
        children = new HashMap<Character, TrieNode>();
    }
    
}

public class WordDictionary {
    
    TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if(!now.children.containsKey(c)){
                now.children.put(c, new TrieNode());
            }
            now  = now.children.get(c);
        }
        now.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(root, 0, word);
    }
    
    private boolean find(TrieNode root, int index, String word){
        if(index == word.length()){
            return root.hasWord;
        }

        Character c = word.charAt(index);
        if(c == '.'){
            for(char i = 'a'; i <= 'z'; i++){
                if(root.children.containsKey(i)){
                    if(find(root.children.get(i), index + 1, word)){
                        return true;
                    }
                } 
            }
        }else if(root.children.containsKey(c)){
                    return find(root.children.get(c), index + 1, word);
        }else{
                  return false;
        } 
        return false;
    }
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");