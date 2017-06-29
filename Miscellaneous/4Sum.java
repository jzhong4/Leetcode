/*
 Author:     Junjie
 Date:       June 29, 2017
 Problem:    4Sum
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/4sum/
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 Find all unique quadruplets in the array which gives the sum of target.
 Notice
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 Example
 Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:
 (-1, 0, 0, 1)
 (-2, -1, 1, 2)
 (-2, 0, 0, 2)
*/
public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(numbers);

		for (int i = 0; i < numbers.length - 3; i++) {
			if (i != 0 && numbers[i] == numbers[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < numbers.length - 2; j++) {
				if (j != i + 1 && numbers[j] == numbers[j - 1])
					continue;

				int left = j + 1;
				int right = numbers.length - 1;
				while (left < right) {
					int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(numbers[i]);
						tmp.add(numbers[j]);
						tmp.add(numbers[left]);
						tmp.add(numbers[right]);
						rst.add(tmp);
						left++;
						right--;
						while (left < right && numbers[left] == numbers[left - 1]) {
							left++;
						}
						while (left < right && numbers[right] == numbers[right + 1]) {
							right--;
						}
					}
				}
			}
		}

		return rst;

    }
}