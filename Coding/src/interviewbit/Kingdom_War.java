/*completed
 * Two kingdoms are on a war right now, kingdom X and kingdom Y. As a war specialist of kingdom X, you scouted kingdom Y area.

A kingdom area is defined as a N x M grid with each cell denoting a village.
Each cell has a value which denotes the strength of each corresponding village.
The strength can also be negative, representing those warriors of your kingdom who were held hostages.

There�s also another thing to be noticed.

The strength of any village on row larger than one (2<=r<=N) is stronger or equal to the strength of village which is exactly above it.
The strength of any village on column larger than one (2<=c<=M) is stronger or equal to the strength of vilage which is exactly to its left.
(stronger means having higher value as defined above).
So your task is, find the largest sum of strength that you can erase by bombing one sub-matrix in the grid.

Input format:

First line consists of 2 integers N and M denoting the number of rows and columns in the grid respectively.
The next N lines, consists of M integers each denoting the strength of each cell.

1 <= N <= 1500
1 <= M <= 1500
-200 <= Cell Strength <= 200
Output:

The largest sum of strength that you can get by choosing one sub-matrix.
Example:

Input:
3 3
-5 -4 -1
-3 2 4
2 5 8

Output:
19

Explanation:
Bomb the sub-matrix from (2,2) to (3,3): 2 + 4 + 5 + 8 = 19
 */

package interviewbit;

public class Kingdom_War {
	
	 public int solve(int[][] mat) {
		 int m = mat.length;
		        int n = mat[0].length;
		        int preSum[][] = new int[m + 1][n];
		 
		        for (int i = 0; i < m; i++)
		        {
		            for (int j = 0; j < n; j++)
		            {
		                preSum[i + 1][j] =
		                   preSum[i][j] + mat[i][j];
		            }
		        }
		 
		        int maxSum = -1;
		        int minSum = Integer.MIN_VALUE;
		        int negRow = 0, negCol = 0;
		        int rStart = 0, rEnd = 0, cStart = 0, cEnd = 0;
		        for (int rowStart = 0;
		             rowStart < m;
		             rowStart++)
		        {
		            for (int row = rowStart; row < m; row++)
		            {
		                int sum = 0;
		                int curColStart = 0;
		                for (int col = 0; col < n; col++)
		                {
		                    sum += preSum[row + 1][col]
		                           - preSum[rowStart][col];
		                    if (sum < 0) {
		                        if (minSum < sum) {
		                            minSum = sum;
		                            negRow = row;
		                            negCol = col;
		                        }
		                        sum = 0;
		                        curColStart = col + 1;
		                    }
		                    else if (maxSum < sum)
		                    {
		                        maxSum = sum;
		                        rStart = rowStart;
		                        rEnd = row;
		                        cStart = curColStart;
		                        cEnd = col;
		                    }
		                }
		            }
		        }
		        return maxSum == -1 ? minSum : maxSum;
		    }

}
