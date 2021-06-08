/*completed
 * Given an array A of N non-negative numbers and you are also given non-negative number B.

You need to find the number of subarrays in A having sum less than B. We may assume that there is no overflow.



Problem Constraints
1 <= N <= 104

1 <= A[i] <= 100

1 <= B <= 108



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the number of subarrays in A having sum less than B.



Example Input
Input 1:

 A = [2, 5, 6]
 B = 10
Input 2:

 A = [1, 11, 2, 3, 15]
 B = 10


Example Output
Output 1:

 4
Output 2:

 4


Example Explanation
Explanation 1:

 The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
Explanation 2:

 The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
 * 
 */

package interviewbit;

public class Counting_Subarrays {
	
	 public int solve(ArrayList<Integer> A, int B) {
	        int t1=0,t2=0,sum=0,c=0;
	        while(t2<A.size()){
	            if(sum+A.get(t2)<B){
	                sum+=A.get(t2);
	                c+=(t2-t1+1);
	                t2++;
	            }
	            else{
	                sum-=(A.get(t1));
	                t1++;
	            }
	        }
	        return c;
	    }

}
