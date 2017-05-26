public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        
        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        
        int row = matrix.length, col = matrix[0].length;
        int x = row - 1, y = 0;
        // from bottom left to top right
        while(x >= 0 && y < col){
            if(matrix[x][y] < target){
                y++;
            }else if(matrix[x][y] > target){
                x--;
            }else{
               return true; 
            }
        }
        return false;
    }
}