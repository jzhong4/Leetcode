/*
 Author:     Junjie
 Date:       August 11, 2017
 Problem:    Add Two Numbers
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/add-two-numbers/
 You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 Example
 Given 7->1->6 + 5->9->2. That is, 617 + 295.
 Return 2->1->9. That is 912.
 Given 3->1->5 and 5->9->2, return 8->0->8.
 Solution: Keep track of the carry using a variable and simulate digits-by-digits sum from the head of list, which contains the least-significant digit.  
 Take extra caution of the following cases:
 - When one list is longer than the other.
 - The sum could have an extra carry of one at the end, which is easy to forget. (e.g.,(9 -> 9) + (1) = (0 -> 0 -> 1))
*/
/**
 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        int carries = 0;
        while(l1 != null & l2 != null){
            int sum = l1.val + l2.val + carries;
            carries = sum / 10;
            dummyNode.next =  new ListNode(sum % 10);
            dummyNode = dummyNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int sum = l1.val + carries;
            carries = sum / 10;
            dummyNode.next = new ListNode(sum % 10);
            dummyNode = dummyNode.next;
            l1 = l1.next;
        }
        
        while(l2 != null){
            int sum = l2.val + carries;
            carries = sum / 10;
            dummyNode.next = new ListNode(sum % 10);
            dummyNode = dummyNode.next;
            l2 = l2.next;
        }
        
        if(carries == 1){
            dummyNode.next = new ListNode(1);
        }
        return head.next;
    }
}

// 小技巧处理，没有node的时候，值是0
/**
 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        int carry = 0;
        while( l1 != null || l2 != null){
            int x = (l1 != null)? l1.val : 0;
            int y = (l2 != null)? l2.val : 0;
            int sum = carry + x + y;
            dummyNode.next = new ListNode(sum % 10);
            dummyNode = dummyNode.next;
            carry = sum / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry == 1){
            dummyNode.next = new ListNode(1);
        }
        return head.next;
    }
}
