/*
 Author:     Junjie
 Date:       June 24, 2017
 Problem:    N-Queens 
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/n-queens
 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 Given an integer n, return all distinct solutions to the n-queens puzzle.
 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 Example
 There exist two distinct solutions to the 4-queens puzzle:
 [
  // Solution 1
  [".Q..",
   "...Q",
   "Q...",
   "..Q."
  ],
  // Solution 2
  ["..Q.",
   "Q...",
   "...Q",
   ".Q.."
  ]
 ]
 Solution: DFS, 搜索树
           1) 使用ArrayList<Integer>求出所有可能的位置
           2）判断不合理的位置，同一列，左对角线，右对角线
           3）根据位置，用StringBuilder画出Q的位置
           4） 时间复杂度: 与permutation相似，O(n!)
 */
class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
       ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
       if(n == 0){
           return results;
       }
       
       search(results, new ArrayList<Integer>(), n);
       return results;
    }
    
    private void search(ArrayList<ArrayList<String>> results, ArrayList<Integer> cols, int n){
        if(cols.size() == n){
            results.add(drawChessboard(cols));
            return;
        }
        
        for(int colIndex = 0; colIndex < n; colIndex++){
            if(!isValid(cols, colIndex)){
                continue;
            }
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
        return;
    }
    
    private boolean isValid(ArrayList<Integer> cols, int column){
        int row = cols.size();
        for(int rowIndex = 0; rowIndex < row; rowIndex++){
            if(cols.get(rowIndex) == column){
                return false;
            }
            
            if(rowIndex + cols.get(rowIndex) == row + column){
                return false;
            }
            
            if(rowIndex - cols.get(rowIndex) == row - column){
                return false;
            }
        }
        return true;
    }
    
    private ArrayList<String> drawChessboard(ArrayList<Integer> cols){
        ArrayList<String> chessboard = new ArrayList<String>();
        for(int i = 0; i < cols.size(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < cols.size(); j++){
                sb.append(j == cols.get(i)? "Q" : ".");
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
    
};
