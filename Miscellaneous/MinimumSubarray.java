/*
 Author:     Junjie
 Date:       June 28, 2017
 Problem:    Minimum Subarray
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/minimum-subarray/
 Given an array of integers, find the subarray with smallest sum.
 Return the sum of the subarray.
 Notice
 The subarray should contain one integer at least.
 Example
 For [1, -1, -2, 1], return -3.
 Solution: 与maximum subarray做法相似
*/
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
            return 0;
        }
        
        int sum = 0, maxSum = 0, minSub = Integer.MAX_VALUE;
        for(int i = 0; i < nums.size(); i++){
            sum += nums.get(i);
            minSub = Math.min(minSub, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
        }
        return minSub;
    }
}
