/* over, s+p, 1
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagrams_in_a_String {
	
	/*
	 * Approach 2: Sliding Window with Array
Algorithm

Hashmap is quite complex structure, with known performance issues in Java. Let's implement approach 1 using 26-elements array instead of hashmap:

Element number 0 contains count of letter a.

Element number 1 contains count of letter b.

...

Element number 26 contains count of letter z.

Algorithm

Build reference array pCount for string p.

Move sliding window along the string s:

Recompute sliding window array sCount at each step by adding one letter on the right and removing one letter on the left.

If sCount == pCount, update the output list.

Return output list.

Implementation


Complexity Analysis

Time complexity: \mathcal{O}(N_s + N_p)O(N 
s
​
 +N 
p
​
 ) since it's one pass along both strings.

Space complexity: \mathcal{O}(1)O(1), because pCount and sCount contain 26 elements each.
	 * 
	 * 
	 */
	
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    int[] hash = new int[256];
    for (char c : p.toCharArray()) {
        hash[c]++;
    }
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
        if (hash[s.charAt(right++)]-- >= 1) count--; 
        if (count == 0) list.add(left);
        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
    }
    return list;
        
    }

}
