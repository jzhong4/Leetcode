public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        String[] array = s.split(" ");
        StringBuilder reversed = new StringBuilder();
        
        for(int i = array.length - 1; i >= 0; i--){
            if(!array[i].equals("")){
                reversed.append(array[i]).append(" ");
            }
        }
        
        return reversed.length() == 0 ? "" : reversed.substring(0, reversed.length() - 1);
    }
}