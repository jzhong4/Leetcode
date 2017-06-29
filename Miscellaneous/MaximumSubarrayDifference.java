/*
 Author:     Junjie
 Date:       June 29, 2017
 Problem:    Maximum Subarray Difference
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/maximum-subarray-difference/
 Given an array with integers.
 Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
 Return the largest difference.
 Notice
 The subarray should contain at least one number
 Example
 For [1, 2, -3, 1], return 6. 
 Solution: 分割线，左边最大 - 右边最小，或者 左边最小 - 右边最大
*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        int size = nums.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        int[] leftMin = new int[size];
        int[] rightMin = new int[size];
        
        int sum = 0, minSum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            leftMax[i] = max;
        }
        
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for(int i = size - 1; i >= 0; i--){
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            rightMax[i] = max;
        }
        
        sum = 0;
        int maxSum = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++){
            sum += nums[i];
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(sum, maxSum);
            leftMin[i] = min;
        }
        
        sum = 0;
        maxSum = 0;
        min = Integer.MAX_VALUE;
        for(int i = size - 1; i >= 0; i--){
            sum += nums[i];
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(sum, maxSum);
            rightMin[i] = min;
        }
        
        int diff = 0;
        for(int i = 0; i < size - 1; i++){
            diff = Math.max(diff, Math.abs(leftMax[i] - rightMin[i + 1]));
            diff = Math.max(diff, Math.abs(leftMin[i] - rightMax[i + 1]));
        }
        return diff;
    }
}