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
 Solution: .考虑26个字母，循环判断是否在trie里面
*/
// Trie: hashmap implementation 
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

// Trie: array implementation
class WordDictionary {
    private TrieNode root;
    
    class TrieNode {     
        private TrieNode[] children;
        private boolean hasWord;
        
        public TrieNode(){
            children = new TrieNode[26];
            hasWord = false;
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos] == null){
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
        }
        cur.hasWord = true;
    }
    
    private boolean find(String word, int index, TrieNode cur){
        if(word.length() == index){
            return cur.hasWord;
        }
        
        Character c = word.charAt(index);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(cur.children[i] != null){
                    if(find(word, index + 1, cur.children[i])){
                        return true;
                    }
                }
            }
            return false;
        }else if(cur.children[c - 'a'] != null){
            return find(word, index + 1, cur.children[c - 'a']);
        }else{
           return false; 
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */