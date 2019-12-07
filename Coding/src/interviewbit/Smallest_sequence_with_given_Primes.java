//done
/*
 * Smallest sequence with given Primes
Asked in:  
Booking.com
Microsoft
Problem Setter: RAMBO_tejasv Problem Tester: aayushkapadia
Given three prime number(p1, p2, p3) and an integer k. Find the first(smallest) k integers which have only p1, p2, p3 or a combination of them as their prime factors.

Example:

Input :
Prime numbers : [2,3,5]
k : 5

If primes are given as p1=2, p2=3 and p3=5 and k is given as 5, then the sequence of first 5 integers will be:

Output:
{2,3,4,5,6}

Explanation :
4 = p1 * p1 ( 2 * 2 )
6 = p1 * p2 ( 2 * 3 )

Note: The sequence should be sorted in ascending order
 */

package interviewbit;

import java.util.ArrayList;

public class Smallest_sequence_with_given_Primes {
	
	public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> res = new ArrayList<>();
        int indexA = 0, indexB = 0, indexC=0;
        res.add(1);
        while (D-- > 0) {
            int A1 = res.get(indexA)*A;
            int A2 = res.get(indexB)*B;
            int A3 = res.get(indexC)*C;
            int min = Math.min(A1, Math.min(A2, A3));
            res.add(min);
            if (min == A1) { ++indexA;}
            if(min == A2) { ++indexB; }
            if(min == A3) { ++indexC;}
        }
        res.remove(0);
        return res;
    }

}
