/*
 Author:     Junjie
 Date:       June 24, 2017
 Problem:    Subsets II 
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/subsets-ii/
 Given a list of numbers that may has duplicate numbers, return all possible subsets
 Notice
 Each element in a subset must be in non-descending order.
 The ordering between two subsets is free.
 The solution set must not contain duplicate subsets.
 Example
 If S = [1,2,2], a solution is:

 [
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
 ]
 Solution: DFS, 搜索树，时间复杂度：O(2^n)
 */
class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(nums == null){
            return results;
        }
        Arrays.sort(nums);
        subsetsWithDupHelper(results, new ArrayList<Integer>(), nums, 0);
        return results;
    }
    
    private void subsetsWithDupHelper(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> subsets, int[] nums, int pos){
        results.add(new ArrayList<Integer>(subsets));
        
        for(int i = pos; i < nums.length; i++){
            if(i != pos && nums[i] == nums[i - 1]){
                continue;
            }
            subsets.add(nums[i]);
            subsetsWithDupHelper(results, subsets, nums, i + 1);
            subsets.remove(subsets.size() - 1);
        }
        return;
    }    
    
}
