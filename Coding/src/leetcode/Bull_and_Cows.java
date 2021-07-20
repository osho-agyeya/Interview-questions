/* over, n, n
 * 
 * You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.

 

Example 1:

Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"
Example 2:

Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
Example 3:

Input: secret = "1", guess = "0"
Output: "0A0B"
Example 4:

Input: secret = "1", guess = "1"
Output: "1A0B"
 

Constraints:

1 <= secret.length, guess.length <= 1000
secret.length == guess.length
secret and guess consist of digits only.
 * 
 */

package leetcode;

public class Bull_and_Cows {
	
	/*
	 * 
	 * Approach 2: One Pass
Intuition

Let's optimize approach 1 by building the hashmap during the strings' parsing. That would allow us to reduce the number of passes to one.

Algorithm

Initialize the number of bulls and cows to zero.

Initialize the hashmap to count characters. During the iteration, secret string gives a positive contribution, and guess - negative contribution.

Iterate over the strings: s is the current character in the string secret and g - the current character in the string guess.

If s == g, update bulls counter: bulls += 1.

Otherwise, if s != g:

Update cows by adding 1 if so far guess contains more s characters than secret: h[s] < 0.

Update cows by adding 1 if so far secret contains more g characters than guess: h[g] > 0.

Update the hashmap by marking the presence of s character in the string secret: h[s] += 1.

Update the hashmap by marking the presence of g character in the string guess: h[g] -= 1.

Return the number of bulls and cows.

Implementation


To further optimize the Java solution, one could use an array instead of hashmap because there are known problems with Java HashMap performance. Another small improvement is to replace string concatenation by a StringBuilder.


Complexity Analysis

Time complexity: \mathcal{O}(N)O(N), we do one pass over the strings.

Space complexity: \mathcal{O}(1)O(1) to keep hashmap (or array) h which contains at most 10 elements.


	 */
	
	public String getHint(String secret, String guess) {
	    int bulls = 0;
	    int cows = 0;
	    int[] numbers = new int[10];
	    for (int i = 0; i<secret.length(); i++) {
	        if (secret.charAt(i) == guess.charAt(i)) bulls++;
	        else {
	            if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
	            if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
	        }
	    }
	    return bulls + "A" + cows + "B";
	}

}
