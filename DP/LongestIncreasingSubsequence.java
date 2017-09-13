/*
 Author:     Junjie
 Date:       June 14, 2017
 Problem:    Longest Increasing Subsequence
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/longest-increasing-subsequence/
 Given a sequence of integers, find the longest increasing subsequence (LIS).
 You code should return the length of the LIS.
 Clarification
 What's the definition of longest increasing subsequence?
 The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
 https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 Example
 For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
 For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4
*/
// f[i]表示前i个数字中以第i个结尾的LIS的长度 f[i] = Math.max(f[j] + 1, f[i])。每一点都需要存储当前最大值。
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int[] f = new int[nums.length];
        int max = Integer.MIN_VALUE; // 如果max = 0，就无需考虑corner case
        for(int i = 0; i < nums.length; i++){
            f[i] = 1;
            for(int j = 0; j < i; j++){
            if(nums[j] < nums[i]){
                f[i] = Math.max(f[j] + 1, f[i]);
            }    
        }
            max = Math.max(f[i], max);
        }
    return max;
    }
}
