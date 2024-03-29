//ddoe
/*
 * Tushar's Birthday Party
Asked in:  
Snapdeal
Problem Setter: raghav_aggiwal Problem Tester: archit.rai
As it is Tushar�s Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune.
Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar�s friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.
Each friend can take any dish unlimited number of times.
There always exists a dish with filling capacity 1 so that a solution always exists.
Input Format

Friends : List of integers denoting eating capacity of friends separated by space.
Capacity: List of integers denoting filling capacity of each type of dish.
Cost :    List of integers denoting cost of each type of dish.
Constraints:
1 <= Capacity of friend <= 1000
1 <= No. of friends <= 1000
1 <= No. of dishes <= 1000

Example:

Input:
    2 4 6
    2 1 3
    2 5 3

Output:
    14

Explanation: 
    First friend will take 1st and 2nd dish, second friend will take 2nd dish tw
 */

package interviewbit;

import java.util.Arrays;

public class Tushars_Birthday_Party {
	
	 public int solve(final int[] A, final int[] B, final int[] C) {
        int max = 0;
        for(int i=0; i<A.length; i++){
            max = Math.max(max, A[i]);
        }
        
        int[] dp = new int[max+1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        
        for(int i=0; i<B.length; i++){
            for(int j=B[i]; j<=max; j++){
                dp[j] = Math.min(dp[j],C[i]+dp[j-B[i]]);
            }
        }
        
        int result = 0;
        for(int i=0; i<A.length; i++){
            result += dp[A[i]];
        }
        
        return result;
    }

}
