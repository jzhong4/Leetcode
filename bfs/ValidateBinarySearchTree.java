/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//solution1: divide & conquer
public class Solution {
    class ResultType {
        boolean is_bst;
        int maxValue, minValue;
    
    ResultType(boolean is_bst, int maxValue, int minValue) {
        this.is_bst = is_bst;
        this.maxValue = maxValue;
        this.minValue = minValue;
        }
    }  
    
    private ResultType validateHelper(TreeNode root) {
        if(root == null){
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);
        //左子树或者右子树不是二分查找树
        if(!left.is_bst || !right.is_bst){
            return new ResultType(false, 0, 0);
        }
        //左子树最大>=根 或者 右子树最小<=根，那么就不是二分查找树
        if( root.left != null && left.maxValue >= root.val|| root.right != null && right.minValue <= root.val){
            return new ResultType(false, 0, 0);
        }
        
        return new ResultType(true, Math.max(right.maxValue, root.val), Math.min(left.minValue, root.val));
    }
   

    public boolean isValidBST(TreeNode root) {
        ResultType r = validateHelper(root);
        return r.is_bst;
        
    }
}
// solution2: traverse，用到二分查找树的中序遍历是升序的特点
public class Solution {
    private boolean firstNode = true;
    private int lastValue = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        if(!isValidBST(root.left)){
            return false;
        }
        
        if(!firstNode && lastValue >= root.val){
            return false;
        }
        
        firstNode = false;
        lastValue = root.val;
        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }
}
