/*
 Author:     Junjie
 Date:       Aug 18, 2017
 Problem:    Word Search II
 Difficulty: Hard
 Source:     http://www.lintcode.com/en/problem/word-search-ii/
 Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position.
 Example
 Given matrix:
 doaf
 agai
 dcan
 and dictionary:
 {"dog", "dad", "dgdg", "can", "again"}
 
 return {"dog", "dad", "can", "again"}
 Solution: 把字典建成Trie树，用dfs方法遍历矩阵，查询Trie树上，所有可能出现的字符。
*/
class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean hasWord;
    String s;
    
    public TrieNode(){
        children = new HashMap<Character, TrieNode>();
        hasWord = false;
        s = "";
    }
}

class TrieTree{
    TrieNode root;
    
    public TrieTree(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++){
             Character c = word.charAt(i);
             if(!now.children.containsKey(c)){
                now.children.put(c, new TrieNode());
            }
             now = now.children.get(c);  
        }
        now.hasWord = true;
        now.s = word;
     }

    
    public boolean search(String word){
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
}

public class Solution {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    private void search(char[][] board, int x, int y, TrieNode root, ArrayList<String> result) {
        if(root.hasWord == true){
            if(!result.contains(root.s)){
             result.add(root.s);
            }
        }
        
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 0){
            return;
        }
        
        if(root.children.containsKey(board[x][y])){
            for(int i = 0; i < 4; i++){
                char now = board[x][y];
                // 同一个单词不能用两遍
                board[x][y] = 0;
                search(board, x + dx[i], y + dy[i], root.children.get(now), result);
                board[x][y] = now;
            } 
        }
    }
     
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<String>();
        TrieTree tree = new TrieTree();
        for(String word : words){
            tree.insert(word);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                search(board, i, j, tree.root, result);
            }
        }
        
        return result;
    }
}
