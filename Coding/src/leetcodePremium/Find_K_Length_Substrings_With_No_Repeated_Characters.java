/*
 * completedd
 * 
 * Given a string S, return the number of substrings of length K with no repeated characters.

Example 1:
Input: S = "havefunonleetcode", K = 5
Output: 6
Explanation: 
There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.

Example 2:
Input: S = "home", K = 5
Output: 0
Explanation: 
Notice K can be larger than the length of S. In this case is not possible to find any substring.

Note:

1 <= S.length <= 10^4
All characters of S are lowercase English letters.
1 <= K <= 10^4
 */

package leetcodePremium;

public class Find_K_Length_Substrings_With_No_Repeated_Characters {
	
	public int numKLenSubstrNoRepeats(String S, int K) {
	    HashSet<Character> cur = new HashSet<>();
	    int res = 0, i = 0;
	    for (int j = 0; j < S.length(); j++) {

	      while (cur.contains(S.charAt(j))) {
	        cur.remove(S.charAt(i++));
	      }
	      cur.add(S.charAt(j));

	      if (j - i + 1 >= K) {
	        res += 1;
	      }
	    }

	    return res;
	  }

}
