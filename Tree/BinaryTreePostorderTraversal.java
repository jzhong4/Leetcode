/*
 Author:     Junjie
 Date:       May 31, 2017
 Problem:    Binary Tree Postorder Traversal
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/binary-tree-postorder-traversal/#
 Given a binary tree, return the postorder traversal of its nodes' values.
 Example
 Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

 return [3,2,1].
 Solution: Divide and Conquer, Recursion
 时间复杂度: O(n), n为树里面node的总数
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        
        ArrayList<Integer> left  = postorderTraversal(root.left);
        ArrayList<Integer> right  = postorderTraversal(root.right);
        
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
    }
}