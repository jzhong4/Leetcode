/*
 Author:     Junjie
 Date:       July 08, 2017
 Problem:    Sqrt(x)
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/sqrtx/
 Implement int sqrt(int x).
 Compute and return the square root of x.
 Example
 sqrt(3) = 1
 sqrt(4) = 2
 sqrt(5) = 2
 sqrt(10) = 3
 Solution: 二分法，时间复杂度 O(logn)，用除法约束条件，不然乘积会超过int
*/
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if(x == 0){
            return 0;
        } 
        int start = 1, end = x;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(mid == x / mid){
                return mid;
            }else if(mid < x / mid){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(end <= x / end){
            return end;
        }
        
        return start;
    }
}