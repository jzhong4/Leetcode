public class Solution {
    //每三个数可以抵消，所以可以展开成32位后，对每位取模3，剩下的数，即是所求之数。时间复杂度O(n)，空间复杂度O（1）
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int result = 0;
        int[] bits = new int[32];
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < nums.length; j++){
                bits[i] += (nums[j] >> i) & 1;
            }
                bits[i] %= 3;
                result |= (bits[i] << i);
        }
        return result; 
    }
}