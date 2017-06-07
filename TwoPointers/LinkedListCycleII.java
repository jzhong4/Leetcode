/*
 Author:     Junjie
 Date:       June 7, 2017
 Problem:    Linked List Cycle II
 Difficulty: Hard
 Source:     http://www.lintcode.com/en/problem/linked-list-cycle-ii/
 Given a linked list, return the node where the cycle begins.
 If there is no cycle, return null.
 Example
 Given -21->10->4->5, tail connects to node index 1，return 10 
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
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode slow = head, fast = head.next;
        
        while (fast != slow){
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        while (head != slow.next){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
