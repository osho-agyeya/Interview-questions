/* over, n2, 1
 * Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Note:

The input string length won't exceed 1000.
 * 
 * 
 */
package leetcode;

public class Palindromic_Substrings {
	
	/*
	 * 
	 * Approach #3: Expand Around Possible Centers
Intuition

Palindromes are like onions, you remove the boundary characters and you're left with another, smaller palindrome.

Multiple palindromes have the same centers. If we choose a center, we can continue to expand around it as long as we can make larger and larger palindromes.

Let's take the string "lever" as an example: if you choose the character 'v' as the center, one can see that the palindromes "v" and "eve" are possible. However, the final expansion "lever" is not a palindrome (the first and last characters don't match).

Algorithm

We choose all possible centers for potential palindromes:

Every single character in the string is a center for possible odd-length palindromes
Every pair of consecutive characters in the string is a center for possible even-length palindromes.
For every center, we can expand around it as long as we get palindromes (i.e. the first and last characters should match).


Complexity Analysis

Time Complexity: O(N^2)O(N 
2
 ) for input string of length NN. The total time taken in this approach is dictated by two variables:

The number of possible palindromic centers we process.
How much time we spend processing each center.
The number of possible palindromic centers is 2N-12N−1: there are NN single character centers and N-1N−1 consecutive character pairs as centers.

Each center can potentially expand to the length of the string, so time spent on each center is linear on average. Thus total time spent is N \cdot (2N-1) \simeq N^2N⋅(2N−1)≃N 
2
 .

Space Complexity: O(1)O(1). We don't need to allocate any extra space since we are repeatedly iterating on the input string itself.


	 * 
	 */
	
	int count = 0;
    public int countSubstrings(String s) {
        
    
    
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}
