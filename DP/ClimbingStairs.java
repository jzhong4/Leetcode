/*
 Author:     Junjie
 Date:       June 13, 2017
 Problem:    Climbing Stairs
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/climbing-stairs
 You are climbing a stair case. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 Example
 Given an example n=3 , 1+1+1=2+1=1+2=3
 return 3
*/
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        
        for(int i = 2; i <= n; i++){
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }
}