/*
 Author:     Junjie
 Date:       Aug 21, 2017
 Problem:    Kth Largest Element in an Array
 Difficulty: Medium
 Source:     https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 Solution:   1. 排序  O(nlogn)
             2. 堆    O(nlogk)
  	     3. 双指针 O（n）
*/
模板
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        if(k <= 0){
            return 0;
        }
        
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);//如果6个数，第1大，找第6个数
    }
    
    private int helper(int[] nums, int l, int r, int k){
        if(l == r){
            return nums[l];
        }
        
        int position = partition(nums, l , r);
        if(position + 1 == k){
            return nums[position];
        }else if(position + 1 < k){
            return helper(nums, position + 1, r, k);
        }else{
            return helper(nums, l, position - 1, k);
        }
    }
    
    private int partition(int[] nums, int l, int r){
        int left = l, right = r;
        int pivot = nums[left];
        
        // pivot, 左边小，右边大
        while(left < right){
            while(left < right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            
            while(left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        
        nums[left] = pivot;
        return left;
    }
}