//doe
/*
 * Max Sum Without Adjacent Elements
Asked in:  
Epic systems
Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers
is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.

Input Format:

The first and the only argument of input contains a 2d matrix, A.
Output Format:

Return an integer, representing the maximum possible sum.
Constraints:

1 <= N <= 20000
1 <= A[i] <= 2000
Example:

Input 1:
    A = [   [1]
            [2]    ]

Output 1:
    2

Explanation 1:
    We will choose 2.

Input 2:
    A = [   [1, 2, 3, 4]
            [2, 3, 4, 5]    ]
    
Output 2:
    We will choose 3 and 5.
 */

package interviewbit;

public class Max_Sum_Without_Adjacent_Elements {
	
	public int adjacent(int[][] A) {
        int l= A[0].length;
        int[] a = new int[l+1];
        a[1]=Math.max(A[0][0],A[1][0]);
        for(int i=2 ;i<l+1;i++){
            a[i]=Math.max(a[i-1],a[i-2]+Math.max(A[0][i-1],A[1][i-1]));
        }
        return a[l];
    }

}
