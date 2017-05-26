public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                }
                if(sum < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return bestSum;
    }
}