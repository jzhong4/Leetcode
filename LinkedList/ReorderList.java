/*
 Author:     Junjie
 Date:       June 6, 2017
 Problem:    Reorder List
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/reorder-list/
 Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln
 reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 Example
 Given 1->2->3->4->null, reorder it to 1->4->2->3->null. 
 Solution: find middle node, reverse list, merge two lists
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
     * @return: void
     */
    private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
    
    private void mergeList(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        boolean isNomralOrder = true;
        while( head1 != null && head2 != null){
            if (isNomralOrder){
                dummy.next = head1;
                head1 = head1.next;
            }else{
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            isNomralOrder = !isNomralOrder;
        }
        
        if (head1 != null){
            dummy.next = head1;
        }else{
            dummy.next = head2;
        }
    }
    
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        
        ListNode mid = findMiddle(head);
        ListNode tail = reverseList(mid.next);
        mid.next = null;
        mergeList(head, tail);
    }
}
