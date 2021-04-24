//completed

/*
 * 
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

 

Example 1:

Input: n = 13
Output: 6
Example 2:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 2 * 109
 * 
 */

package leetcode;

public class Number_of_Digit_One {
	
	public int countDigitOne(int n) {
		  int count = 0;
		    
		  for (long k = 1; k <= n; k *= 10) {
		    long r = n / k, m = n % k;
		    // sum up the count of ones on every place k
		    count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
		  }
		    
		  return count;
		}

}
