/*completedd
 * 
 * A string S represents a list of words.

Each letter in the word has 1 or more options.  If there is one option, the letter is represented as is.  If there is more than one option, then curly braces delimit the options.  For example, "{a,b,c}" represents options ["a", "b", "c"].

For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].

Return all words that can be formed in this manner, in lexicographical order.

Example 1:
Input: "{a,b}c{d,e}f"
Output: ["acdf","acef","bcdf","bcef"]

Example 2:
Input: "abcd"
Output: ["abcd"]

Note:
1 <= S.length <= 50
There are no nested curly brackets.
All characters inside a pair of consecutive opening and ending curly brackets are different.
 */

package leetcodePremium;

public class Brace_Expansion {

	 public String[] expand(String S) {
		    int n = S.length();
		    if (n == 0) {
		      return new String[]{""};
		    }
		    if (n == 1) {
		      return new String[]{S};
		    }

		    List<String> res = new ArrayList<>();
		    if (S.charAt(0) == '{') {
		      int count = 0;
		      int i = 0;
		      while (i < S.length()) {
		        if (S.charAt(i) == '}') {
		          break;
		        }
		        i++;
		      }
		      String[] l = S.substring(1, i).split(",");
		      String[] r = expand(S.substring(i + 1));
		      for (String ll: l) {
		        for (String rr: r) {
		          res.add(ll + rr);
		        }
		      }
		    } else {
		      String[] r = expand(S.substring(1));
		      for (String rr: r) {
		        res.add(S.charAt(0) + rr);
		      }
		    }
		    Collections.sort(res);
		    return res.toArray(new String[0]);
		  }
	
}
