/*
 Author:     Junjie
 Date:       July 17, 2017
 Problem:    Two Sum III - Data structure design
 Difficulty: Medium
 Source:     Leetcode
 Design and implement a TwoSum class. It should support the following operations: add and find.
 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.
 For example,
 add(1); add(3); add(5);
 find(4) -> true
 find(7) -> false
*/
Solution:
1) Store all possible pair sums into a hash table. Store the list of add numbers in O(n) space and Each add operation go through the list and form new pari sums that go into the hashtable, this extra space cost O(n^2). The find operation involves a single hash table lookup in O(1) runtime. - add – O(n) runtime, find – O(1) runtime, O(n^2) space - Store pair sums in hash table

2) Maintain a sorted array of numbers. Each add operation would need O(log n) time toinsert it at the correct position using a modified binary search ([48. SearchInsert Position]). For find operation we could then apply the [Two pointers] approach inO(n) runtime. - add – O(log n) runtime, find – O(n) runtime, O(n) space – Binary search + Twopointers

3) A simpler approach is to store each input into a hash table. To find if a pair sum exists, just iterate through the hash table in O(n) runtime. Make sure you are able to handle duplicates correctly. - add – O(1) runtime, find – O(n) runtime, O(n) space – Store input in hash table.

public class TwoSum {
	
	private HashMap<Integer, Integer> map;
	
	public TwoSum() {
		map = new HashMap<>();
	}
	
	public void add(int input) {
		int count = map.containsKey(input)? map.get(input) : 0;
		map.put(input, count + 1);
	}
	
	public boolean find(int val) {
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();
			if(num == val - num) {
				if(entry.getValue() >= 2) return true;
			}else if(map.containsKey(val - num)){
				return true;
			}
			
		}
		return false;
		
	}
}