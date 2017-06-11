/*
 Author:     Junjie
 Date:       June 10, 2017
 Problem:    Merge k Sorted Lists
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/merge-k-sorted-lists/
 Merge k sorted linked lists and return it as one sorted list.
 Analyze and describe its complexity.
 Example
 Given lists:
 [
 2->4->null,
 null,
 -1->null
 ],
 return -1->2->4->null.
 */
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
// Heap solution: 将每个list的最前面节点放入一个priority queue (min heap)中。之后每从queue中取出一个节点，则将该节点在其list中的下一个节点插入，以此类推直到全部节点都经过priority queue。（关键要想到priorit queue这个数据结构，有放入，拿出，求最小的特性）
// 由于priority queue的大小为始终为k，而每次插入的复杂度是log k，一共插入过nk个节点。时间复杂度为O(nk logk)，空间复杂度为O(k)。
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0){
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                return node1.val - node2.val;
            }
        });
        
        for(int i = 0; i < lists.size(); i++){
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()){
            ListNode temp = heap.poll();
            tail.next = temp;
            tail = temp;
            if (temp.next != null){
                heap.add(temp.next);
            }
        }
        
        return dummy.next;
        
    }
}

// Divide & Conquer
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0){
            return null;
        }
        
        return mergeKListsHelper(lists, 0, lists.size() - 1);
    }
    
    private ListNode mergeKListsHelper(List<ListNode> lists, int start, int end){
        if (start == end){
            return lists.get(start);
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return mergeLists(left, right);
    }
    
    private ListNode mergeLists(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null){
            if (left.val < right.val){
                tail.next = left;
                left = left.next;
            }else{
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null){
            tail.next = left;
        }else{
            tail.next = right;
        }
        return dummy.next;
    }
}
