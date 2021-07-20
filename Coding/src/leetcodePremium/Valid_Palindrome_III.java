/*completedd
 * 
 * Given a string s and an integer k, find out if the given string is a K-Palindrome or not.

A string is K-Palindrome if it can be transformed into a palindrome by removing at most k characters from
it.

Example 1:

Input: s = "abcdeca", k = 2
Output: true
Explanation: Remove 'b' and 'e' characters.

Constraints:

    1 <= s.length <= 1000
    s has only lowercase English letters.
    1 <= k <= s.length
 */

package leetcodePremium;

public class Valid_Palindrome_III {
	
	public boolean isValidPalindrome(String s, int k) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        int maxLength = dp[0][length - 1];
        return length - maxLength <= k;
    }

}
