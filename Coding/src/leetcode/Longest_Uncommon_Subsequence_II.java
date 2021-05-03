/*completed
 * Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.

An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.

A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
 

Example 1:

Input: strs = ["aba","cdc","eae"]
Output: 3
Example 2:

Input: strs = ["aaa","aaa","aa"]
Output: -1
 

Constraints:

1 <= strs.length <= 50
1 <= strs[i].length <= 10
strs[i] consists of lowercase English letters. */

package leetcode;

public class Longest_Uncommon_Subsequence_II {
	
	  public int findLUSlength(String[] strs) {
	        int res=-1, n=strs.length;
	        for (int i=0; i<n; i++){
	            if (strs[i].length()<res) continue;
	            int j=-1;
	            while(++j<n) if (i!=j && isSubsequence(strs[i], strs[j])) break;
	            if (j==n) res=Math.max(res, strs[i].length());
	        }
	        return res;
	    }
	    public boolean isSubsequence(String a, String b){
	        int i=0, j=0;
	        while(i<a.length() && j<b.length()) if (a.charAt(i)==b.charAt(j++)) i++;
	        return i==a.length();
	    }

}
