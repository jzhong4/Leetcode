/*
 Author:     Junjie
 Date:       Aug 20, 2017
 Problem:    The Skyline Problem
 Difficulty: Hard
 Source:     https://leetcode.com/problems/the-skyline-problem/description/
 Solution:   Sweep-Line - 扫描线问题，可以每次移动一个非常小的单位，不断去求当下楼房的高度。但实际上，只有某个楼房的开始或结尾才有交点的变化。
             第一步，拆分(1, 3, 3) => (1, 3, 起点) 和 (3, 3, 终点)，然后排序，关于排序，对于含有坐标，高度，始末标记的三元组。
             首先按坐标排序，不相等时，小到大
             坐标一样时，按高度排序。坐标是初始位时，大到小（同一点上只记录最高）。坐标是末尾时，小到大（不需要更新删除的较小点，因为重合的大点也会删除）
             高度也一样时，按始末排序，始 > 末。（加减抵消，重合继续）
             排序非常重要， 时间复杂度是O(nlogn)
             每次到交点的时候，要求几个楼房的高度最大值 - heapmax 与 当前比较
             每次到某一个楼房终点的时候要从堆中删除相应的高度 - HashHeap 时间复杂度是O(n^2)
             时间复杂度 O(nlogn) + O(n^2)  => O(n^2)
 */
拆分(1, 3, 3) => (1, 3, 起点) 和 (3, 3, 终点)，然后排序，关于排序，对于含有坐标，高度，始末标记的三元组
首先按坐标排序(大小排序)
坐标一样时，按高度排序(大小排序)
高度也一样时，按始末排序，始 > 末
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if(buildings == null || buildings.length == 0 || buildings[0] == null || buildings[0].length == 0){
            return res;
        }
        
        List<Edge> edges = new ArrayList<Edge>();
        for(int[] building : buildings){
            edges.add(new Edge(building[0], building[2], true));
            edges.add(new Edge(building[1], building[2], false));
        }
        Collections.sort(edges, new EdgeComparator());
        
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(1, Collections.reverseOrder());
        for(Edge edge : edges){
            if(edge.isStart){
                if(maxHeap.isEmpty() || edge.height > maxHeap.peek()){
                    res.add(new int[]{edge.pos, edge.height});
                }
                maxHeap.add(edge.height);
            }else{
                maxHeap.remove(edge.height);
                if (maxHeap.isEmpty() || edge.height > maxHeap.peek()) {
                    res.add(maxHeap.isEmpty() ? new int[]{edge.pos,0} : new int[]{edge.pos, maxHeap.peek()});
                }
            }
        }
        return res;
    }
    
    class Edge{
        int pos, height;
        boolean isStart;
        public Edge(int pos, int height, boolean isStart){
            this.pos = pos;
            this.height = height;
            this.isStart = isStart;
        }
    }
    
    class EdgeComparator implements Comparator<Edge>{
        public int compare(Edge l1, Edge l2){
            if(l1.pos != l2.pos){
                return Integer.compare(l1.pos, l2.pos);
            }
            if(l1.isStart && l2.isStart){
                return Integer.compare(l2.height, l1.height);
            }
            if(!l1.isStart && !l2.isStart){
                return Integer.compare(l1.height, l2.height);
            }
            return l1.isStart? -1 : 1;
        }
    }
}
