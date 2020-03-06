//done

/*
 * 
 * t=sxt
 * 
 * 
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
 * 
 * 
 * 
 * 
 * 
 */
package leetcode;

public class Distinct_Subsequences {
	public static int numDistinct(String s, String t) {
		int dp[][] = new int[s.length()+1][t.length()+1]; //dp[i][j]: number of the sequences for i long s and j long t
		for (int i = 0; i < s.length(); i++)
			dp[i][0] = 1;//imp
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i-1) == t.charAt(j-1))// index = length - 1
					//dp[i-1][j]  : don't take s[i-2]
					//dp[i-1][j-1]: take s[i-2] 
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				else 
					dp[i][j] = dp[i-1][j];//important
			}
		}		
		return dp[s.length()][t.length()];
	}
}
