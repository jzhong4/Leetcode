/*
 Author:     Junjie
 Date:       Aug 20, 2017
 Problem:    Trapping Rain Water II
 Difficulty: Hard
 Source:     http://www.lintcode.com/en/problem/trapping-rain-water-ii/
 Solution:   1）外围一圈为基点
             2）从瓶颈最小出发向内灌水，维护最小堆。
             3）新放入堆的点，还是较大点用来巩固外墙。
             时间复杂度: nmlog(m + n)
*/
class Cell{
    int x, y, h;
    public Cell(int x, int y, int h){
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

class CellComparator implements Comparator<Cell>{
    public int compare(Cell c1, Cell c2){
        return c1.h - c2.h;
    }
}

public class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    /*
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Queue<Cell> minHeap = new PriorityQueue<Cell>(1, new CellComparator());
        int [][] visited = new int[m][n];
        
        for(int i = 0; i < m; i++){
            minHeap.add(new Cell(i, 0, heights[i][0]));
            minHeap.add(new Cell(i, n - 1, heights[i][n - 1]));
            visited[i][0] = 1;
            visited[i][n - 1] = 1;
        }
        
        for(int i = 0; i < n; i++){
            minHeap.add(new Cell(0, i, heights[0][i]));
            minHeap.add(new Cell(m - 1, i, heights[m - 1][i]));
            visited[0][i] = 1;
            visited[m - 1][i] = 1;
        }
        
        int ans = 0;
        while(!minHeap.isEmpty()){
            Cell cur = minHeap.poll();
            for(int i = 0; i < 4; i++){
                int next_x = cur.x + dx[i]; 
                int next_y = cur.y + dy[i];
                if(0 <= next_x && next_x < m && 0 <= next_y && next_y < n && visited[next_x][next_y] == 0){
                    visited[next_x][next_y] = 1;
                    minHeap.add(new Cell(next_x, next_y, Math.max(cur.h, heights[next_x][next_y])));
                    ans += Math.max(0, cur.h - heights[next_x][next_y]);
                }
            }
        }
        return ans;
    }
};
