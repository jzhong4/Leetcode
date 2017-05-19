/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // 如果用找中点，左右分治的方法，会时间复杂度O(nlogn). 这个方法时间复杂度O(n).
public class Solution {
    ListNode current;
    
    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }
    
    //以current为首，接下来size大小进行扫描
    private TreeNode sortedListToBSTHelper(int size){
        if(size <= 0){
            return null;
        }
        
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - size /2 - 1);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int size;
        
        current = head;
        size = getListLength(head);
        
        return sortedListToBSTHelper(size);
        
    }
}