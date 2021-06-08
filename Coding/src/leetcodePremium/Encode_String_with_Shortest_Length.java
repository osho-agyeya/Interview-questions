/*completed
 * on

Given a non-empty string, encode the string such that its encoded length is the shortest.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note:
k will be a positive integer and encoded string will not be empty or have extra space.
You may assume that the input string contains only lowercase English letters. The string's length is at most 160.
If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return any of them is fine.

Example 1: 
Input: "aaa"
Output: "aaa"
Explanation: There is no way to encode it such that it is shorter than the input string, so we do not encode it.

Example 2: 
Input: "aaaaa"
Output: "5[a]"
Explanation: "5[a]" is shorter than "aaaaa" by 1 character.

Example 3: 
Input: "aaaaaaaaaa"
Output: "10[a]"
Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, which is the same as "10[a]".

Example 4: 
Input: "aabcaabcd"
Output: "2[aabc]d"
Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".

Example 5: 
Input: "abbbabbbcabbbabbbc"
Output: "2[2[abbb]c]"
Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one answer can be "2[2[abbb]c]"
 */


package leetcodePremium;

public class Encode_String_with_Shortest_Length {
	
	public String encode(String s) {
        int n = s.length();

        if (s.length() <= 3) {
            return s;
        }

        //dp[i][j]表示s[i...j]中最短的encoded string
        String[][] dp = new String[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;

                dp[i][j] = s.substring(i, i + len);

                // No need to encode if the current len of substring is less than 4
                if (len <= 3) {
                    continue;
                }

                for (int k = i; k < j; k++) {
                    String left = dp[i][k];
                    String right = dp[k + 1][j];

                    if (left.length() + right.length() < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }

                String collapsedStr = collapse(dp, s.substring(i, i + len), i);
                if (collapsedStr.length() < dp[i][j].length()) {
                    dp[i][j] = collapsedStr;
                }
            }
        }
        return dp[0][n - 1];
    }

    public String collapse(String[][] dp, String s, int start) {        
        // Check if there is repeated pattern in s
        int index = (s + s).indexOf(s, 1);

        // No repeated pattern in this case
        if (index >= s.length()) {
            return s;
        }
        else {
            return (s.length() / index) + "[" + dp[start][start + index - 1] + "]";
        }
    }

	
	
}
