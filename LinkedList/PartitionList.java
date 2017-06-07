/*
 Author:     Junjie
 Date:       June 6, 2017
 Problem:    Partition List
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/partition-list/
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 You should preserve the original relative order of the nodes in each of the two partitions.
 Example
 Given 1->4->3->2->5->2->null and x = 3,
 return 1->2->2->4->3->5->null.
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
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return head;
        }
        
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        
        while (head !=  null){
            if (head.val < x){
                left.next = head;
                left = left.next;
            }else{
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        
        left.next = rightDummy.next;
        right.next = null;
        return leftDummy.next;
    }
}
