/*
 Author:     Junjie
 Date:       Aug 20, 2017
 Problem:    Sliding Window Median
 Difficulty: Hard
 Source:     https://leetcode.com/problems/sliding-window-median/description/
 Solution:   与findMedianFromDataStream相似，多加一个remove操作。时间复杂度O(nk)
*/
class Solution {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] medians = new double[n - k + 1];
        
        for(int i = 0; i < n; i++){
            addNum(nums[i]);
            if(i - k >= 0){
                removeNum(nums[i - k]);
            }
            if(i - k + 1 >= 0){
                medians[i - k + 1] = findMedian();
            }
        }
        return medians;
    }
    
    private void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    private void removeNum(int num){
        if(num <= maxHeap.peek()){
            maxHeap.remove(num);
        }else{
            minHeap.remove(num);
        }
        if (maxHeap.size() < minHeap.size()) {
	   maxHeap.add(minHeap.poll());
	} else if(maxHeap.size() - minHeap.size() > 1) {
	   minHeap.add(maxHeap.poll());
	}
    }
    
    private double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return ((double)maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
            return maxHeap.peek();
        }
    } 
}