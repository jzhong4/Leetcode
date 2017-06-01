/*
 Author:     Junjie
 Date:       June 1, 2017
 Problem:    Minimum Depth of Binary Tree
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/minimum-depth-of-binary-tree/
 Given a binary tree, find its minimum depth.
 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 Example
 Given a binary tree as follow:

   1
  / \ 
 2   3
    / \
   4   5
 The minimum depth is 2.
 Solution: Divide and Conquer, Recursion, 
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
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int minLeftDepth = minDepth(root.left);
        int minRightDepth = minDepth(root.right);
        
        return (minLeftDepth == 0 || minRightDepth == 0)? minLeftDepth + minRightDepth + 1 : Math.min(minLeftDepth, minRightDepth) + 1;
    }
}