/*
 Author:     Junjie
 Date:       May 7, 2018
 Problem:    Surrounded Regions
 Difficulty: Medium
 Source:     https://leetcode.com/problems/surrounded-regions/description/
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

Solution: 1）last one is dummy, all outer O are connected to this dummy
	  2）判断没有跟外圈O联通的O就要变成X
*/
class Solution {
    class UnionFind {
        private int[] father;
        
        public UnionFind(int n){
            father = new int[n + 1];
            for(int i = 0; i <= n; i++){
                father[i] = i;
            }
        }
        
        public void union(int a, int b){
            int root_a = find(a);
            int root_b = find(b);
            if(root_a != root_b){
                father[root_a] = root_b;
            }
        }
        
        public int find(int x){
            if(father[x] == x){
                return x;
            }
            return father[x] = find(father[x]);
        }
        
        public boolean query(int a, int b){
            return find(a) == find(b); 
        }
        
    }
    
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0){
            return;
        }
        
        int n = board[0].length;
        if(n == 0){
            return;
        }
        
        UnionFind uf = new UnionFind(m * n);
        int dummyNode = m * n;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                        uf.union(i * n + j, dummyNode);
                    }else{
                        if(board[i - 1][j] == 'O'){ uf.union(i * n + j, (i - 1) * n + j); }
                        if(board[i][j - 1] == 'O'){ uf.union(i * n + j, i * n + (j - 1)); }
                        if(board[i + 1][j] == 'O'){ uf.union(i * n + j, (i + 1) * n + j); }
                        if(board[i][j + 1] == 'O'){ uf.union(i * n + j, i * n + (j + 1)); }
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!uf.query(i * n + j, dummyNode)){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}