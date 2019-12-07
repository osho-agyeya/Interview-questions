//done
/*
 * Minimize the absolute difference
Asked in:  
Microsoft
Problem Setter: ganeshk2 Problem Tester: dhruvi
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 */
package interviewbit;

import java.util.ArrayList;

public class Minimize_the_absolute_difference {
	
	    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i = 0, j = 0, k = 0;
        int ans = Integer.MAX_VALUE;
        
        int max, min;
        
        while(i < A.size() && j < B.size() && k < C.size()) {
            
            max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            
            ans = Math.min(ans, max-min);
            if(ans == 0)
            break;
            
            if(A.get(i) == min)
            i++;
            else if(B.get(j) == min)
            j++;
            else
            k++;
        }
        
        return ans;
    }

}
