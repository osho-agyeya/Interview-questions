/*completedd
 * 
 * Given a string S, return the number of substrings that have only one distinct letter.

 

Example 1:

Input: S = "aaaba"
Output: 8
Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
"aaa" occurs 1 time.
"aa" occurs 2 times.
"a" occurs 4 times.
"b" occurs 1 time.
So the answer is 1 + 2 + 4 + 1 = 8.
Example 2:

Input: S = "aaaaaaaaaa"
Output: 55
 

Constraints:

1 <= S.length <= 1000
S[i] consists of only lowercase English letters.
 */

package leetcodePremium;

public class Count_Substrings_with_Only_One_Distinct_Letter {

	
	public int countLetters(String S) {
	    if (S == null || S.length() == 0) return 0;
	    int count = 1;
	    int sum = 0;
	    for (int i = 0; i < S.length() - 1; i++) {
	        if (S.charAt(i) != S.charAt(i+1)) {
	            sum += count * (count + 1) / 2;
	            count = 1;
	        } else { 
	            count++;
	        }
	    }
	    sum += count * (count + 1) / 2; // add last substring
	    return sum;
	}
}
