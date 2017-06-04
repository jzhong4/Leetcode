/*
 Author:     Junjie
 Date:       June 4, 2017
 Problem:    Search Range in Binary Search Tree
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/search-range-in-binary-search-tree/
 Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.
 Example
 If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].

     20
    /  \
   8   22
  / \
 4   12
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
// Stack solution
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curt = root;
        
        while( curt!= null || !stack.isEmpty()){
            while( curt != null){
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            if (k1 <= curt.val && curt.val <= k2){
                result.add(curt.val);
            }
            curt = curt.right;
        }
        return result;
    }
}

// Recursion solution
public class Solution {
    private ArrayList<Integer> result;
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        result = new ArrayList<Integer>();
        searchRangeHelper(root, k1, k2);
        return result;
    }
    
    private void searchRangeHelper(TreeNode root, int k1, int k2){
        if(root == null){
            return;
        }
        
        if (root.val > k1){
          searchRangeHelper(root.left, k1, k2);  
        }
        
        if (root.val >= k1 && root.val <= k2){
            result.add(root.val);
        }
        
        if (root.val < k2){
          searchRangeHelper(root.right, k1, k2);
        }
    }
}