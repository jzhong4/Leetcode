/*
 Author:     Junjie
 Date:       June 5, 2017
 Problem:    Remove Node in Binary Search Tree 
 Difficulty: Hard
 Source:     http://www.lintcode.com/en/problem/remove-node-in-binary-search-tree/
 Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
 Example
 Given binary search tree:

     5
    / \
   3   6
  / \
 2   4
 Remove 3, you can either return:

    5
   / \
  2   6
   \
    4
 or

     5
    / \
   4   6
  /
 2
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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
	//可能remove root
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        TreeNode parent = findParent(dummy, root, value); 
        TreeNode node = null;
	// find node to be removed
        if (parent.left != null && parent.left.val == value){
            node = parent.left;
        }else if (parent.right != null && parent.right.val == value){
            node = parent.right;
        }else{
           return dummy.left; 
        }
        
        deleteNode(parent, node);
        
        return dummy.left;
    }
    // find parent node
    private TreeNode findParent(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return parent;
        }
        
        if (value == node.val) {
            return parent;
        }
        
        if (value < node.val) {
            return findParent(node, node.left, value);
        }else{
            return findParent(node, node.right, value);
        }
    }
    // 找node左子树的最大值，或者右子树最小值，与node替换。此处找的是右子树最小值。
    private void deleteNode(TreeNode parent, TreeNode node){
	//node的右子树不存在
        if (node.right == null){
            if (parent.left == node){
                parent.left = node.left;
            }else{
                parent.right = node.left;
            }
        }else{
	    //node的右子树存在
            TreeNode temp = node.right;
            TreeNode father = node;
            //找以node的为根的右子树最小值
            while (temp.left != null){
                father = temp;
                temp = temp.left;
            }
    	    //最小值在右子树左边，或者右子树的根	
            if (father.left == temp){
               father.left = temp.right;
            }else{
               father.right = temp.right;
            }
            //parent指向最小值
            if (parent.left == node){
                parent.left = temp;
            }else{
                parent.right = temp;
            }
            //最小值的结点指向被替代的左右指向
            temp.left = node.left;
            temp.right = node.right;
        }
    }
}