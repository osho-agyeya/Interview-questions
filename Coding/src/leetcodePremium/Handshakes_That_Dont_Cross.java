/* completedd
 * You are given an even number of people num_people that stand around a circle and each person shakes hands with someone else, so that there are num_people / 2 handshakes total.

Return the number of ways these handshakes could occur such that none of the handshakes cross.

Since this number could be very big, return the answer mod 10^9 + 7

 

Example 1:

Input: num_people = 2
Output: 1
Example 2:



Input: num_people = 4
Output: 2
Explanation: There are two ways to do it, the first way is [(1,2),(3,4)] and the second one is [(2,3),(4,1)].
Example 3:



Input: num_people = 6
Output: 5
Example 4:

Input: num_people = 8
Output: 14
 

Constraints:

2 <= num_people <= 1000
num_people % 2 == 0
 */

package leetcodePremium;

public class Handshakes_That_Dont_Cross {
	
	public int numberOfWays(int num_people) {
        int numPairs = num_people / 2;
        if (numPairs == 0 || numPairs == 1)
            return 1;
        final int MODULO = 1000000007;
        long[] dp = new long[numPairs + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= numPairs; i++) {
            for (int j = 0; j < i; j++)
                dp[i] = (dp[i] + dp[j] * dp[i - j - 1]) % MODULO;
        }
        return (int) (dp[numPairs] % MODULO);
    }

}
