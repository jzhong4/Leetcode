/*
 Author:     Junjie
 Date:       August 11, 2017
 Problem:    Swap Nodes in Pairs
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/swap-nodes-in-pairs/
 Given a linked list, swap every two adjacent nodes and return its head.
 Example
 Given 1->2->3->4, you should return the list as 2->1->4->3. 
 Example Questions Candidate Might Ask: Q: What if the number of nodes in the linked list has only odd number of nodes? A: The last node should not be swapped.
 Solution: 为什么会想到dummyNode. To determine the new list’s head, you look at if the list contains two or more elements. Basically, these extra conditional statements could be avoided by inserting an extra node (also known as the dummy head) to the front of the list.      
 注意: If the next pair of nodes exists, we should record the current node before advancing to the next pair of nodes.   *结点的下个位置如何换的顺序很重要
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;
        while(head.next != null && head.next.next != null){
            ListNode n1 = head.next, n2 = head.next.next;
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            head = n1;
        }
        return dummyNode.next;
    }
}