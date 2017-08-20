/*
 Author:     Junjie
 Date:       Aug 15, 2017
 Problem:    Kth Smallest Number in Sorted Matrix
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/kth-smallest-number-in-sorted-matrix/
 Find the kth smallest number in at row and column sorted matrix.
 Example
 Given k = 4 and a matrix: 
 [
   [1 ,5 ,7],
   [3 ,7 ,8],
   [4 ,8 ,9],
 ]
 return 5
 Solution1: 整个矩阵排序，时间复杂度O(nmlognm)
 Solution2: row，column都升序，所以最小左上角，然后下面的或者是右边的数。这样会想到维持一个最小集合，就是priorityqueue，最小堆。建立一个Pair Class，维护当前位置x， y， 和 value。
 小技巧，建立方向矩阵(向右向下)，int[] dx = new int[]{0, 1};
                           int[] dy = new int[]{1, 0};
 时间复杂度O(klogk),空间复杂度O(nm)
*/
class Pair {
    int x, y, val;
    public Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class PariComparator implements Comparator<Pair>{
    public int compare(Pair x, Pair y){
                return x.val - y.val;
            } 
}


public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        int m = matrix.length, n = matrix[0].length;
        boolean[][] hash = new boolean[m][n];//记住是否已经访问过
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new PariComparator());
        minHeap.add(new Pair(0, 0, matrix[0][0]));
        
        for(int i = 1; i < k; i++){ //k-1次，最后peek第k元素
            Pair cur = minHeap.poll();
            for(int j = 0; j < 2; j++){
                int next_x = cur.x + dx[j];
                int next_y = cur.y + dy[j];
                if(next_x < m && next_y < n && !hash[next_x][next_y]){
                    Pair newPair = new Pair(next_x, next_y, matrix[next_x][next_y]);
                    hash[next_x][next_y] = true;
                    minHeap.add(newPair);
                }
            }
        }
        return minHeap.peek().val;
    }
}
