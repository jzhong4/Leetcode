/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //异常情况，尤其要想到m >= n时
        if(m >= n || head == null){
            return head;
        }
        //要有dummyNode，因为head会变
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;
        //走m - 1步，找到m和prem的位置
        for(int i = 1 ; i < m; i++){
            //如果没有m这个点，return null
            if(head == null){
                return null;
            }
            head = head.next;
        }
        
        ListNode premNode = head;
        ListNode mNode = head.next;
        //在reverseI中，nNode相当于prev，postNode相当于head
        ListNode nNode = mNode, postnNode = mNode.next;
        //不确定需要m = n时，使用简单代换
        for(int i = m; i < n; i++){
            //如果没有n这个点，return null
            if(postnNode == null){
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        //最后进行整合
        premNode.next = nNode;
        mNode.next = postnNode;
        
        return dummyNode.next;
    }
}
