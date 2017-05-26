/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //因为head也能被删除，所以要dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(head.next != null && head.next.next != null){
            if(head.next.val == head.next.next.val){
                //用while删除此段全部相等的值
                int value = head.next.val;
                while(head.next != null && head.next.val == value){
                    head.next = head.next.next;
                }
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }
}
