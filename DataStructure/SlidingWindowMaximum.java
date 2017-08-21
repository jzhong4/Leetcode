/*
 Author:     Junjie
 Date:       Aug 20, 2017
 Problem:    Sliding Window Maximum
 Difficulty: Hard
 Source:     https://leetcode.com/problems/sliding-window-maximum/description/
 Solution:   1）i: 0 -> n, j: i -> i + k O(nk)
             2) 如果用个hashheap来做的话 O(nlogk)
             3) 如果用stack 没法从bottom pop出来
             4） 所以会用Deque, Deque是递减。时间复杂度: O(n)
*/
class Solution {
    private void inDeque(Deque<Integer> deque, int num){
        while(!deque.isEmpty() && deque.peekLast() < num){
            deque.pollLast();
        }
        deque.offer(num);
    }
    
    private void outDeque(Deque<Integer> deque, int num){
        if(deque.peekFirst() == num){
            deque.pollFirst();
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = {};
        if(n == 0){
            return ans;
        }
        
        ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for(int i = 0; i < k - 1; i ++){
            inDeque(deque, nums[i]);
        }
        
        for(int i = k - 1; i < n; i++){
            inDeque(deque, nums[i]);
            ans[i - k + 1] = deque.peekFirst();
            outDeque(deque, nums[i - k + 1]);
        }
        return ans;
    }
}
