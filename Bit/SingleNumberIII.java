/*
 Author:     Junjie
 Date:       June 27, 2017
 Problem:    Single Number III
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/single-number-iii/
 Given 2*n + 2 numbers, every numbers occurs twice except two, find them.
 Example
 Given [1,2,2,3,4,4,5,3] return 1 and 5
 Solution: XOR, 分成最后一位上是0和1两组
*/
public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        int xor = 0;
        for(int i = 0; i < A.length; i++){
            xor ^= A[i];
        }
        
        int lastBit = xor - (xor & (xor - 1));
        int group0 = 0, group1 = 0;
        for(int i = 0; i < A.length; i++){
            if((lastBit & A[i]) == 0){
                group0 ^= A[i];
            }else{
                group1 ^= A[i];
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        result.add(group0);
        result.add(group1);
        return result;
    }
}