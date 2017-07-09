/*
 Author:     Junjie
 Date:       July 08, 2017
 Problem:    Trailing Zeros
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/trailing-zeros/
 Write an algorithm which computes the number of trailing zeros in n factorial.
 Example
 11! = 39916800, so the out should be 2
*/
class Solution {
    /*
     * param n: An desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long sum = 0;
        while(n != 0){
            sum += n / 5;
            n = n / 5;
        }
        return sum;
    }
};
