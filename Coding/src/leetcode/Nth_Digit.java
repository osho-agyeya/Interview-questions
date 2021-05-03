/*completed
 * Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].

 

Example 1:

Input: n = 3
Output: 3
Example 2:

Input: n = 11
Output: 0
Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 

Constraints:

1 <= n <= 231 - 1
 */

package leetcode;

public class Nth_Digit {

	public int findNthDigit(int n) {
		int len = 1, i = 1;
		long range = 9;
		while(n > len * range){
			n -= len * range;
			len++;
			range *= 10;
			i *= 10;
		}

		i += (n - 1) / len;
		String s = Integer.toString(i);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
	
}
