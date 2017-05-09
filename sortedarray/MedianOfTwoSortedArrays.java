//每次砍掉k/2个，所以时间复杂度O（log m+n）
public class Solution {
    //这里的len表示第几大的数，与坐标无关
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 1){
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        }else{
            return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
    }
    // find kth number of two sorted array
    private int findKth(int[] nums1, int nums1_start, int[] nums2, int nums2_start, int k){
        //边界处理：1）返回数组2的第k大 2）返回数组1的第k大 3）找第k = 1 大的数
        if (nums1_start >= nums1.length) {
			return nums2[nums2_start + k - 1];
		}
		if (nums2_start >= nums2.length) {
			return nums1[nums1_start + k - 1];
		}

		if (k == 1) {
			return Math.min(nums1[nums1_start], nums2[nums2_start]);
		}
        
        //递归： 比较数组1第k/2 与数组2第k/2的数大小，谁小，扔掉自己所在的数组k/2个数，因为肯定在合并后的第k个数里面
        int nums1_key = nums1_start + k / 2 - 1 < nums1.length
		            ? nums1[nums1_start + k / 2 - 1]
		            : Integer.MAX_VALUE;
		int nums2_key = nums2_start + k / 2 - 1 < nums2.length
		            ? nums2[nums2_start + k / 2 - 1]
		            : Integer.MAX_VALUE;
		            
		if (nums1_key < nums2_key) {
			return findKth(nums1, nums1_start + k / 2, nums2, nums2_start, k - k / 2);
		} else {
			return findKth(nums1, nums1_start, nums2, nums2_start + k / 2, k - k / 2);
		}
    }
}