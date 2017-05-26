/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//结合求BinaryTree的深度，定义：如果不是左右子树不是balanced tree，或者高度差大于1时，返回-1
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
        
    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        } 
        
        return Math.max(left, right) + 1;
    }
}