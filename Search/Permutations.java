/*
 Author:     Junjie
 Date:       June 22, 2017
 Problem:    Permutations
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/permutations
 Given a list of numbers, return all possible permutations.
 Notice
 You can assume that there is no duplicate numbers in the list.
 Example
 For nums = [1,2,3], the permutations are:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 Solution: DFS, 搜索树，时间复杂度：O(n!) , n * (n - 1) * (n - 2) * .... = n!
 */
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return result;
        }
        
        permuteHelper(result, new ArrayList<Integer>(), nums);
        return result;
    }
    
    private void permuteHelper(ArrayList<List<Integer>> result, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            result.add(list);
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]); 
            permuteHelper(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
