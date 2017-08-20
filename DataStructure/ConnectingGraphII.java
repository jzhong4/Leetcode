/*
 Author:     Junjie
 Date:       Aug 17, 2017
 Problem:    Connecting Graph II
 Difficulty: Medium
 Source:     Lintcode 未解锁
 Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning. 
 You need to support the following method:
 1. connect(a, b), add an edge to connect node a and node b.
 2. query(a), Returns the number of connected component nodes which include node a.
 Example
 5 // n = 5
 query(1) return 1
 connect(1, 2)
 query(1) return 2
 connect(2, 4)
 query(1) return 3
 connect(1, 4)
 query(1) return 3 
 Solution: 并查集
*/
public class ConnectingGraph { 
    
  private int[] father;
  private int[] size;
  
  private int find(int i){
     if(father[i] == 0){
        return i; 
     }
     return father[i] = find(father[i]);
  }

  public ConnectingGraph(int n){
    father = new int[n + 1];
    size = new int[n + 1]
    for(int i = 1; i <= n; i++){
       father[i] = 0;
       size[i] = 1;
    }
  }

  public void connect(int a, int b) {
     int root_a = find(a);
     int root_b = find(b);
     if(root_a != root_b){
     	father[root_a] = root_b;
        size[root_b] += size[root_a];
     }
  }
  
  public int query(int a) {
    return size[find(a)];
  }

}