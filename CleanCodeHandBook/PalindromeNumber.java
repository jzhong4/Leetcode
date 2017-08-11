/*
 Author:     Junjie
 Date:       August 10, 2017
 Problem:    Palindrome Number
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/palindrome-number/
 Check a positive number is a palindrome or not.
 A palindrome number is that if you reverse the whole number you will get exactly the same number.
 Notice
 It's guaranteed the input number is a 32-bit integer, but after reversion, the number may exceed the 32-bit integer.
 Example
 11, 121, 1, 12321 are palindrome numbers.
 23, 32, 1232 are not palindrome numbers.
 Solution: 1. reverse int，然后比较是否相等，但是会有溢出问题存在。（we could avoid overflow by storing and returning a type that has larger size than int (ie, long）
           2. First, compare the first and last digit. If they are not the same, it must not be a palindrome. If they are the same, chop off one digit from both ends and continue until you have no digits left, which you conclude that it must be a palindrome. More generic way.(完全通过取模，除以10运算可以得到某个位数)
*/
1.
public class Solution {
    /**
     * @param num a positive number
     * @return true if it's a palindrome or false
     */
    public boolean palindromeNumber(int num) {
        if(num < 0){
            return false;
        }
        return num == reverse(num);
    }
    
    private int reverse(int num){
        int result = 0;
        while(num != 0){
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }
}

2. 
public class Solution {
    /**
     * @param num a positive number
     * @return true if it's a palindrome or false
     */
    public boolean palindromeNumber(int num) {
        if(num < 0){
            return false;
        }
        
        int div = 1;
        while(num / div > 10){ //先求可以得到最高为的分母
            div = div * 10;
        }
        
        while(num / 10 != 0){
           int left = num / div; // 求最高位
           int right = num % 10; // 求最低位
           if(left != right) return false;
           num = (num % div) / 10; // chop off 两边
           div /= 100;  // 缩小分母
        }
        return true;
    }
}