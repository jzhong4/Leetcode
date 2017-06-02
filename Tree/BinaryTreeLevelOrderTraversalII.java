/*
 Author:     Junjie
 Date:       June 2, 2017
 Problem:    Binary Tree Level Order Traversal II
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/binary-tree-level-order-traversal-ii/
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 Example
 Given binary tree {3,9,20,#,#,15,7},
 
   3
  / \
 9  20
   /  \
  15   7
 return its bottom-up level order traversal as:
 [
 [15, 7],
 [9,20],
 [3]
 ]
 Solution: BFS, Queue, add index into a list
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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
            result.add(0, level);
        }
        return result;
    }
}
