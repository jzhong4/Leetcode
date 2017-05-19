/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 将每个list的最前面节点放入一个priority queue (min heap)中。之后每从queue中取出一个节点，则将该节点在其list中的下一个节点插入，以此类推直到全部节点都经过priority queue。（关键要想到priorit queue这个数据结构，有放入，拿出，求最小的特性）
// 由于priority queue的大小为始终为k，而每次插入的复杂度是log k，一共插入过nk个节点。时间复杂度为O(nk logk)，空间复杂度为O(k)。
public class Solution {
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
    Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
    for(int i = 0; i < lists.length; i++){
        if(lists[i] != null){
            heap.add(lists[i]);
        }
    }
    
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while(!heap.isEmpty()){
        ListNode head = heap.poll();
        tail.next = head;
        tail = head;
        if(head.next != null){
            heap.add(head.next);
        }
    }
    return dummy.next;
    }
}