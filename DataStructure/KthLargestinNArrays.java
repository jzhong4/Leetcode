/*
 Author:     Junjie
 Date:       Aug 16, 2017
 Problem:    Kth Largest in N Arrays
 Difficulty: Medium
 Source:     Lintcode 未解锁
 Find K-th largest element in N arrays.
 Notice
 You can swap elements in the array
 Example
 In n=2 arrays [[9,3,2,4,7],[1,2,3,4,8]], the 3rd largest element is 7.
 In n=2 arrays [[9,3,2,4,8],[1,2,3,4,2]], the 1st largest element is 9, 2nd largest element is 8, 3rd largest element is 7 and etc. 
 Solution: 假设N个数组，每个数组长M，把N个数组先排序，排序后把每个数组最大的数字，放入堆（维护N大的堆），pop k次得到答案。
 时间复杂度:O(nmlogm + klogn），m是平均每个数组的长度
*/
class Node {
	int val, from_id, index;

	public Node(int val, int from_id, int index) {
		this.val = val;
		this.from_id = from_id;
		this.index = index;
	}
}

public class Solution {

	public int KthInArrays(int[][] arrays, int k) {
		int n = arrays.length;
		Queue<Node> maxHeap = new PriorityQueue<Node>(n, new Comparator<Node>() {
			public int compare(Node node1, Node node2) {
				if(node1.val > node2.val) {
					return -1;
				}else if(node1.val < node2.val){
					return 1;
				}else {
					return 0;
				}
			}
		});
		
		for(int i = 0; i < n; i++) {
			Arrays.sort(arrays[i]);
			
			if(arrays[i].length > 0) {
				int from_id = i;
				int index = arrays[i].length - 1;
				int val = arrays[i][index];
				maxHeap.add(new Node(val, from_id, index));
			}
		}
		
		for(int i = 0; i < k; i++) {
			Node cur = maxHeap.poll();
			
			if(i == k - 1) {
				return cur.val;
			}
			
			if(cur.index > 0) {
				int from_id  = cur.from_id;
				int index = cur.index - 1;
				int val = arrays[from_id][index];
				maxHeap.add(new Node(val, from_id, index));
			}
		}
		return -1;
	}
}