/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        Queue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                return Integer.compare(node1.val, node2.val);
            }
        });
        
        for(ListNode node : lists){
            if(node != null){
                minHeap.add(node);  
            }
        }

        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        while(!minHeap.isEmpty()){
            head.next = minHeap.poll();
            head = head.next;
            if(head.next != null){
               minHeap.add(head.next); 
            }
        }
        return dummyNode.next;
    }
}