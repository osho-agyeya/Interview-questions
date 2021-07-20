/* completedd
 * Given a string S, find out the length of the longest repeating substring(s). Return 0 if no repeating substring exists.


Example 1:

1
2
3
Input: "abcd"
Output: 0
Explanation: There is no repeating substring.
Example 2:

1
2
3
Input: "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
Example 3:

1
2
3
Input: "aabcaabdaab"
Output: 3
Explanation: The longest repeating substring is "aab", which occurs <wyn>3</wyn> times.

Example 4:

1
2
3
Input: "aaaaa"
Output: 4
Explanation: The longest repeating substring is "aaaa", which occurs twice.
Note:



The string S consists of only lowercase English letters from 'a' - 'z'.

1 <= S.length <= 1500
 */

package leetcodePremium;

public class Longest_Repeating_Substring {
	
	 public int longestRepeatingSubstring(String S) {
		          if(S == null || S.length() == 0){
		              return 0;
		          }
		         
		          int n = S.length();
		          int res = 0;
		         
		         int [][] dp = new int[n+1][n+1];
	             for(int i = 1; i<=n; i++){
		             for(int j = 1; j<i; j++){
		                 if(S.charAt(i-1) == S.charAt(j-1)){
		                     dp[i][j] = dp[i-1][j-1]+1;
		                     res = Math.max(res, dp[i][j]);            
		                 }
		             }
		         }
		        
		         return res;
		     }

}
