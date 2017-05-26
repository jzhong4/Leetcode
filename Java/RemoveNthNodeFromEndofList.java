/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //一个快指针先走n步，然后两个指针同时走，直到一个为null。
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <= 0 || head == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode preDelete = dummy;
        for(int i = 0; i < n; i++){
            if(head == null){
                return null;
            }
            head = head.next;
        }
        
        while(head != null){
            preDelete = preDelete.next;
            head = head.next;
        }
        
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}