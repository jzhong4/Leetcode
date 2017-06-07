/*
 Author:     Junjie
 Date:       June 6, 2017
 Problem:    Sort List
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/sort-list/
 Sort a linked list in O(n log n) time using constant space complexity.
 Example
 Given 1->3->2->null, sort it to 1->2->3->null. 
 Solution: merge sort, recursion, time O(nlogn) and space O(1) complexity O(nlogn), find middle node, merge two lists
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
    //找终点，固定模板
    private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //merge固定写法，写成head1和head2，不要取名left， right，会引起歧义。
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(head1 != null && head2 != null){
           if(head1.val < head2.val){
               tail.next = head1;
               head1 = head1.next;
            }else{
               tail.next = head2;
               head2 = head2.next;
            }
            tail = tail.next;
        }
        if(head1 != null){
            tail.next = head1;
        }else{
            tail.next = head2;
        }
        return dummy.next;
    }
    //merge sort, merge sort在list中，不需要额外空间
    public ListNode sortList(ListNode head) {
        //注意退出条件
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        
        return merge(left, right);
    }
}
