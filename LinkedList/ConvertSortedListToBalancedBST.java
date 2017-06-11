/*
 Author:     Junjie
 Date:       June 11, 2017
 Problem:    Convert Sorted List to Balanced BST
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/convert-sorted-list-to-balanced-bst/
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 Example
                2
 1->2->3  =>   / \
              1   3
 Solution: 利用 BST inorder traversal, 时间复杂度 O(n)
*/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
    private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;
        while (head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        int size;
        size = getListLength(head);
        current = head;
        return sortedListToBSTHelper(size);
    }
    
    public TreeNode sortedListToBSTHelper(int size) {
         if (size == 0){
             return null;
         }
         
         TreeNode left = sortedListToBSTHelper(size / 2);
         TreeNode root = new TreeNode(current.val);
         current = current.next;
         TreeNode right = sortedListToBSTHelper(size - 1- size / 2);
         
         root.left = left;
         root.right = right;
         return root;
     }
}
