/*
 Author:     Junjie
 Date:       June 1, 2017
 Problem:    Balanced Binary Tree
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/balanced-binary-tree/
 Given a binary tree, determine if it is height-balanced.
 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Example
 Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}
 
 A)  3            B)    3
    / \                  \
   9  20                 20
     /  \                / \
    15   7              15  7
 The binary tree A is a height-balanced binary tree, but B is not. 
 Solution: Divide and Conquer, Recursion, Max depth of a tree
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
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    //定义：如果不是左右子树不是balanced tree，或者高度差大于1时，返回-1; 否则返回此结点高度
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        
        if(leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1){
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
