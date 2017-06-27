/*
 Author:     Junjie
 Date:       June 27, 2017
 Problem:    Combination Sum II
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/combination-sum-ii
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 Each number in C may only be used once in the combination.
 Notice
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 Example
 Given candidate set [10,1,6,7,2,1,5] and target 8,
 A solution set is:
 [
  [1,7],
  [1,2,5],
  [2,6],
  [1,1,6]
 ] 
 Solution: DFS, 搜索树，时间复杂度：O(2^n)，与subset类似。
*/
public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0){
            return results;
        }
        
        Arrays.sort(num);
        combinationSumHelper(results, new ArrayList<Integer>(), num, target, 0);
        return results;
    }
    
    private void combinationSumHelper(List<List<Integer>> results, List<Integer> combinationSum, int[] num, int target, int startIndex){
        if(target == 0){
            results.add(new ArrayList<Integer>(combinationSum));
        }
        
        for(int i = startIndex; i < num.length; i++){
            if(target < num[i]){
                break;
            }
            
            if (i != startIndex && num[i] == num[i - 1]) {
                continue;
            }

            combinationSum.add(num[i]);
            combinationSumHelper(results, combinationSum, num, target - num[i], i + 1);
            combinationSum.remove(combinationSum.size() - 1);
        }
        return;
    }
}