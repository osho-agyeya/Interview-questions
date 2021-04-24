//completed

/*
Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"
 

Constraints:

1 <= s.length, t.length <= 105
s and t consist of English letters. 
 */
package leetcode;

public class Minimum_Window_Substring {
	
	public String minWindow(String s, String t) {
	    int [] map = new int[128];
	    for (char c : t.toCharArray()) {
	      map[c]++;
	    }
	    int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
	    while (end < s.length()) {
	      final char c1 = s.charAt(end);
	      if (map[c1] > 0) counter--;
	      map[c1]--;
	      end++;
	      while (counter == 0) {
	        if (minLen > end - start) {
	          minLen = end - start;
	          minStart = start;
	        }
	        final char c2 = s.charAt(start);
	        map[c2]++;
	        if (map[c2] > 0) counter++;
	        start++;
	      }
	    }

	    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	  }

}
