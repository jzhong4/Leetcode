/*
 Author:     Junjie
 Date:       June 6, 2017
 Problem:    Remove Duplicates from Sorted List
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list
 Given a sorted linked list, delete all duplicates such that each element appear only once.
 Example
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 Solution: 一根指针扫描，删除重复，否则查看下一个数。
*/
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        if (head == null){
            return head;
        }
        
        ListNode node = head;
        while(node.next != null){
            if (node.val == node.next.val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return head;
    }  
}