/* over, log n, 1 
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
 */

package leetcode;

public class Pow_x_n {
	
	/*
	 * Approach 3: Fast Power Algorithm Iterative
Intuition

Using the formula x ^ {a + b} = x ^ a * x ^ bx 
a+b
 =x 
a
 ∗x 
b
 , we can write n as a sum of positive integers, n = \sum_i b_in=∑ 
i
​
 b 
i
​
 . If we can get the result of x ^ {b_i}x 
b 
i
​
 
  quickly, the total time for computing x ^ nx 
n
  will be reduced.

Algorithm

We can use the binary representation of n to better understand the problem. Let the binary representation of n to be b_1, b_2, ..., b_{length\_limit}b 
1
​
 ,b 
2
​
 ,...,b 
length_limit
​
 , from the Least Significant Bit(LSB) to the Most Significant Bit(MSB). For the ith bit, if b_i = 1b 
i
​
 =1, it means we need to multiply the result by x ^ {2 ^ i}x 
2 
i
 
 .

It seems to have no improvement with this representation, since \sum_i b_i * 2 ^ i = n∑ 
i
​
 b 
i
​
 ∗2 
i
 =n. But using the formula (x ^ n) ^ 2 = x ^ {2 * n}(x 
n
 ) 
2
 =x 
2∗n
  we mentioned above, we can see some differences. Initially x ^ 1 = xx 
1
 =x, and for each i > 1i>1, we can use the result of x ^ {2 ^ {i - 1}}x 
2 
i−1
 
  to get x ^ {2 ^ i}x 
2 
i
 
  in one step. Since the number of b_ib 
i
​
  is at most O(\log n)O(logn), we can get all x ^ {2 ^ i}x 
2 
i
 
  in O(\log n)O(logn) time. After that, for all is that satisfy b_i = 1b 
i
​
 =1, we can multiply x ^ {2 ^ i}x 
2 
i
 
  to the result. This also requires O(\log n)O(logn) time.

Using fast power recursively or iteratively are actually taking different paths towards the same goal. For more information about fast power algorithm, you can visit its wiki[1].
	 * 
	 * 
	 */
	
	 public double myPow(double x, int n) {
	        long N = n;
	        if (N < 0) {
	            x = 1 / x;
	            N = -N;
	        }
	        double ans = 1;
	        double current_product = x;
	        for (long i = N; i > 0; i /= 2) {
	            if ((i % 2) == 1) {
	                ans = ans * current_product;
	            }
	            current_product = current_product * current_product;
	        }
	        return ans;
	    }

}
