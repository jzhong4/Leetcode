/*
 Author:     Junjie
 Date:       July 28, 2017
 Problem:    Valid Number
 Difficulty: Hard
 Source:     https://leetcode.com/problems/valid-number/tabs/description
 Validate if a given string is numeric. 
 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 Example Questions Candidate Might Ask: Q: How to account for whitespaces in the string? A: When deciding if a string is numeric, ignore both leading and trailing whitespaces. Q: Should I ignore spaces in between numbers – such as “1 1”? A: No, only ignore leading and trailing whitespaces. “1 1” is not numeric. Q: If the string contains additional characters after a number, is it considered valid? A: No. If the string contains any non-numeric characters (excluding whitespaces and decimal point), it is not numeric. Q: Is it valid if a plus or minus sign appear before the number? A: Yes. “+1” and “-1” are both numeric. Q: Should I consider only numbers in decimal? How about numbers in other bases such as hexadecimal (0xFF)? A: Only consider decimal numbers. “0xFF” is not numeric. Q: Should I consider exponent such as “1e10” as numeric? A: No. But feel free to work on the challenge that takes exponent into consideration. (The Online Judge problem does take exponent into account.) 
 
 Solution1: 扫描，只有三种可能性是真确的，数字(num)，点(dot)，e(exp)，全部扫完，最后数字是true的话，那就是合理的数字
 注意一些合理的特殊number: 1. , .1 , 1.0, .1e1 , 1.e1
 1) String是null或者是空字符串都是invalid
 2）.. or e.不合理
 3）ee or e3 不合理
 4）不是开头的+和-也是不合理的
*/
public class Solution {
    public boolean isNumber(String s) {
        if(s == null){
            return false;
        }
        s = s.trim();
        if(s.length() == 0){
            return false;
        }
        int i = 0;
        if(s.charAt(i) == '+' || s.charAt(i) == '-') i++;
        boolean num = false, dot = false, exp = false;
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = true;
            }else if(c == '.'){
                if(dot || exp) return false;
                dot = true;
            }else if(c == 'e'){
                if(exp || num == false) return false;
                exp = true;
                num = false; // 不能以e结尾
            }else if(c == '+' || c == '-'){
                if (s.charAt(i - 1) != 'e') return false;
            }else{
                return false;
            }
            i++;
        }
        return num;
    }
}

 Solution2: 按照数字，点，e，最后空白去扫描，只有这个顺序是正确的思想
public class Solution {
    public boolean isNumber(String s) {
        if(s == null){
            return false;
        }
        s = s.trim();
        if(s.length() == 0){
            return false;
        }
        int i = 0, n = s.length();
        if(s.charAt(i) == '+' || s.charAt(i) == '-') i++;
        boolean isNumeric = false;
        while(i < n && Character.isDigit(s.charAt(i))){
          i++;
          isNumeric = true;
        }
        if(i < n && s.charAt(i) == '.'){
            i++;
             while(i < n && Character.isDigit(s.charAt(i))){
                i++;
                isNumeric = true;
            }
        }
        if(isNumeric && i < n && s.charAt(i) == 'e'){ // isNumeric防止以e开头
            i++;
            isNumeric = false;//防止以e结尾
            if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++; //可能e之后有+-符号
            while(i < n && Character.isDigit(s.charAt(i))){
                i++;
                isNumeric = true;
            }
        }
        while(i < n && Character.isWhitespace(s.charAt(i))) i++;// s.charAt(i) == ' ‘也可以用
        return isNumeric && i == n;
    }
}