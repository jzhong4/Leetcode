/*
 Author:     Junjie
 Date:       June 22, 2017
 Problem:    Topological Sorting
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/topological-sorting
 Given an directed graph, a topological order of the graph nodes is defined as follow:
 For each directed edge A -> B in graph, A must before B in the order list.
 The first node in the order can be any node in the graph with no nodes direct to it.
 Find any topological order for the given graph.
 Notice
 You can assume that there is at least one topological order in the graph.
 Solution: BFS, 有向无环图才有拓扑排序
           1）计算非0入度的点的所有入度
           2）把所有入度为0的点都放入Queue
           3）bfs遍历neighbor，更新每个neighbor的入度，直到为0
*/
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(map.containsKey(neighbor)){
                    map.put(neighbor, map.get(neighbor) + 1);
                }else{
                    map.put(neighbor, 1);
                }
            }
        }
        // 这里用arraylist也可以
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for(DirectedGraphNode node : graph){
            if(!map.containsKey(node)){
                queue.offer(node);
                result.add(node);
            }
        }
        
        while(!queue.isEmpty()){
            DirectedGraphNode head = queue.poll();
            for(DirectedGraphNode neighbor : head.neighbors){
                map.put(neighbor, map.get(neighbor) - 1);
                if(map.get(neighbor) == 0){
                    queue.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }
        return result;
    }
}
