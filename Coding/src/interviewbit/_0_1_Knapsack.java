/*completed
 * 
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


Problem Constraints
1 <= N <= 103

1 <= C <= 103

1 <= A[i], B[i] <= 103



Input Format
First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format
Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input
Input 1:

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10


Example Output
Output 1:

 220
Output 2:

 0


Example Explanation
Explanation 1:

 Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
Explanation 2:

 Knapsack capacity is 10 but each item has weight greater than 10 so no items can be c
 */

package interviewbit;

public class _0_1_Knapsack {
	
	 public int solve(int[] val, int[] wt, int W) {
	        // Declare the table dynamically
	        int N=val.length;
	    int dp[][] = new int[N + 1][W + 1];
	     
	    // Loop to initially filled the
	    // table with -1
	    for(int i = 0; i < N + 1; i++)  
	        for(int j = 0; j < W + 1; j++)  
	            dp[i][j] = -1;   
	     
	    return knapSackRec(W, wt, val, N, dp);   
	        
	    }
	    
	     int knapSackRec(int W, int wt[],
	                       int val[], int n,
	                       int [][]dp)
	{  
	     
	    // Base condition
	    if (n == 0 || W == 0)  
	        return 0;
	         
	    if (dp[n][W] != -1)
	        return dp[n][W];  
	     
	    if (wt[n - 1] > W)  
	     
	        // Store the value of function call  
	        // stack in table before return
	        return dp[n][W] = knapSackRec(W, wt, val,
	                                      n - 1, dp);
	                                       
	    else
	     
	        // Return value of table after storing 
	        return dp[n][W] = Math.max((val[n - 1] +
	                              knapSackRec(W - wt[n - 1], wt,
	                                          val, n - 1, dp)),
	                              knapSackRec(W, wt, val,
	                                          n - 1, dp));            
	}

}
