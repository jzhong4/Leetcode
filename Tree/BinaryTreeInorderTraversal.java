/*
 Author:     Junjie
 Date:       May 31, 2017
 Problem:    Binary Tree Inorder Traversal
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/binary-tree-inorder-traversal/#
 Given a binary tree, return the inorder traversal of its nodes' values.
 Example
 Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

 return [1,3,2].
 Solution: Divide and Conquer, Recursion, Stack
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        
        ArrayList<Integer> left = inorderTraversal(root.left);
        result.addAll(left);
        result.add(root.val);
        ArrayList<Integer> right = inorderTraversal(root.right);
        result.addAll(right);
        return result;
    }
}

// Stack解法
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
       
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}