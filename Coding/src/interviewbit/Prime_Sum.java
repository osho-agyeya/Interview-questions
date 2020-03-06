//done
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

public class Prime_Sum {
	
	private boolean isPrime(int a){
        for(int i=2;i<=(int)Math.sqrt(a);i++){
            if(a%i==0)
                return false;
        }
        return true;
    }
    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> x= new ArrayList<Integer>();
        for(int i=2;i<a;i++){
            if(isPrime(i)&&isPrime(a-i)){
                x.add(i);
                x.add(a-i);
                break;
            }
        }
        
        return x;
        
        
    }

}
