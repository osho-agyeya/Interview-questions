/* over, Sn , s
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */

package leetcode;

import java.util.Arrays;

public class Coin_Change {//fewest
	
	/*
	 * Approach #3 (Dynamic programming - Bottom up) [Accepted]
Algorithm

For the iterative solution, we think in bottom-up manner. Before calculating F(i)F(i), we have to compute all minimum counts for amounts up to ii. On each iteration ii of the algorithm F(i)F(i) is computed as \min_{j=0 \ldots n-1}{F(i -c_j)} + 1min 
j=0…n−1
​
 F(i−c 
j
​
 )+1

Bottom-up approach using a table to build up the solution to F6.

In the example above you can see that:

\begin{aligned} F(3) &= \min\{{F(3- c_1), F(3-c_2), F(3-c_3)}\} + 1 \\ &= \min\{{F(3- 1), F(3-2), F(3-3)}\} + 1 \\ &= \min\{{F(2), F(1), F(0)}\} + 1 \\ &= \min\{{1, 1, 0}\} + 1 \\ &= 1 \end{aligned} 
F(3)
​
  
=min{F(3−c 
1
​
 ),F(3−c 
2
​
 ),F(3−c 
3
​
 )}+1
=min{F(3−1),F(3−2),F(3−3)}+1
=min{F(2),F(1),F(0)}+1
=min{1,1,0}+1
=1
​
 


Complexity Analysis

Time complexity : O(S*n)O(S∗n). On each step the algorithm finds the next F(i)F(i) in nn iterations, where 1\leq i \leq S1≤i≤S. Therefore in total the iterations are S*nS∗n.
Space complexity : O(S)O(S). We use extra space for the memoization table.
	 * 
	 * 
	 */

	public int coinChange(int[] coins, int s) {
	    
	    int[] dp = new int[s + 1]; 
	Arrays.fill(dp, s+1); 
	dp[0] = 0;          
	for (int coin : coins)      
	for (int i = coin; i <= s; i++)         
	    dp[i]= Math.min(dp[i - coin]+1,dp[i]);                                  
	return dp[s] > s ? -1 : dp[s];

	}
	
}
