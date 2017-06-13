/*
 Author:     Junjie
 Date:       June 13, 2017
 Problem:    Jump Game II
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/jump-game-ii/
 Given an array of non-negative integers, you are initially positioned at the first index of the array.
 Each element in the array represents your maximum jump length at that position.
 Your goal is to reach the last index in the minimum number of jumps.
 Example
 Given array A = [2,3,1,1,4]
 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        int num = A.length;
        if (A == null || num == 0){
            return -1;
        }
        
        int[] minSteps = new int[num];
        minSteps[0] = 0;
        for(int i = 1; i < num; i++){
            minSteps[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(j + A[j] >= i){
                    minSteps[i] = Math.min(minSteps[j] + 1, minSteps[i]);
                }
            }
        }
        return minSteps[num - 1];
    }
}
