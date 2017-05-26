//注意要和end点比较大小，因为0度rotate的数组，从图上可能不存在start这个点。
public class Solution {
    public int findMin(int[] nums) {
        
        int start = 0, end = nums.length - 1;
        int mid;
        
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] > nums[end]){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        return (nums[start] < nums[end])? nums[start] : nums[end];
    }
}