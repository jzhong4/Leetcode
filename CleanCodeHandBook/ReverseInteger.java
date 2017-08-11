/*
 Author:     Junjie
 Date:       August 10, 2017
 Problem:    Reverse Integer
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/reverse-integer/
 Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).
 Example
 Given x = 123, return 321
 Given x = -123, return -321 
 可以问的问题？
 Q: What about negative integers? A: For input x = –123, you should return –321. Q: What if the integer’s last digit is 0? For example, x = 10, 100, … A: Ignore the leading 0 digits of the reversed integer. 10 and 100 are both reversed as 1. Q: What if the reversed integer overflows? For example, input x = 1000000003. A: In this case, your function should return 0.
 Solution: 1. 模10，除10
           2. We do not need to handle negative integers separately, because the modulus operator works for negative integers as well (e.g., –43 %10 = –3).
           3. 如何处理溢出问题？ 用long存储result，比Integer - MAX_VALUE大，就是溢出返回0.
*/
public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        long result = 0;
        while(n != 0){
            result = result * 10 + n % 10;
            n /= 10;
        }
        
        if(Math.abs(result) > Integer.MAX_VALUE){
            return 0;
        }
        return (int)result;
    }
}