/*
 Author:     Junjie
 Date:       June 22, 2017
 Problem:    Subsets 
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/subsets
 Given a set of distinct integers, return all possible subsets.
 Notice
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 Have you met this question in a real interview? Yes
 Example
 If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 Solution: DFS, 搜索树，时间复杂度：O(2^n) , 对于n个数，每一位可以选或者不选
 */
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(nums == null) {
            return results;
        }
        //空集的子集也是空集,可以不写，因为可以归纳到general solution当中
        if(nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        subsetsHelper(results, new ArrayList<Integer>(), nums, 0);
        return results;
    }
    
    private void subsetsHelper(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> list, int[] nums, int pos){
	//这里需要deep copy
        results.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            subsetsHelper(results, list, nums, i + 1);
            list.remove(list.size() -1);
        }
        
        return;
    }
}