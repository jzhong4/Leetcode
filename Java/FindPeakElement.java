/*存在单调的可能性，峰值在端点的可能性
首先分析若使用传统的二分搜索，
若A[mid] > A[mid - 1] && A[mid] < A[mid + 1]，则找到一个peak为A[mid]；
若A[mid - 1] > A[mid]，则A[mid]左侧必定存在一个peak，可用反证法证明：若左侧不存在peak，则A[mid]左侧元素必满足A[0] > A[1] > ... > A[mid -1] > A[mid]，与已知A[0] < A[1]矛盾，证毕。
同理可得若A[mid + 1] > A[mid]，则A[mid]右侧必定存在一个peak。如此迭代即可得解。*/
public class Solution {
    public int findPeakElement(int[] nums) {
        
        int start = 0, end = nums.length - 1; 
        int mid;
        
        while(start + 1 <  end) {
            mid = (start + end) / 2;
            if(nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if(nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        
        return (nums[start] > nums[end])? start : end ; 
        }
    }