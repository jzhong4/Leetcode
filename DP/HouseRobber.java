/*
 Author:     Junjie
 Date:       Aug 22, 2017
 Problem:    House Robber
 Difficulty: Easy
 Source:     https://leetcode.com/problems/house-robber/description/
 Solution:   序列性DP， 可以用滚动数组优化。
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] f = new int[n + 1]; 
        f[0] = 0;
        f[1] = nums[0];
        for(int i = 2; i <= n; i++){
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
        }
        return f[n];
    }
}

-----

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = nums[0];
        for(int i = 2; i <= n; i++){
            f[i % 2] = Math.max(f[(i - 1) % 2], f[(i - 2) % 2] + nums[i - 1]);
        }
        return f[n % 2];
    }
}
