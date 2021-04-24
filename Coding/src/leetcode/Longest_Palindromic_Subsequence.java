//completed
/*
 * 
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
 * 
 * 
 */
package leetcode;

public class Longest_Palindromic_Subsequence {
	
	public int longestPalindromeSubseq(String s) {
        char[] str=s.toCharArray();
        int T[][] = new int[str.length][str.length];
        for(int i=0; i < str.length; i++){
            T[i][i] = 1;
        }
        for(int l = 2; l <= str.length; l++){
            for(int i = 0; i < str.length-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
                System.out.println(i+","+j+","+l);
            }
        }
        return T[0][str.length-1];
        
    }

}
