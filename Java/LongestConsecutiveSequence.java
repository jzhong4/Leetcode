public class Solution {
    //扫描数组，对于扫到的数不断+1，然后不断-1看他们是否在数组内，是的移除掉之后。接着扫描时就不会再次计算。每个节点都会扫到一遍，所以是O(n).
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            
            int up = nums[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            
            longest = Math.max(longest, up - down - 1);
        }
        
        return longest;
    }
}