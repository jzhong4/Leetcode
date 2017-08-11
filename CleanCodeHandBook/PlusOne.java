/*
 Author:     Junjie
 Date:       August 10, 2017
 Problem:    Plus One
 Difficulty: Easy
 Source:     http://www.lintcode.com/en/problem/plus-one/
 Given a non-negative number represented as an array of digits, plus one to the number.
 The digits are stored such that the most significant digit is at the head of the list.
 Example
 Given [1,2,3] which represents 123, return [1,2,4].
 Given [9,9,9] which represents 999, return [1,0,0,0]. 
 
 Example Questions Candidate Might Ask:
 Q: Could the number be negative?
 A: No. Assume it is a non-negative number.
 Q: How are the digits ordered in the list? For example, is the number 12 represented by [1,2] or
 [2,1]?
 A: The digits are stored such that the most significant digit is at the head of the list.
 Q: Could the number contain leading zeros, such as [0,0,1]?
 A: No.
 
 Solution: Iterate from the least significant digit, and simulate by adding one to it. Adding one to a digit less than nine is straightforward – Add one to it and we are done. On the other hand, adding one to a digit of 9 brings it to 10, so we set the digit to 0 and continues with a carry digit of one to its left digit. 
 从尾部开始扫描，加一，有进位就一直加，没有扫描完就没进位了就可以立即退出，此为结果。或者是多产生了一位，最高位是1.    
*/
public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        int carries = 1;
        for(int i = digits.length - 1; i >= 0 && carries > 0; i--){
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;
        }
        
        if(carries == 0){
            return digits;
        }
        
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for(int i = 1; i <= digits.length; i++){
            result[i] = digits[i - 1];
        }
        return result;
    }
}
