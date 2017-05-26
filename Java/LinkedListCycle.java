/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //如果用hashmap保存扫描会有额外空间，此方法记住即可，快慢指针同时跑。如果快指针跑完没有相遇，就不是个环。如果快慢指针相遇就是环。
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        // while与if的条件互换也能过
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            if(fast == slow){
               return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}