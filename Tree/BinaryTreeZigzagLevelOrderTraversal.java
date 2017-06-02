/*
 Author:     Junjie
 Date:       June 2, 2017
 Problem:    Binary Tree Zigzag Level Order Traversal
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/binary-tree-zigzag-level-order-traversal/
 Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 Example
 Given binary tree {3,9,20,#,#,15,7},
 
   3
  / \
 9  20
   /  \
  15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ] 
 Solution: BFS, Two stacks to achieve the order
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
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return result;
        }
        
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> temp;
        
        boolean isNormalOrder = true;
        currLevel.push(root);
        
        while(!currLevel.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(!currLevel.isEmpty()){
                TreeNode head = currLevel.pop();
                level.add(head.val);
                if(isNormalOrder){
                    if(head.left != null){
                        nextLevel.push(head.left);
                    }
                    if(head.right != null){
                        nextLevel.push(head.right);
                    }
                }else{
                    if(head.right != null){
                        nextLevel.push(head.right);
                    }
                    if(head.left != null){
                        nextLevel.push(head.left);
                    }
                }
            }
            result.add(level);
            isNormalOrder = !isNormalOrder;
            temp = currLevel;
            currLevel = nextLevel;
            nextLevel = temp;
        }
        return result;
    }
}
