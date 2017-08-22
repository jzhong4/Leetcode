/*
 Author:     Junjie
 Date:       Aug 21, 2017
 Problem:    Container With Most Water
 Difficulty: Medium
 Source:     https://leetcode.com/problems/container-with-most-water/description/
 Solution:   1. 两重循环，i：0 -> n, j：i + 1 -> n O(n^2)
             2. 容积有最外两个决定，h * l 限制，所以任何往里面走的时候，都要比较最外面的大小，移动小的往里面走，直到找到大的。O（n）
*/
class Solution {
    private int computeArea(int left, int right, int[] height){
        return (right - left) * Math.min(height[left], height[right]);
    }
    
    public int maxArea(int[] height) {
        int left = 0, ans = 0;
        int right = height.length - 1;
        while(left < right){
            ans = Math.max(ans, computeArea(left, right, height));
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}