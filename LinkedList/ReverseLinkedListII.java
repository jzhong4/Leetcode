/*
 Author:     Junjie
 Date:       June 6, 2017
 Problem:    Reverse Linked List II
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/reverse-linked-list-ii
 Reverse a linked list from position m to n.
 Notice
 Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 Example
 Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if(head == null){
            return head;
        }
        //要有dummyNode，因为head会变
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        //走m - 1步，找到m和prem的位置
        for(int i = 1; i < m; i++){
            head = head.next;
        }
        
        ListNode premNode = head;
        ListNode mNode = head.next;
        //在reverseI中，nNode相当于prev，postNode相当于head
        ListNode nNode = mNode, postnNode = mNode.next;
        //不确定需要m = n时，使用简单代换
        for(int i = m; i < n; i++){
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        //最后进行整合
        premNode.next = nNode;
        mNode.next = postnNode;
        return dummy.next;
    }
}
