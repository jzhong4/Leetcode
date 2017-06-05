/*
 Author:     Junjie
 Date:       June 4, 2017
 Problem:    Binary Search Tree Iterator
 Difficulty: Hard
 Source:     http://www.lintcode.com/en/problem/binary-search-tree-iterator/
 Design an iterator over a binary search tree with the following rules:
 .Elements are visited in ascending order (i.e. an in-order traversal)
 .next() and hasNext() queries run in O(1) time in average.
 Example
 For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

      10
    /    \
   1      11
    \       \
     6       12
 Solution: Stack, In order traversal BST
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */
public class BSTIterator {
    TreeNode next;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        next = root;
    }
    
    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !stack.isEmpty() || next != null;
    }
    
    //@return: return next node
    public TreeNode next() {
        while (next != null) {
            stack.push(next);
            next = next.left;
        }
        TreeNode cur = stack.pop();
        next = cur.right;
        return cur;
    }
}
