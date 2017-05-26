//转化成前缀和数组prefix sum，subarray(i, j) = sum[j] - sum[i - 1]
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return  0;
        }
        
        int max = Integer.MIN_VALUE, minSum = 0, sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(sum - minSum, max);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}