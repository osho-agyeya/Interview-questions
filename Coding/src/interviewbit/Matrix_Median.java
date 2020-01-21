//ddoe
/*
 * Matrix Median
Asked in:  
Amazon
Given a matrix of integers A of size N x M in which each row is sorted.

Find an return the overall median of the matrix A.

Note: No extra memory is allowed.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Input Format

The first and only argument given is the integer matrix A.
Output Format

Return the overall median of the matrix A.
Constraints

1 <= N, M <= 10^5
1 <= N*M  <= 10^6
1 <= A[i] <= 10^9
N*M is odd
For Example

Input 1:
    A = [   [1, 3, 5],
            [2, 6, 9],
            [3, 6, 9]   ]
Output 1:
    5
Explanation 1:
    A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
    Median is 5. So, we return 5.

Input 2:
    A = [   [5, 17, 100]    ]
Output 2:
    17 ``` Matrix=
 */

package interviewbit;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Matrix_Median {
	
	public int findMedian(ArrayList<ArrayList<Integer>> A) {
        if ( A == null || A.size() == 0 )
            return 0;
        
        int N = A.size();
        int M = A.get( 0 ).size();
        int medIdx = N*M / 2;
        
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>( N, (a1,a2)->Integer.compare( a1.get( 0 ), a2.get( 0 ) ));  
        ;
        
        for ( int i = 0; i < N; i++ ) {
            queue.offer( A.get( i ) );
        }
        
        int idx = 0;
        int num = 0;
        while( idx <= medIdx ) {
            ArrayList<Integer> row = queue.poll();
            num = row.remove( 0 );
            if ( row.size() > 0 )
                queue.offer( row );
            idx++;
        }
        return num;
    }

}
