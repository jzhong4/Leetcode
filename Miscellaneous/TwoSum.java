/*
 Author:     Junjie
 Date:       June 29, 2017
 Problem:    Two Sum
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/two-sum/
 Given an array of integers, find two numbers such that they add up to a specific target number.
 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.
 Notice
 You may assume that each input would have exactly one solution
 Example
 numbers=[2, 7, 11, 15], target=9
return [1, 2] 
 Solution: Hashmap存数值和index
*/
public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int[] result = {};
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(numbers[i])){
                result = new int[]{map.get(numbers[i]) + 1, i + 1};
                return result;
            }
            map.put(target - numbers[i], i);
        }
        
        return result;
    }
}