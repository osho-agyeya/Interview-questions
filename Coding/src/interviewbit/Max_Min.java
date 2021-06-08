/*completedd
 * Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.

NOTE: You should make minimum number of comparisons.



Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109



Input Format
First and only argument is an integer array A of size N.



Output Format
Return an integer denoting the sum Maximum and Minimum element in the given array.



Example Input
Input 1:

 A = [-2, 1, -4, 5, 3]
Input 2:

 A = [1, 3, 4, 1]


Example Output
Output 1:

 1
Output 2:

 5


Example Explanation
Explanation 1:

 Maximum Element is 5 and Minimum element is -4. (5 + (-4)) = 1. 
Explanation 2:

 Maximum Element is 4 and Minimum element is 1. (4 + 1) = 5.
 */

package interviewbit;

public class Max_Min {

	 public int solve(int[] A) {
	        
	        int[] res = divideAndSolve(A);
	        return res[0]+res[1];
	    }
	    
	    
	    /**
	     * Return an array of 2 elements with min element of the entire array at 0th index 
	     * and max element of the entire array at 1st index. 
	     */
	     
	    private int[] divideAndSolve(int[] A){
	        
	        int n = A.length;
	        int[] ret = new int[2];
	        if(n==1){
	            
	            ret[0]=A[0];
	            ret[1]=A[0];
	            
	        }else{
	            int[] lr = divideAndSolve(Arrays.copyOfRange(A, 0, n/2));
	            int[] rr = divideAndSolve(Arrays.copyOfRange(A, n/2, n));
	            ret[0]=Math.min(lr[0],rr[0]);
	            ret[1]=Math.max(lr[1],rr[1]);
	        }
	        return ret;
	        
	    }
	
}
