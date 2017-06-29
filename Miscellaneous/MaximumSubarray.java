/*
 Author:     Junjie
 Date:       June 28, 2017
 Problem:    Maximum Subarray
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/maximum-subarray/
 Given an array of integers, find a contiguous subarray which has the largest sum.
 Notice
 The subarray should contain at least one number.
 Example
 Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 Solution: prefix sum sum[i, j] = sum[j] - sum[i]
*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int sum = 0, minSum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}