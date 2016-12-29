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
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode dummyNode1 = new ListNode(0);
		ListNode head1 = dummyNode1;
		ListNode dummyNode2 = new ListNode(0);
		ListNode head2 = dummyNode2;

		while (head != null) {
			if (head.val < x) {
				head1.next = head;
				head1 = head;
			} else {
				head2.next = head;
				head2 = head;
			}
			head = head.next;
		}
		head1.next = dummyNode2.next;
		head2.next = null;
		return dummyNode1.next;
	}
}
