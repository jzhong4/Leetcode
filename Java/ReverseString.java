// String ---> char[String].  String.toCharArray
// 用swap方法，完成空间O(1)
// char[String] ---> String.  new String(array)
public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        char[] charArray = s.toCharArray();
        int start = 0, end = charArray.length - 1;
        
        while(start < end){
            swap(charArray, start, end);
            start++;
            end--;
        }
        return new String(charArray);
    }
    
    private void swap(char[] charArray, int start, int end){
        char temp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = temp;
    }
}