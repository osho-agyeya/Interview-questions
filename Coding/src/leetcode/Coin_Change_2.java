//completed

/*
 * t=amount*|coins|
 * 
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1
 

Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
 * 
 * 
 * 
 * 
 */
package leetcode;

public class Coin_Change_2 {

	  public int change(int amount, int[] coins) {
	        int[] dp = new int[amount + 1];
	        dp[0] = 1;
	        for (int coin : coins) {
	            for (int i = coin; i <= amount; i++) {
	                dp[i] += dp[i-coin];
	            }
	        }
	        return dp[amount];
	    }
	
}


/*
 * 
 * 
 * The difference is that if you update dp while:

increasing i then the previous partial result dp[i - coin] is the result that has considered coin already
decreasing i then the previous partial result dp[i - coin] is the result that has not considered coin yet
/** 
 * @return number of ways to make sum s using repeated coins
 */

/*
public static int coinrep(int[] coins, int s) {
    int[] dp = new int[s + 1]; 
    dp[0] = 1;          
    for (int coin : coins)      
        for (int i = coin; i <= s; i++)         
            dp[i] += dp[i - coin];                                  
    return dp[s];
}                                       
                                            
/**
 * @return number of ways to make sum s using non-repeated coins
 */

/*
public static int coinnonrep(int[] coins, int s) {
    int[] dp = new int[s + 1];
    dp[0] = 1;  
    for (int coin : coins)
        for (int i = s; i >= coin; i--)
            dp[i] += dp[i - coin];              
    return dp[s];                                                   
} 
 * 
 * 
 * 
 * 
 * 
 * 
 */
