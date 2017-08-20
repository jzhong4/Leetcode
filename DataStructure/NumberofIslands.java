/*
 Author:     Junjie
 Date:       Aug 17, 2017
 Problem:    Number of Islands
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/number-of-islands/
 Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 Find the number of islands.
 Example
 Given graph:

 [
   [1, 1, 0, 0, 0],
   [0, 1, 0, 0, 1],
   [0, 0, 0, 1, 1],
   [0, 0, 0, 0, 0],
   [0, 0, 0, 0, 1]
 ]
 return 3. 
 Solution: 考虑如何想到并查集上面，x = i * m + j(i行j列)，有多少1就有多少个count，相互链接后，count减一。
*/
class UnionFind { 
    
    private int[] father;
    private int count;
    
    private int find(int x){
        if(father[x] == 0){
            return x;
        }
        return father[x] = find(father[x]);
    }
    
    public UnionFind(int n){
        father = new int[n + 1];
        for(int i = 1; i <= n; i++){
            father[i] = 0;
        }
    }
    
    public void connect(int a, int b){
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            father[root_a] = root_b;
            count--;
        }
    }
    
    public void setCount(int count){
        this.count = count;
    }
    
    public int query(){
        return this.count;
    }
    
}


public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        int n = grid.length;
        if(n == 0){
            return 0;
        }
        int m = grid[0].length;
        if(m == 0){
            return 0;
        } 
        UnionFind unionFind = new UnionFind(m * n);
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]){
                    count++;
                }
            }
        }
        unionFind.setCount(count);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]){
                    if(i > 0 && grid[i - 1][j]){
                        unionFind.connect(i * m + j, (i - 1) * m + j);
                    }
                    if(j < m - 1 && grid[i][j + 1]){
                        unionFind.connect(i * m + j, i * m + (j + 1));
                    }
                    if(i < n - 1 && grid[i + 1][j]){
                        unionFind.connect(i * m + j, (i + 1) * m + j);
                    }
                    if(j > 0 && grid[i][j - 1]){
                        unionFind.connect(i * m + j, i * m + (j - 1));
                    }
                }
                
            }
        }
        return unionFind.query();
    }
}