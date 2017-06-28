/*
 Author:     Junjie
 Date:       June 28, 2017
 Problem:    Majority Number III
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/majority-number-iii/
 Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.
 Find it.
 Notice
 There is only one majority number in the array.
 Example
 Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.
 Solution: 抵消, 需要k - 1个candidate，用hashmap来维护。
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        HashMap<Integer, Integer> counters = new HashMap<Integer, Integer>();
        for(Integer i : nums){
            if(!counters.containsKey(i)){
                counters.put(i, 1);
            }else{
                counters.put(i, counters.get(i) + 1);
            }
            
            if (counters.size() >= k) {
                removeKey(counters);
            }
        }
        
        for (Integer i : counters.keySet()) {
            counters.put(i, 0);
        }
        for (Integer i : nums) {
            if (counters.containsKey(i)) {
                counters.put(i, counters.get(i) + 1);
            }
        }
        
        int maxCounter = 0, maxKey = 0;
        for (Integer i : counters.keySet()) {
            if (counters.get(i) > maxCounter) {
                maxCounter = counters.get(i);
                maxKey = i;
            }
        }
        
        return maxKey;
    }
    
     private void removeKey(HashMap<Integer, Integer> counters) {
        Set<Integer> keySet = counters.keySet();
        List<Integer> removeList = new ArrayList<Integer>();
        for (Integer key : keySet) {
            counters.put(key, counters.get(key) - 1);
            if (counters.get(key) == 0) {
                removeList.add(key);
            }
        }
        for (Integer key : removeList) {
            counters.remove(key);
        }
    }
}
