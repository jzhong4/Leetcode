/*
 Author:     Junjie
 Date:       June 22, 2017
 Problem:    Clone Graph
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/clone-graph
 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 How we serialize an undirected graph:
 Nodes are labeled uniquely.
 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 The graph has a total of three nodes, and therefore contains three parts as separated by #.
 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:
    1
   / \
  /   \
 0 --- 2
      / \
      \_/
 Example
 return a deep copied graph. 
 Solution: BFS, 先克隆点，再克隆边
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return node;
        } 
        //ArrayList存放所有原始点，两次遍历这个ArrayList
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        //clone nodes
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        int start = 0;
        while(start < nodes.size()){
            UndirectedGraphNode head = nodes.get(start++);
            for(UndirectedGraphNode neighbor : head.neighbors){
                if(!map.containsKey(neighbor)){
                    nodes.add(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
        }
        
        // clone neighbors
        for(int i = 0; i < nodes.size(); i++){
            UndirectedGraphNode copyHead = map.get(nodes.get(i));
            for(UndirectedGraphNode neighbor : nodes.get(i).neighbors){
                copyHead.neighbors.add(map.get(neighbor));   
            }
        }
        return map.get(node);
    }
}