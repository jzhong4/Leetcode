/*
 Author:     Junjie
 Date:       June 4, 2017
 Problem:    Insert Node in a Binary Search Tree
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/insert-node-in-a-binary-search-tree/
 Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.
 Notice
 You can assume there is no duplicate values in this tree + node.
 Example
 Given binary search tree as follow, after Insert node 6, the tree should be:

   2             2
  / \           / \
 1   4   -->   1   4
    /             / \ 
   3             3   6
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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if( root == null){
            root = node;
            return root;
        }

        TreeNode last = null;
        TreeNode temp = root;
        while (temp != null){
            last = temp;
            if(temp.val > node.val){
                temp = temp.left;
            }else{
                temp = temp.right;
            }    
        }
        
        if(last.val > node.val){
            last.left = node;
        }else{
            last.right = node;
        }
        return root;
    }
}