/*
 Author:     Junjie
 Date:       June 29, 2017
 Problem:    Subarray Sum Closest
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/subarray-sum-closest/
 Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
 Example
 Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]. 
 Solution: 求出每个位置的和，排序，两两相减，选出最小的差，返回它们的index
           举例:  1 2 3 4 -6
                 1 3 6 10 4
                 1 3 4 6 10
*/
public class Solution {
    class Pair{
        int sum;
        int index;
        Pair(int sum, int index){
            this.sum = sum;
            this.index = index;
        }
    }
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        } 
        
        int len = nums.length;
        if(len == 1) {
            res[0] = res[1] = 0;
            return res;
        }
        //前i个数的和
        Pair[] sums = new Pair[len + 1];
        sums[0] = new Pair(0, 0);
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(sums[i - 1].sum + nums[i - 1], i);
        }
        Arrays.sort(sums, new Comparator<Pair>() {
           public int compare(Pair a, Pair b) {
               return a.sum - b.sum;
           } 
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            if (ans > sums[i].sum - sums[i - 1].sum) {
                ans = sums[i].sum - sums[i - 1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }
        
        return res;
    }
}


