//分成2组2n + 1。a != b, so a ^ b != 0, so某一位二进制上 a！= b。所以两组分成第i位是0的组和1的组
public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }
        //最后不相同的一位
        int lastBit = xor - (xor & (xor -1));
        int group0 = 0, group1 = 0;
        for(int i = 0; i < nums.length; i++){
            if((lastBit & nums[i]) == 0){
                group0 ^= nums[i];
            }else{
                group1 ^= nums[i];
            }
        }
        
        int[] result = new int[2];
        result[0] = group0;
        result[1] = group1;
        return result;
    }
}