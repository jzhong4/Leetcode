
/*
 Author:     Junjie
 Date:       May 30, 2017
 Problem:    Binary Tree Preorder Traversal
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/#
 Given a binary tree, return the preorder traversal of its nodes' values.
 Example
 Given:

     1
    / \
   2   3
  / \
 4   5
 return [1,2,4,5,3]. 
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
     * @return: Preorder in ArrayList which contains node values.
     */
    //以root为根，对左子树preorder遍历，对右子树preorder遍历。
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    //以root为根，遍历树，并且同时保存
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}
