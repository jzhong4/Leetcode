/*
 Author:     Junjie
 Date:       July 28, 2017
 Problem:    String to Integer(atoi)
 Difficulty: Medium
 Source:     https://leetcode.com/problems/string-to-integer-atoi/tabs/description
 Implement atoi to convert a string to an integer.

 Solution: 
 The atoi function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
  The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function. 
 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, the maximum integer value (2147483647) or the minimum integer value (–2147483648) is returned.

 A desirable solution does not require any assumption on how the language works. In each step we are appending a digit to the number by doing a multiplication and addition. If the current number is greater than 214748364, we know it is going to overflow. On the other hand, if the current number is equal to 214748364, we know that it will overflow only when the current digit is greater than or equal to 8. Remember to also consider edge case for the smallest number, –2147483648 (–231).

 补充知识：1) Integer.MAX_VALUE = long max = 2147483647, Integer.MIN_VALUE = long min = –2147483648
         2) int 16位 范围: -32768 ~ +32767 (-2^n ~ 2^n - 1)
         3）long 32位 范围: -2,147,483,648 ~ 2,147,483,647
         4) 
*/
public class Solution {
    public int myAtoi(String str) {
        if(str == null){
            return 0;
        }
        
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        
        int index = 0, sign = 1;
        if(str.charAt(index) == '+'){
            index++;
        }else if(str.charAt(index) == '-'){
            sign = -1;
            index++;
        }
        
        long num = 0;
        for(; index < str.length(); index++){
            if(str.charAt(index) < '0' || str.charAt(index) > '9') break;
            num = num * 10 + (str.charAt(index) - '0');
            if(num > Integer.MAX_VALUE) break;
        }
        

        if(num * sign > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        
        if(num * sign < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return (int)num * sign;
    }
}