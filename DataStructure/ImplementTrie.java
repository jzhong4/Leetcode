/*
 Author:     Junjie
 Date:       Aug 18, 2017
 Problem:    Implement Trie
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/implement-trie/
 Implement a trie with insert, search, and startsWith methods.
 Notice
 You may assume that all inputs are consist of lowercase letters a-z.
 Example
 insert("lintcode")
 search("code")
 >>> false
 startsWith("lint")
 >>> true
 startsWith("linterror")
 >>> false
 insert("linterror")
 search("lintcode)
 >>> true
 startsWith("linterror")
 >>> true
*/
/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean hasWord;
    
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        hasWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if(!now.children.containsKey(c)){
                now.children.put(c, new TrieNode());
            }
            now = now.children.get(c);
        }
        now.hasWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if(!now.children.containsKey(c)){
                return false;
            }
            now = now.children.get(c);
        }
        return now.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        for(int i = 0; i < prefix.length(); i++){
            Character c = prefix.charAt(i);
            if(!now.children.containsKey(c)){
                return false;
            }
            now = now.children.get(c);
        }
        return true;
    }
}