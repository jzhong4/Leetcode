//最后返回的是位置，而且数组不是有序的。所以用HashMap解法。
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) != null){
                int[] result = new int[]{i, map.get(nums[i])};
                return result;
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}