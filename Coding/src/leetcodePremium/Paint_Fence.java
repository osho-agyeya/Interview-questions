/*completedd
There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color. 
Return the total number of ways you can paint the fence. 
Note:
n and k are non-negative integers. * 
 * 
 */
package leetcodePremium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Paint_Fence {

	public int numWays(int n, int k) {
	    int dp[] = {0, k , k*k, 0};
	 
	    if(n <= 2)
	        return dp[n];
	 
	    for(int i = 2; i < n; i++){
	        dp[3] = (k - 1) * (dp[1] + dp[2]);
	        dp[1] = dp[2];
	        dp[2] = dp[3];
	    }
	 
	    return dp[3];
	}
	
}
