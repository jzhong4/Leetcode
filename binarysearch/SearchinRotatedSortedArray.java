//如果比较mid和target, 无法确定去掉哪一半，所以
//首先比较mid和start关系，确定在哪个上升段
//然后比较target与start，mid或者target于end，mid的关系，能确定如何二分
public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        int mid;
        
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > nums[start]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        
        if(nums[start] == target){
            return start;
        }else if(nums[end] == target){
            return end;
        }else{
            return -1;
        }
    }
}