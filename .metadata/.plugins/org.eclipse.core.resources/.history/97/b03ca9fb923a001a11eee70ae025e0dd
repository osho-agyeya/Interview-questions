//doe
/*
 * Kth Manhattan Distance Neighbourhood
Asked in:  
Liv.ai
Problem Setter: ishubansal Problem Tester: raghav_aggiwal
Given a matrix M of size nxm and an integer K, find the maximum element in the K manhattan distance neighbourhood for all elements in nxm matrix.
In other words, for every element M[i][j] find the maximum element M[p][q] such that abs(i-p)+abs(j-q) <= K.

Note: Expected time complexity is O(N*N*K)

Constraints:

1 <= n <= 300
1 <= m <= 300
1 <= K <= 300
0 <= M[i][j] <= 1000
Example:

Input:
M  = [[1,2,4],[4,5,8]] , K = 2

Output:
ans = [[5,8,8],[8,8,8]]

 */

package interviewbit;

import java.util.ArrayList;

public class Kth_Manhattan_Distance_Neighbourhood {
	
	 public ArrayList<ArrayList<Integer>> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int n= B.size(), m= B.get(0).size(), min= Integer.MIN_VALUE;
        int[][][] dp= new int[A+ 1][n][m];
        for (int k= 0; k<= A; k++) {
            for (int i= 0; i< n; i++) {
                for (int j= 0; j< m; j++) {
                    if (k== 0) {
                        dp[k][i][j]= B.get(i).get(j);
                    }
                    else { 
                        int cur= min;
                        if (i> 0)   cur= Math.max(cur, dp[k- 1][i- 1][j]);
                       if (j> 0)   cur= Math.max(cur, dp[k- 1][i][j- 1]);
                       if (i< n- 1)    cur= Math.max(cur, dp[k- 1][i+ 1][j]);
                        if (j< m- 1)    cur= Math.max(cur, dp[k- 1][i][j+ 1]);
                        dp[k][i][j]= Math.max(cur, dp[k- 1][i][j]);
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
    for (int i= 0; i< n; i++) {
           ArrayList<Integer> c= new ArrayList<>();
           for (int j= 0; j< m; j++) {
                c.add (dp[A][i][j]);
            }
            res.add(c);
        }
        return res;
    }

}
