/*
 Author:     Junjie
 Date:       June 27, 2017
 Problem:    Single Number
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/single-number
 Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
 Example
 Given [1,2,2,1,3,4,3], return 4
 Solution: 异或： 1.不进位加法 2.相同为0，不同为1
                 3.a ^ a = 0 4.a ^ b ^ c =  (a ^ b) ^ c = a ^ (b ^ c)
*/
public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        
        int result = 0;
        for(int i = 0; i < A.length; i++){
            result ^= A[i];
        }
        return result;
    }
}