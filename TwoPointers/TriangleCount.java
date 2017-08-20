/*
 Author:     Junjie
 Date:       Aug 13, 2017
 Problem:    Triangle Count
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/triangle-count/
 Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?
 Example
 Given array S = [3,4,6,7], return 3. They are:
 [3,4,6]
 [3,6,7]
 [4,6,7]
 Given array S = [4,4,4,4], return 4. They are:
 [4(1),4(2),4(3)]
 [4(1),4(2),4(4)]
 [4(1),4(3),4(4)]
 [4(2),4(3),4(4)]
 Solution:找三条边，两天边大于第三条边。Assume index k < j < i. 排序后O（nlogn），S[i] + S[j] > S[k], S[i] + S[k] > S[j]一定成立，所以只需要求S[j] + S[k] > S[i]。 想的简单点，暴力搜索，i: 2 -> n - 1, j: 1 -> i, k: 0 -> j O(n^3)。但是可以转化为S[j] + S[k] > target, 这样复杂度就是O(n^2)
*/
public class Solution {
    /*
     * @param : A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        if(S == null || S.length < 3){
            return 0;
        }
        Arrays.sort(S);
        
        int count = 0;
        int left, right;
        for(int i = 2; i < S.length; i++){
             left = 0;
             right = i - 1;
             while(left < right){
                 if(S[left] + S[right] <= S[i]){
                     left++;
                 }else{
                     count += right - left;
                     right--;
                 }
            }
        }
        return count;
    }
}