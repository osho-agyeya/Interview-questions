//ddoe
/*
 * Prime Sum
Asked in:  
Epic systems
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 
 */

package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class Prime_Numbers {
	
	 public ArrayList<Integer> sieve(int A) {
	        boolean prime [] = new boolean[A + 1];
	        Arrays.fill(prime, true);
	        prime[0] = prime[1] = false;
	        
	        for (int i = 2; i <= A; i++) {
	            if (!prime[i])
	                continue;
	                
	            for (long j = 1L * i * i; j <= (long) A; j += i)
	                prime[(int) j] = false;
	        }
	        
	        ArrayList<Integer> res = new ArrayList<>();
	        
	        for (int i = 0; i <= A; i++) {
	            if (prime[i])
	                res.add(i);
	        }
	        
	        return res;
	    }
	

}
