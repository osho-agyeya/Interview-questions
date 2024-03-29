//completed
/*
 * 
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 

Constraints:

1 <= s.length <= 2000
s consists of lower-case English letters only.
 */
package leetcode;

public class Palindrome_Partitioning_II {

	public int minCut(String s) {
	    char[] c = s.toCharArray();
	    int n = c.length;
	    int[] cut = new int[n];
	    boolean[][] pal = new boolean[n][n];
	    
	    for(int i = 0; i < n; i++) {
	    	cut[i]=i;
	        for(int j = 0; j <= i; j++) {
	            if(c[j] == c[i] && (1 >= i - j || pal[j + 1][i - 1])) {
	                pal[j][i] = true;  
	                cut[i] = j == 0 ? 0 : Math.min(cut[i], cut[j - 1] + 1);
	            }
	        }
	    }
	    return cut[n - 1];
	}
	
}
