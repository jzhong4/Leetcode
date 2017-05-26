// find the first position >= target 第一种更容易写
// find the last position < target, return + 1
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        
        int start, end, mid;
        
        start = 0;
        end = nums.length - 1;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(nums[start] >= target){
            return start;
        }else if(nums[end] >= target){
            return end;
        }else{
            return end + 1;
        }
    }
}