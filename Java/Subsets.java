// 递归：一种实现DFS算法的一种方式
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
	
	ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();

	if(nums == null){
	  return results;
	}

	if(nums.length == 0){
	  results.add(new ArrayList<Integer>());
	  return results;
	}

	subsetsHelper(new ArrayList<Integer>(), nums, 0, results);
	return results;      
    }
// 递归三要素
// 1. 递归的定义：在 nums 中找到所有以 subset 开头的的集合，并放到 results 
   private void subsetsHelper(ArrayList<Integer> subset, int[] nums, int startIndex, ArrayList<List<Integer>> results){

	
	results.add(new ArrayList<Integer>(subset));

	for(int i = startIndex; i < nums.length; i++){
          // 找以[1]开头的所有集合
          // [1] -> [1,2]
	  subset.add(nums[i]);
          // 寻找所有以 [1,2] 开头的集合，并扔到 results
	  subsetsHelper(subset, nums, i + 1, results);
	  // [1,2] -> [1]  回溯
	  subset.remove(subset.size() - 1);
	}
        // 3. 递归的出口
        // return;	
    }
}