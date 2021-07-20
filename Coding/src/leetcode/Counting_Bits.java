/* over, n, n
 * 
 * 
Given an integer num, return an array of the number of 1's in the binary representation of every number in the range [0, num].

 

Example 1:

Input: num = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: num = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= num <= 105
 

Follow up:

It is very easy to come up with a solution with run time O(32n). Can you do it in linear time O(n) and possibly in a single pass?
Could you solve it in O(n) space complexity?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 *
 *
 */
package leetcode;

public class Counting_Bits {
	
	/*
	 * 
	 * Approach #3 DP + Least Significant Bit [Accepted]
Intuition

We can have different transition functions, as long as x'x 
′
  is smaller than xx and their pop counts have a function.

Algorithm

Following the same principle of the previous approach, we can also have a transition function by playing with the least significant bit.

Let look at the relation between xx and x' = x / 2x 
′
 =x/2

x = (1001011101)_2 = (605)_{10}x=(1001011101) 
2
​
 =(605) 
10
​
 

x' = (100101110)_2 = (302)_{10}x 
′
 =(100101110) 
2
​
 =(302) 
10
​
 

We can see that x'x 
′
  is differ than xx by one bit, because x'x 
′
  can be considered as the result of removing the least significant bit of xx.

Thus, we have the following transition function of pop count P(x)P(x):

P(x) = P(x / 2) + (x \mod 2)P(x)=P(x/2)+(xmod2)


Complexity Analysis

Time complexity : O(n)O(n). For each integer xx we need constant operations which do not depend on the number of bits in xx.

Space complexity : O(n)O(n). Same as approach #2.

Approach #4 DP + Last Set Bit [Accepted]
Algorithm

With the same logic as previous approaches, we can also manipulate the last set bit.

Last set bit is the rightmost set bit. Setting that bit to zero with the bit trick, x &= x - 1, leads to the following transition function:

P(x) = P(x \mathrel{\&} (x - 1)) + 1;P(x)=P(x&(x−1))+1;


Complexity Analysis

Time complexity : O(n)O(n). Same as approach #3.

Space complexity : O(n)O(n). Same as approach #3.
	 * 
	 */
	
	public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            result[i] = result[i>>1] + i&1;
        }
        return result;
    }

}
