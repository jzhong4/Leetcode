/*
 Author:     Junjie
 Date:       June 27, 2017
 Problem:    Majority Number II
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/majority-number-ii/
 Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.
 Find it.
 Notice
 There is only one majority number in the array.
 Example
 Given [1, 2, 1, 2, 1, 3, 3], return 1.
 Solution: 抵消
*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (candidate1 == nums.get(i)) {
                count1++;
            } else if (candidate2 == nums.get(i)) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums.get(i);
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (candidate1 == nums.get(i)) {
                count1++;
            } else if (candidate2 == nums.get(i)) {
                count2++;
            }
        }
        return count1 > count2? candidate1 : candidate2;
    }
}