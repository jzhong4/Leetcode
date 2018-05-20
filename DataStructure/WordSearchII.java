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
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    private void search(char[][]board, int x, int y, TrieNode cur, List<String> results){
        if(cur.hasWord){
            //剔除结果里面已经有的情况
            if(!results.contains(cur.s)){
                results.add(cur.s);
            }
        }
        
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 0){
            return;
        }
        
        char temp = board[x][y];
        if(cur.children[temp - 'a'] != null){
            // mark已经访问过的点
            board[x][y] = 0;
            for(int i = 0; i < 4; i++){
                search(board, x + dx[i], y + dy[i], cur.children[temp - 'a'], results);
            }
        }
        board[x][y] = temp;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<String>();
        
        Trie trieTree = new Trie();
        for(int i = 0; i < words.length; i++){
            trieTree.insert(words[i]);
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                search(board, i, j, trieTree.root, results);
            }
        }
        return results;
    }
}

class Trie{
    TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos] == null){
                cur.children[pos] = new TrieNode();
            }
            cur= cur.children[pos];
        }
        cur.hasWord = true;
        cur.s = word;
    }
    
    public boolean search(String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos] == null){
                return false;
            }
            cur= cur.children[pos];
        }
        return cur.hasWord;
    } 
}

 class TrieNode {
        TrieNode[] children;
        boolean hasWord;
        String s;
        
        public TrieNode(){
            children = new TrieNode[26];
            hasWord = false;
            s = "";
        }
    }