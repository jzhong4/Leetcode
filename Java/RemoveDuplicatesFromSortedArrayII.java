public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int size = 0, count = 0;
        for(int i = 1 ; i < nums.length; i++){
            if(nums[size] == nums[i]){
                count++;
                if(count < 2 ){
                   nums[++size] = nums[i];
                }
            }else{
                nums[++size] = nums[i];
                count = 0;
            }
        }
        return size + 1;
    }
}