/*
 Author:     Junjie
 Date:       May 6, 2018
 Problem:    Graph Valid Tree
 Difficulty: Medium
 Source:     https://leetcode.com/problems/graph-valid-tree/description/
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 
 For example:
 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 
 Solution:  tree should have n nodes with n-1 edges
 */
class Solution {
    class UnionFind{
        private int[] father;
        
        public UnionFind(int n){
            father = new int[n];
            for(int i = 0; i < n; i++){
                father[i] = i;
            }
        }
        
        public int find(int x){
            if(father[x] == x){
                return x;
            }
            return father[x] = find(father[x]);
        }
        
        public void connect(int a, int b){
            int root_a = find(a);
            int root_b = find(b);
            if(root_a != root_b){
                father[root_a] = root_b;
            }
        }
        
        public boolean query(int a, int b){
            return find(a) == find(b);
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        int m = edges.length; // 不需要判断后面为空，因为 n = 1，后面为空，也是棵树
        if(n - 1 != m){
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < m; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            if(uf.query(x, y)){
                return false;
            }
            uf.connect(x, y);
        }
        return true;
    }
}
