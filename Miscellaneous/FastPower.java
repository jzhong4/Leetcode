/*
 Author:     Junjie
 Date:       July 03, 2017
 Problem:    Fast Power
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/fast-power/
 Calculate the an % b where a, b and n are all 32bit integers.
 Example
 For 231 % 3 = 2
 For 1001000 % 1000 = 0 
 Solution: 时间复杂度 O(logn)
*/
class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        if(n == 1){
            return a % b;
        }
        
        if(n == 0){
            return 1 % b;
        }
        
        long product = fastPower(a, b, n/2);
        product = (product * product) % b;
        if(n % 2 == 1){
            product = (product * a) % b;
        }
        return (int)product;
    }
};