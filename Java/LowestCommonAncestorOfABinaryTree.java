/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	//root如果找到p或者q节点，返回p或者q,或者返回null
        if(root == null || root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
	//如果左右两边都不null，这个root即为最近公共祖先
        if(left != null && right != null){
            return root;
        }
        //如果左边不空，返回左边。右边不空，返回右边。要结合退出条件看。
        if(left != null){
            return left;
        }
        
        if(right != null){
            return right;
        }
        
        return null;
    }
}