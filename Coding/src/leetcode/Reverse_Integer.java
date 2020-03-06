//done
/*
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

package leetcode;

public class Reverse_Integer {

	public int reverse(int x) {
		String reversed = new        StringBuilder().append(Math.abs(x)).reverse().toString();
		try {
			return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
