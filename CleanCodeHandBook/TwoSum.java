/*
 Author:     Junjie
 Date:       June 29, 2017
 Problem:    Two Sum
 Difficulty: Easy
 Source:     https://leetcode.com/problems/two-sum/#/description
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 Example:
 Given nums = [2, 7, 11, 15], target = 9,
 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1]. 
 Solution: Hashmap存数值和index, O(n) runtime, O(n) space
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            if(map.containsKey(target - temp)){
                return new int[]{map.get(target - temp), i};
            }
            map.put(temp, i);
        }
        return null;
    }
}

Follow up:
What if the given input is already sorted in ascending order?
1) Binary Search: For each element x, we could look up if target – x exists in O(log n) time by applying
binary search over the sorted array. Total runtime complexity is O(n log n), O(1) space

2) Two pointers: O(n)runtime, O(1)space

