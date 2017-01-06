package list;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}
		//防止全部转换
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		head = dummyNode;

		for (int i = 1; i < m; i++) {
			head = head.next;
		}
		//固定4个点
		ListNode premNode = head;
		ListNode mNode = head.next;
		ListNode nNode = mNode, postnNode = mNode.next;

		for (int i = m; i < n; i++) {
			ListNode temp = postnNode.next;
			postnNode.next = nNode;
			nNode = postnNode;
			postnNode = temp;
		}

		premNode.next = nNode;
		mNode.next = postnNode;

		return dummyNode.next;

	}
}
