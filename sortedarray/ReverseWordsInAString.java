// input: " 1" ---> [0] = ""(空字符串), [1] = 1
// input: " "  ---> array.length = 0
// 注意空串和空格串的区别
public class Solution {
    public String reverseWords(String s) {
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i = array.length - 1; i >=0; i--){
             if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }
        
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}