package list;

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
public class DeleteDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        while(l2 != null){
            if(l1.val == l2.val){
                l2 = l2.next;
                l1.next = l2;
            }else{
                l1 = l2;
                l2 = l2.next;
            }
        }
       return head; 
    }
}
