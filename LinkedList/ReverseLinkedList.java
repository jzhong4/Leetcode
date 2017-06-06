/*
 Author:     Junjie
 Date:       June 6, 2017
 Problem:    Reverse Linked List
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/reverse-linked-list/
 Reverse a linked list.
 Example
 For linked list 1->2->3, the reversed linked list is 3->2->1
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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
