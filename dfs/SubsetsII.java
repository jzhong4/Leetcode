public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();

	if(nums == null){
	  return results;
	}

	if(nums.length == 0){
	  results.add(new ArrayList<Integer>());
	  return results;
  }
	//先要排序
        Arrays.sort(nums);
	subsetsHelper(new ArrayList<Integer>(), nums, 0, results);
	return results;      
    }
    
   private void subsetsHelper(ArrayList<Integer> subset, int[] nums, int startIndex, ArrayList<List<Integer>> results){
	
	results.add(new ArrayList<Integer>(subset));

	for(int i = startIndex; i < nums.length; i++){
	  //只关心取多少个2，不关心取哪几个，从第一个2开始连续取
	  if(i != startIndex && nums[i] == nums[i - 1])
	    continue;
	  subset.add(nums[i]);
	  subsetsHelper(subset, nums, i + 1, results);
	  subset.remove(subset.size() - 1);
	}
  }
}