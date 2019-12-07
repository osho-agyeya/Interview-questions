//not done

/*
 * Flip Array
Given an array of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible). Return the minimum no. of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.

Constraints:

 1 <= n <= 100
Sum of all the elements will not exceed 10,000.

Example:

A = [15, 10, 6]
ans = 1 (Here, we will flip the sign of 15 and the resultant sum will be 1 )

A = [14, 10, 4]
ans = 1 (Here, we will flip the sign of 14 and the resultant sum will be 0)

 Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there are not minimum 
 */

package interviewbit;

import java.util.List;

public class Flip_Array {
	
	
	public int solve(final List<Integer> a) {
        int n = a.size();
        int sum = a.stream().mapToInt(Integer::intValue).sum();
        int half = sum / 2; // target sum is half total
        int[][] dp = new int[n + 1][half + 1];
        
        // initialize no options dp[row] == 0
        int maxInt = 10001; // sum of all elements will not exceed 10,000
        // set initial option's output to int max
        for (int h = 1; h <= half; h++) {
            dp[0][h] = maxInt;
        }
        
        // iterate from 1 to half sum
        // decide whether to use option 
        // (current sum - option value) + 1 < previous option
        // or not
        // dp[m + 1] will be updated since [m] may be carrying initial int max
        for (int h = 1; h <= half; h++) {
            for (int m = 0; m < n; m++) {
                // memoize dp[m + 1][h]
                
                int now = a.get(m);
                // sum is greater than current option's value
                // so we can go back to that (sum - option's value) memoization
                // and determine if plus one flip is better than 
                // current carrying calculations
                if (now <= h && dp[m][h] > dp[m][h - now] + 1) {
                    dp[m + 1][h] = dp[m][h - now] + 1;
                } else {
                    dp[m + 1][h] = dp[m][h]; // carry previous calculation
                }               
            }
        }
        // utilities.MatrixUtilities.print2DArray(dp);
        for (int h = half; h >= 0; h--) {
            if (dp[n][h] != maxInt) {
                return dp[n][h];
            }            
        }
        
        return dp[n][0];
    }
}
