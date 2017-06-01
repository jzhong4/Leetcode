/*
 Author:     Junjie
 Date:       June 1, 2017
 Problem:    Binary Tree Maximum Path Sum
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum/
 Given a binary tree, find the maximum path sum.
 Example
 Given the below binary tree:
   1
  / \
 2   3
 return 6.
 Solution: Divide and Conquer, Recursion
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
    //对于每个结点，需要维护以下两个变量
    private class ResultType {
        //singlePath: 从root只能往下走到任意点的最大路径，这条路径可以不包含任何点
        //maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int singlePathSum, maxPathSum;
        public ResultType(int singlePathSum, int maxPathSum){
            this.singlePathSum = singlePathSum;
            this.maxPathSum = maxPathSum;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root).maxPathSum;
    }
    
    private ResultType maxPathSumHelper(TreeNode root){
        if(root == null){
            return new ResultType(0, Integer.MIN_VALUE);
        }
        
        ResultType left = maxPathSumHelper(root.left);
        ResultType right = maxPathSumHelper(root.right);
        
        int singlePathSum = Math.max(left.singlePathSum, right.singlePathSum) + root.val;
        singlePathSum = Math.max(singlePathSum, 0);
        
        int maxPathSum = Math.max(left.maxPathSum, right.maxPathSum);
        maxPathSum = Math.max(maxPathSum, left.singlePathSum + right.singlePathSum + root.val);
        
        return new ResultType(singlePathSum, maxPathSum);
    }
}
