/* over, n, m(size of charset)
 * 
 * Given a string, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

//this is good. remember you can use maps to store whatever you want,even indices

package leetcode;

import java.util.*;

public class Longest_Substring_Without_Repeating_Characters {
	
	 public int lengthOfLongestSubstring(String s) {
	        Integer[] chars = new Integer[128];

	        int left = 0;
	        int right = 0;

	        int res = 0;
	        while (right < s.length()) {
	            char r = s.charAt(right);

	            Integer index = chars[r];
	            if (index != null && index >= left && index < right) {
	                left = index + 1;
	            }

	            res = Math.max(res, right - left + 1);

	            chars[r] = right;
	            right++;
	        }

	        return res;
	    }

}
