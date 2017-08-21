/*
 Author:     Junjie
 Date:       Aug 20, 2017
 Problem:    Find Median from Data Stream
 Difficulty: Hard
 Source:     https://leetcode.com/problems/find-median-from-data-stream/description/
 Solution:   维持两个堆。最大堆 x + 1 或者 x个，最小堆 x个。并且要保证最大堆的元素，均小于最小堆的元素。多的一个就是median，或者相等时，两元素相加除以2。时间复杂度O(nlogn)
*/
public class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap;

    public MedianFinder() {
       minHeap = new PriorityQueue<Integer>();
       maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
            return maxHeap.peek();
        }
    } 
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */