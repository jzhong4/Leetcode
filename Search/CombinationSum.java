/*
 Author:     Junjie
 Date:       June 27, 2017
 Problem:    Combination Sum
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/combination-sum
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 The same repeated number may be chosen from C unlimited number of times.
 Notice
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 Example
 Given candidate set [2,3,6,7] and target 7, a solution set is:
 [7]
 [2, 2, 3] 
 Solution: DFS, 搜索树，时间复杂度：O(2^n)，与subset类似。
 */
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return results;
        }
        
        Arrays.sort(candidates);
        combinationSumHelper(results, new ArrayList<Integer>(), candidates, target, 0);
        return results;
    }
    
    private void combinationSumHelper(List<List<Integer>> results, List<Integer> combinationSum, int[] candidates, int target, int startIndex){
        if(target == 0){
            results.add(new ArrayList<Integer>(combinationSum));
        }
        
        for(int i = startIndex; i < candidates.length; i++){
            if(target < candidates[i]){
                break;
            }
            //此判断是如果set里面有重复的数
             if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            combinationSum.add(candidates[i]);
            combinationSumHelper(results, combinationSum, candidates, target - candidates[i], i);
            combinationSum.remove(combinationSum.size() - 1);
        }
        return;
    }
}
