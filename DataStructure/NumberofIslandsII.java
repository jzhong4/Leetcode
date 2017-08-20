/*
 Author:     Junjie
 Date:       Aug 18, 2017
 Problem:    Number of Islands II
 Difficulty: Hard
 Source:     未解锁
 A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 Example:
 Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 >represents land).
 0 0 0
 0 0 0
 0 0 0
 Operation #1: addLand(0, 0) turns the water at grid0 into a land.
 1 0 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #2: addLand(0, 1) turns the water at grid0 into a land.
 1 1 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #3: addLand(1, 2) turns the water at grid1 into a land.
 1 1 0
 0 0 1   Number of islands = 2
 0 0 0
 Operation #4: addLand(2, 1) turns the water at grid2 into a land.
 1 1 0
 0 0 1   Number of islands = 3
 0 1 0
 We return the result as an array: [1, 1, 2, 3]
 Solution: 查看操作位是否是岛，不是的话，变成岛， count+1多一个岛。然后查看周围可不可以合并。 时间复杂度：O（k）, k次操作
*/

class UnionFind(){
  private int[] father;

  private int find(int x){
     if(father[x] == x){
       return x;
     }
     return father[x] = find(father[x]);	
  }
  
  public UnionFind(int n){
     father = new int[n];
     for(int i = 0; i < n; i++){
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
  
  public boolean query(int a, int b){
     return find(a) == find(b);
  } 
}

public class Solution {

public List<Integer> numIslands2(int m, int n, int[][] positions) {
   List<Integer> ans = new ArrayList<Integer>();
   if(positions == null) return ans;

   int[] dx = {0, -1, 0, 1};
   int[] dy = {1, 0, -1, 0};
   int[][] island = new int[m][n];
   UnionFind uf = new UnionFind(m * n);
   int count = 0;

   for(int i = 0; i < positions.length; i++){
        int x = positions[i][0];
        int y = positions[i][1];
        int id = i * x + y;
	if(island[x][y] != 1){
          count++;
          island[x][y] = 1;
          for(int j = 0; j < 4; j++){
            int next_x = x + dx[j];
            int next_y = y + dy[j];
            int next_id = n * next_x + next_y;
            if(0 <= next_x && next_x < m && 0 <= next_y && next_y < n && island[next_x][next_y] == 1){
	       if(!uf.query(id, next_id)){
             	count—-;
                uf.union(id, next_id);
            }
	  }
        }
      }
       ans.add(count);
    }
   return ans;
 }
}