/*
 Author:     Junjie
 Date:       June 29, 2017
 Problem:    3Sum
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/3sum/
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 Notice
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 Example
 For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
*/
public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length < 3){
            return results;
        }
        
        Arrays.sort(numbers);
        for(int i = 0 ; i < numbers.length - 2; i++){
            if (i > 0 && numbers[i] == numbers[i - 1]){
                continue;    
            }
            int left = i + 1, right = numbers.length - 1;
            int target = -numbers[i];
            twoSum(numbers, left, right, target, results);
        }
        return results;
    }
    
    private void twoSum(int[] nums,
                       int left,
                       int right,
                       int target,
                       ArrayList<ArrayList<Integer>> results){
        while(left < right){
            if(nums[left] + nums[right] == target){
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                results.add(triple);
            
                left++;
                right--;
            
                while(left < right && nums[left] == nums[left - 1]){
                    left++;
                }
            
                while(left < right && nums[right] == nums[right + 1]){
                    right--;
                }
            }else if(nums[left] + nums[right] < target){
                left++;
            }else{
                right--;
            }
        }                   
    }
}