//completed
/*
 * 
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

 

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105
 * 
 */
package leetcode;

public class Longest_Substring_with_At_Least_K_Repeating_Characters {
	
	public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n==0 || n<k) return 0;
        if (k==1) return n;
        int[] counts = new int[26];
        for (char c: s.toCharArray()) counts[c-'a']++;
        char badchar = 0;
        for (int i=0; i<26; i++) {
            if (counts[i]>0 && counts[i]<k) {
                badchar = (char)(i+'a');
                break;
            }
        }
        if (badchar==0) return n;
        String[] subs = s.split(badchar+"");
        int res = 0;
        for (String sub:subs) res = Math.max(res, longestSubstring(sub,k));
        return res;
    }

}
