/*completedd
 * Given an integer k, return the minimum number of Fibonacci numbers whose sum is equal to k. The same Fibonacci number can be used multiple times.

The Fibonacci numbers are defined as:

F1 = 1
F2 = 1
Fn = Fn-1 + Fn-2 for n > 2.
It is guaranteed that for the given constraints we can always find such Fibonacci numbers that sum up to k.
 

Example 1:

Input: k = 7
Output: 2 
Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ... 
For k = 7 we can use 2 + 5 = 7.
Example 2:

Input: k = 10
Output: 2 
Explanation: For k = 10 we can use 2 + 8 = 10.
Example 3:

Input: k = 19
Output: 3 
Explanation: For k = 19 we can use 1 + 5 + 13 = 19.
 

Constraints:

1 <= k <= 10^9
 */

package leetcode;

public class Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K {
	public int findMinFibonacciNumbers(int k) {
        int a = 1;
        int b = 1;
        int c;
        while (b < k) {
            c = a;
            a = b;
            b = c + b;
        }
        
        int cnt = 0;
        while (k != 0) {
        	if (k >= b) {
        		k = k - b;
        		++cnt;
        	}
            
            c = a;
            a = b - a;
            b = c;
        }
        return cnt;

   }
}
