/*
 Author:     Junjie
 Date:       June 2, 2017
 Problem:    Binary Tree Level Order Traversal
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/binary-tree-level-order-traversal/
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 Example
 Given binary tree {3,9,20,#,#,15,7},
 
   3
  / \
 9  20
   /  \
  15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ] 
 Solution: BFS, Queue
 时间复杂度：O(N), 空间复杂度：O(N)
 */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                level.add(head.val);
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
                
            }
            result.add(level);
        }
        return result;
    }
}
