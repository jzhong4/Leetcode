/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode dummyNode = new ListNode(0);
//         ListNode head = dummyNode;
//         int carry = 0;
//         while(l1 != null && l2 != null){
//             int sum = l1.val + l2.val + carry;
//             carry = sum / 10;
//             head.next = new ListNode(sum % 10);
//             head = head.next;
//             l1 = l1.next;
//             l2 = l2.next;
//         }
//         while(l1 != null){
//             if(carry == 0){
//                 head.next = l1;
//                 break;
//             }
//             int sum = l1.val + carry;
//             carry = sum / 10;
//             head.next = new ListNode(sum % 10);
//             head = head.next; 
//             l1 = l1.next;
//         }
//         while(l2 != null){
//              if(carry == 0){
//                 head.next = l2;
//                 break;
//             }
//             int sum = l2.val + carry;
//             carry = sum / 10;
//             head.next = new ListNode(sum % 10);
//             head = head.next; 
//             l2 = l2.next;
//         }
//         if(carry == 1){
//             head.next = new ListNode(1);
//         }
//         return dummyNode.next;
//     }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null? 0 : l1.val;
            int y = l2 == null? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            head.next = new ListNode(sum % 10);
            head = head.next; 
            l1 = l1 != null? l1.next : null;
            l2 = l2 != null? l2.next : null;
        }
        if(carry > 0){
            head.next = new ListNode(1); 
        }
        return dummyNode.next;
    }
}