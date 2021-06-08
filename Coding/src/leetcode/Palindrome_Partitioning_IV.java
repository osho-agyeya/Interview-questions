//completed
/*
 * 
Given a string s, return true if it is possible to split the string s into three non-empty palindromic substrings. Otherwise, return false.​​​​​

A string is said to be palindrome if it the same string when reversed.

 

Example 1:

Input: s = "abcbdd"
Output: true
Explanation: "abcbdd" = "a" + "bcb" + "dd", and all three substrings are palindromes.
Example 2:

Input: s = "bcbddxy"
Output: false
Explanation: s cannot be split into 3 palindromes.
 

Constraints:

3 <= s.length <= 2000
s​​​​​​ consists only of lowercase English letters..
 */
package leetcode;

public class Palindrome_Partitioning_IV {

	 public boolean checkPartitioning(String s) {
	        char[] c = s.toCharArray();
		    int n = c.length;
		    boolean[][] pal = new boolean[n][n];
		    
		    for(int i = 0; i < n; i++) {
		        for(int j = 0; j <= i; j++) {
		                        if(c[j] == c[i] && (2 >= i - j || pal[j + 1][i - 1])) {
		                pal[j][i] = true;  
		            }
		        }
		    }
		    // iterate every mid and then check: left, mid and right
	for (int i = 1; i < n - 1; ++i) {
		for (int j = i; j < n - 1; ++j) {
			if (pal[0][i - 1] && pal[i][j] && pal[j + 1][n - 1]) return true;
		}
	}

	return false;
	        
	    }
	
}
