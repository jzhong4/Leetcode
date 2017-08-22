/*
 Author:     Junjie
 Date:       Aug 22, 2017
 Problem:    The Smallest Difference
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/the-smallest-difference/
 Solution:   两指针并行
*/
public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
       
       Arrays.sort(A);
       Arrays.sort(B);
       
       int ai = 0, bi = 0;
       int result = Integer.MAX_VALUE;
       while(ai < A.length && bi < B.length){
          result = Math.min(Math.abs(A[ai] - B[bi]), result);
          if(A[ai] < B[bi]){
              ai++;
          }else{
              bi++;
          }
        }
        return result;
    }
}
