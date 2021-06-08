/* completedd
 * 
 * Given a number N, verify if N is prime or not.

Return 1 if N is prime, else return 0.

Example :

Input : 7
Output : True
Problem Approach:

Complete code in the hint.
 * 
 */
package interviewbit;

public class Verify_Prime {
	
	 public int isPrime(int a) {
	        int i;
	        if(a==1 || a==2 || a==3) return 0;
	                int t=(int)Math.sqrt(a);
	            for (i = 2; i <=t;i++){
	                if(a%i==0)
	                   return 0;
	            }
	                return 1;
	    }

}
