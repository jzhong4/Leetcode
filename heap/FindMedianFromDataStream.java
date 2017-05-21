public class MedianFinder {
    private PriorityQueue<Integer> minheap, maxheap;
    
    /** initialize your data structure here. */
    //建立最小和最大priorityqueue
    public MedianFinder() {
        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minheap = new PriorityQueue<Integer>();
    }
    
    //关键在于维持maxheap 和 minheap，保证maxheap的数量总是大于等于minheap的数量。并且要maxheap最大的，导出到minheap，然后不满足条件，再minheap最小，导出到maxheap。时间复杂度O(nlogn）。
    public void addNum(int num)
    maxheap.add(num);
    minheap.add(maxheap.poll());
    if (maxheap.size() < minheap.size()) {
        maxheap.add(minheap.poll());
    }
}

public double findMedian() {
if (maxheap.size() == minheap.size()) {
return (maxheap.peek() + minheap.peek()) * 0.5;
} else {
return maxheap.peek();
}
}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
