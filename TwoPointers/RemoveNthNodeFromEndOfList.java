/*
 Author:     Junjie
 Date:       June 7, 2017
 Problem:    Remove Nth Node From End of List
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/remove-nth-node-from-end-of-list/
 Given a linked list, remove the nth node from the end of list and return its head.
 Notice
 The minimum number of nodes in list is n.
 Example
 Given linked list: 1->2->3->4->5->null, and n = 2.
 After removing the second node from the end, the linked list becomes 1->2->3->5->null.
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
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preDelete = dummy;
        
        for(int i = 1; i <= n; i++){
            head = head.next;
        }
        
        while (head != null){
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }