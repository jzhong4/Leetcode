/*
 Author:     Junjie
 Date:       Aug 18, 2017
 Problem:    Implement Trie
 Difficulty: Medium
 Source:     https://leetcode.com/problems/implement-trie-prefix-tree/description/
 Implement a trie with insert, search, and startsWith methods.
Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/
//Version 1: HashMap of TrieNode
class Trie {
    private TrieNode root;
    
    class TrieNode {
        private HashMap<Character, TrieNode> children;
        private boolean hasWord;
        
        public TrieNode(){
            children = new HashMap<Character, TrieNode>();
            hasWord = false;
        }
    }


    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children.get(c) == null){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.hasWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children.get(c) == null){
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.hasWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
             char c = prefix.charAt(i);
            if(cur.children.get(c) == null){
               return false;
            }
             cur = cur.children.get(c);
        }
        return true;
    }
}

//Version 2: Array of TrieNode
class Trie {
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
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos] == null){
               return false;
            }
            cur = cur.children[pos];
        }
        return cur.hasWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            int pos = prefix.charAt(i) - 'a';
            if(cur.children[pos] == null){
               return false;
            }
            cur = cur.children[pos];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */