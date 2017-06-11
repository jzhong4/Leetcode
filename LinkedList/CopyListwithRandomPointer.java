/*
 Author:     Junjie
 Date:       June 10, 2017
 Problem:    Copy List with Random Pointer
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/copy-list-with-random-pointer
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 Return a deep copy of the list.
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 /*特别解法: 不用花费Hashmap的额外空间。第一遍扫的时候巧妙运用next指针， 开始数组是1->2->3->4  。 然后扫描过程中 先建立copy节点 1->1`->2->2`->3->3`->4->4`, 然后第二遍copy的时候去建立random的关系。最后拆分，第一个链表变回  1->2->3 , 然后第二变成 1`->2`->3`。但是Hashmap方法要回  */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
    
    private void copyNext(RandomListNode head){
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next= newNode;
            head = head.next.next;
        }
    }
    
    private void copyRandom(RandomListNode head){
        while (head != null) {
            if (head.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    private RandomListNode splitList(RandomListNode head){
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            //最后一个结点为空，然后跳出循环
            if ( head != null){
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }
}

// HashMap version: 有额外花费，O(n)时间扫描，最快只扫一遍就可以。map存放对应node和对应random node，每扫一个点，至多可以记住两组对应点。
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return head;
        }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode;
        
        while (head != null){
            if (map.containsKey(head)) {
                newNode = map.get(head);
            }else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;
            
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                }else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }
}
