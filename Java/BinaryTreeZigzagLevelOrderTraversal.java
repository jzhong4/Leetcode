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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }
        //画图可以看出需要两个Stack，控制正确地顺序输出
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        
        currLevel.push(root);
        boolean normalOrder = true;
        
        while(!currLevel.isEmpty()){
            List<Integer> currLevelResult = new ArrayList<Integer>();
            while(!currLevel.isEmpty()){
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);
                if(normalOrder){
                    if(node.left != null){
                    nextLevel.push(node.left); 
                    }
                    if(node.right != null){
                    nextLevel.push(node.right); 
                    }
                }else{
                    if(node.right != null){
                    nextLevel.push(node.right); 
                    }
                    if(node.left != null){
                    nextLevel.push(node.left); 
                    }
                }
            }
            
            result.add(currLevelResult);
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }
        return result;
    }
}