/*
 Author:     Junjie
 Date:       Aug 16, 2017
 Problem:    Kth Smallest Sum In Two Sorted Arrays
 Difficulty: Hard
 Source:     Lintcode 未解锁
 Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.
 Example
 Given [1, 7, 11] and [2, 4, 6].
 For k = 3, return 7.
 For k = 4, return 9.
 For k = 8, return 15. 
 Solution: 转化成kth smallest number in sorted matrix这个问题
 小技巧，建立方向矩阵(向右向下)，int[] dx = new int[]{0, 1};
                           int[] dy = new int[]{1, 0};
 时间复杂度O(klogk),空间复杂度O(nm)
*/
class Pair{
	int x, y, sum;
	public Pair(int x, int y, int sum){
		this.x = x;
		this.y = y;
		this.sum = sum;
	}
	
}

class PairComparator implements Comparator<Pair>{
	public int compare(Pair x, Pair y) {
		return x.sum - y.sum;
	}
}

public class Solution {
	/**
	 * @param A
	 *            an integer arrays sorted in ascending order
	 * @param B
	 *            an integer arrays sorted in ascending order
	 * @param k
	 *            an integer
	 * @return an integer
	 */
	public int kthSmallestSum(int[] A, int[] B, int k) {
		int m = A.length, n = B.length;
		int[] dx = {0, 1};
		int[] dy = {1, 0};
		boolean[][] hash = new boolean[m][n];
		Queue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
		minHeap.add(new Pair(0, 0, A[0] + B[0]));
		
		for(int i = 1; i < k; i++) {
			Pair cur = minHeap.poll();
			for(int j = 0; j < 2; j++) {
				int next_x = cur.x + dx[j];
				int next_y = cur.y + dy[j];
				if(next_x < m && next_y < n && !hash[next_x][next_y]) {
					hash[next_x][next_y] = true;
					minHeap.add(new Pair(next_x, next_y, A[ next_x] + B[next_y]));
				}
			}

		}
		return minHeap.peek().sum;
	}
}