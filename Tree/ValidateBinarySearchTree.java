/*
 Author:     Junjie
 Date:       June 4, 2017
 Problem:    Validate Binary Search Tree
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/validate-binary-search-tree/
 Given a binary tree, determine if it is a valid binary search tree (BST).
 Assume a BST is defined as follows:
 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 A single node tree is a BST
 An example:
   2
  / \
 1   4
    / \
   3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
Solution: Divide and Conquer, Recursion, Stack
性质: 1) Binary Search Tree的inorder traversal是升序的 2）在Binary Search Tree中，如果左子树的最大值大于根，或者右子树德最小值小于根的话，那这就不是BST了
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
//Divide & Conquer
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    class ResultType {
        boolean isBST;
        int minValue, maxValue;
        ResultType(boolean isBST, int minValue, int maxValue){
            this.isBST = isBST;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }
    
    private ResultType isValidBSTHelper(TreeNode root){
        if (root == null){
            return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        ResultType left = isValidBSTHelper(root.left);
        ResultType right = isValidBSTHelper(root.right);
        
        if(!left.isBST || !right.isBST){
            return new ResultType(false, 0 , 0); 
        }
        
        if((root.left != null && left.maxValue >= root.val) || (root.right != null && right.minValue <= root.val)){
            return new ResultType(false, 0 , 0);
        }
        return new ResultType(true, Math.min(left.minValue, root.val), Math.max(right.maxValue, root.val));
    }
     
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root).isBST;
    }
}

// Stack solution
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        
        while (root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val >= root.val){
                return false;
            }
            pre = root;
            root = root.right;
            
        }
        return true;
    }
}
