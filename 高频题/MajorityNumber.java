//两两抵消，剩下多的就是majority number
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                candidate = nums[i];
                count++;
            }else{
                if(candidate == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return candidate;
    }
}