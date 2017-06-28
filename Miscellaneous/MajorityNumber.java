/*
 Author:     Junjie
 Date:       June 27, 2017
 Problem:    Majority Number
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/majority-number
 Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.
 Notice
 You may assume that the array is non-empty and the majority number always exist in the array.
 Example
 Given [1, 1, 1, 1, 2, 2, 2], return 1 
 Solution: 抵消
*/
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int candidate =0, count = 0;
        for(int i = 0; i < nums.size(); i++){
            if(count == 0){
                candidate = nums.get(i);
                count = 1;
            }else if(candidate == nums.get(i)){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}