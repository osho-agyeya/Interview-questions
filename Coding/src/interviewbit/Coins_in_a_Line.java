//completed
/*
 * Coins in a Line
There are A coins (Assume A is even) in a line.

Two players take turns to take a coin from one of the ends of the line until there are no more coins left.

The player with the larger amount of money wins.

Assume that you go first.

Return the maximum amount of money you can win.

Input Format:

The first and the only argument of input contains an integer array, A.
Output Format:

Return an integer representing the maximum amount of money you can win.
Constraints:

1 <= length(A) <= 500
1 <= A[i] <= 1e5
Examples:

Input 1:
    A = [1, 2, 3, 4]

Output 1:
    6

Explanation 1:
    
    You      : Pick 4
    Opponent : Pick 3
    You      : Pick 2
    Opponent : Pick 1
    
    Total money with you : 4 + 2 = 6

Input 2:
    A = [5, 4, 8, 10]
    
Output 2:
    15

Explanation 2:

    You      : Pick 10
    Opponent : Pick 8
    You      : Pick 5
    Opponent : Pick 4
    
    Total money with you : 10 + 5 = 15
 */

package interviewbit;

import java.util.Arrays;

public class Coins_in_a_Line {
	
	 private int fun(int l, int r, int[] a, int[][] mem){
        if(l == r)
            return a[l];
        if(l > r)
            return 0;
        if(mem[l][r] != -1)
            return mem[l][r];
        mem[l][r] = Integer.max(a[l]+
        							Integer.min(fun(l+1, r-1, a, mem), fun(l+2, r, a, mem)),
        						a[r]+
        							Integer.min(fun(l+1, r-1, a, mem), fun(l, r-2, a, mem)));
        return mem[l][r];
    }
    
    public int maxcoin(int[] a) {
        int n = a.length;
        int[][] mem = new int[n][n];
        for(int i = 0; i<n; i++)
            Arrays.fill(mem[i], -1);
        return fun(0, a.length-1, a, mem);
    }

}
