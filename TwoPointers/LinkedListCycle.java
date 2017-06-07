/*
 Author:     Junjie
 Date:       June 7, 2017
 Problem:    Linked List Cycle
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/linked-list-cycle/
 Given a linked list, determine if it has a cycle in it.
 Example
 Given -21->10->4->5, tail connects to node index 1, return true 
 Solution: 快慢指针，如果重合就有cycle
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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        
        ListNode slow = head, fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
