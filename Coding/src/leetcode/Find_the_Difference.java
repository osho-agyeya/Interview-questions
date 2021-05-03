//completed

/*
You are given two strings s and t.

String t is generated by random shuffling string s and then add one more letter at a random position.

Return the letter that was added to t.

 

Example 1:

Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.
Example 2:

Input: s = "", t = "y"
Output: "y"
Example 3:

Input: s = "a", t = "aa"
Output: "a"
Example 4:

Input: s = "ae", t = "aea"
Output: "a"
 

Constraints:

0 <= s.length <= 1000
t.length == s.length + 1
s and t consist of lower-case English letters.
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Find_the_Difference {
	
    public char findTheDifference(String s, String t) {
    	int n = t.length();
char c = t.charAt(n - 1);
for (int i = 0; i < n - 1; ++i) {
	c ^= s.charAt(i);
	c ^= t.charAt(i);
}
return c;
}
}
