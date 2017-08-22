/*
 Author:     Junjie
 Date:       Aug 21, 2017
 Problem:    Minimum Size Subarray Sum
 Difficulty: Medium
 Source:     https://leetcode.com/problems/minimum-size-subarray-sum/description/
 Solution:   内层循环的j，不需要重新取，减去前面一个继续。O(2n)
*/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {     
        int n = nums.length;
        int j = 0, sum = 0;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            while(j < n && sum < s){
                sum += nums[j];
                j++;
            }
            if(sum >= s){
               result = Math.min(result, j - i);   
            }
            sum -= nums[i];
        }
 	//没找到的情况
        if(result == Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }
}