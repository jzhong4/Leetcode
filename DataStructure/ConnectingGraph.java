/*
 Author:     Junjie
 Date:       Aug 17, 2017
 Problem:    Connecting Graph
 Difficulty: Easy
 Source:     Lintcode 未解锁
 Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
 You need to support the following method:
 1. connect(a, b), add an edge to connect node a and node b.
 2. query(a, b), check if two nodes are connected
 Example
 5 // n = 5
 query(1, 2) return false
 connect(1, 2)
 query(1, 3) return false
 connect(2, 4)
 query(1, 4) return true
 Solution: 并查集
*/
public class ConnectingGraph { 
    
  private int[] father;
  
  private int find(int i){
     if(father[i] == 0){
        return i; 
     }
     return father[i] = find(father[i]);
  }

  public ConnectingGraph(int n){
    father = new int[n + 1];
    for(int i = 1; i <= n; i++){
       father[i] = 0;
    }
  }

  public void connect(int a, int b) {
     int root_a = find(a);
     int root_b = find(b);
     if(root_a != root_b){
     	father[root_a] = root_b;
     }
  }
  
  public boolean query(int a, int b) {
    return find(a) == find(b);
  }

}