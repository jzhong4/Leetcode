/*
 Author:     Junjie
 Date:       June 13, 2017
 Problem:    Jump Game 
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/jump-game/
 Given an array of non-negative integers, you are initially positioned at the first index of the array.
 Each element in the array represents your maximum jump length at that position.
 Determine if you are able to reach the last index.
 Notice
 This problem have two method which is Greedy and Dynamic Programming.
 The time complexity of Greedy method is O(n).
 The time complexity of Dynamic Programming method is O(n^2).
 We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.
 Example
 A = [2,3,1,1,4], return true.
 A = [3,2,1,0,4], return false.
*/
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        int num = A.length;
        if (A == null || num == 0){
            return false;
        }

        boolean[] canJump = new boolean[num];
        canJump[0] = true;
        
        for(int i = 1; i < num; i++){
            for(int j = 0; j < i; j++){
                if(canJump[j] && j + A[j] >= i){
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[num - 1];
    }
}