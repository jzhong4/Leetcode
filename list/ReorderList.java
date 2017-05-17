/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    //一个一个merge，不是比大小merge. 
    private void merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        int index = 0;
        while(head1 != null && head2 != null){
            // 0 % 2 == 0
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index ++;
        }
        if(head1 != null){
           dummy.next = head1; 
        }else{
           dummy.next = head2; 
        } 
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        
        merge(head, tail);
        
    }
}