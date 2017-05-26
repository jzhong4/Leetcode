public class Solution {
    // 二进制XOR
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length ==0){
            return -1;
        }
        
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
}