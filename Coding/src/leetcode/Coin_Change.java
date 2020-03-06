//done

/*
 * t=amount*|coins|
 * 
 * 
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 * 
 * 
 * 
 */

package leetcode;

import java.util.Arrays;

public class Coin_Change {//fewest

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
