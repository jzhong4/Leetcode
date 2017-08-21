/*
 Author:     Junjie
 Date:       Aug 19, 2017
 Problem:    Trapping Rain Water
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/trapping-rain-water/
 Solution:   左右两边作为基准，往中间找，直到找到比自身大的。然后继续从小的开始移动。计算每个区间能trapping的water。
*/
public class Solution {
    /*
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        int left = 0, right = heights.length - 1;
        int leftHeight = heights[left], rightHeight = heights[right];
        int res = 0;
        while(left < right){
            if(leftHeight < rightHeight){
                left++;
                if(leftHeight > heights[left]){
                    res += leftHeight - heights[left];
                }else{
                    leftHeight = heights[left];
                }
            }else{
                right--;
                if(rightHeight > heights[right]){
                    res += rightHeight - heights[right];
                }else{
                    rightHeight = heights[right];
                }
            }
        }
        return res;
    }
};