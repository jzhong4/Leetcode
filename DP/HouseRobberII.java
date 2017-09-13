/*
 Author:     Junjie
 Date:       Aug 22, 2017
 Problem:    House Robber II
 Difficulty: Medium
 Source:     https://leetcode.com/problems/house-robber-ii/description/
 Solution:   序列性DP， 可以用滚动数组优化, 拆环
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(rob1(nums, 0, nums.length - 2), rob1(nums, 1, nums.length - 1));
    }
    
    private int rob1(int[] nums, int start, int end){
        int[] f = new int[2];
        if(start == end){
            return nums[start];
        }
        
        if(start + 1 == end){
            return Math.max(nums[start], nums[end]);
        }
        
        f[start % 2] = nums[start];
        f[(start + 1) % 2] = Math.max(nums[start], nums[start + 1]);
        
        for(int i = start + 2; i <= end; i++){
            f[i % 2] = Math.max(f[(i - 1) % 2] , f[(i - 2) % 2] + nums[i]);
        }
        return f[end % 2];
    }
}