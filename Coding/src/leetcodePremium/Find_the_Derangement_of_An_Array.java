/* completed
 * In combinatorial mathematics, a derangement is a permutation of the elements of a set, such that no element appears in its original position. 
There's originally an array consisting of n integers from 1 to n in ascending order, you need to find the number of derangement it can generate. 
Also, since the answer may be very large, you should return the output mod 109 + 7. 
Example 1:
Input: 3
Output: 2
Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] and [3,1,2].

Note:
n is in the range of [1, 106]. 
 */

package leetcodePremium;

public class Find_the_Derangement_of_An_Array {
	
    public int findDerangement(int n) {
        int mod = 1000000007;
        long[] dp = new long[n+1];
        dp[0] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = ((i - 1) * ((dp[i-2] + dp[i-1]) % mod)) % mod;
        }
        return (int)dp[n];
    }
}
