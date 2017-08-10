/*
 Author:     Junjie
 Date:       July 30, 2017
 Problem:    Longest Substring with At Most Two Distinct Characters
 Difficulty: Hard
 Source:     Leetcode
 Reference:  http://yuanhsh.iteye.com/blog/2188917
 Given a string S, find the length of the longest substring T that contains at most two distinct characters.
 For example,
 Given S = “eceba”,
 T is "ece" which its length is 3.
*/

 Solution1: brute force - time O(n^2)
 For each possible substring, insert all characters into a Set which the Set’s size indicating the number of distinct characters. If the size > 2, we loop over next starting position, and at the same time calculate the maximum length
 public int lengthOfLongestSubstringTwoDistinct(String s) {
		int maxLen = 0;
		for(int i = 0; i < s.length(); i++){
		   Set<Character> set = new HashSet<>();
		   for(int l = 1; l < s.length() - i; l++) {
			   set.add(s.charAt(i + l - 1));
			   if(set.size() > 2) break;
			   if(l > maxLen) {
				   maxLen = l;
			   }
		   }
		}	
		return maxLen;
  }

 Solution2: sliding window - time O(n). The trick is to maintain a sliding window that always satisfies the invariant where there are always at most two distinct characters in it.
 public int lengthOfLongestSubstringTwoDistinct(String s) {
		int i = 0, j = -1, maxLen = 0;
		for (int k = 1; k < s.length(); k++) {
			if (s.charAt(k) == s.charAt(k - 1))
				continue;
			if (j >= 0 && s.charAt(j) != s.charAt(k)) {
				maxLen = Math.max(k - i, maxLen);
				i = j + 1;
			}
			j = k - 1;
		}
		return Math.max(s.length() - i, maxLen);
	}

Solution3: Although the above method works fine, it could not be easily generalized to the case
where T contains at most k distinct characters.

The key is when we adjust the sliding window to satisfy the invariant, we need a counter
of the number of times each character appears in the substring.

public int lengthOfLongestSubstringTwoDistinct(String s) {
		int[] count = new int[256];
		int i = 0, numDistinct = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if (count[s.charAt(j)] == 0) numDistinct++;
			count[s.charAt(j)]++;
			while(numDistinct > 2) {
				count[s.charAt(i)]--;
				if(count[s.charAt(i)] == 0)  numDistinct--;
				i++;
			}
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
}
