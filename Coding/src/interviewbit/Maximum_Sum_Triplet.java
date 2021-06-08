/*completedd
 * Given an array A containing N integers.

You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.

If no such triplet exist return 0.



Problem Constraints
3 <= N <= 105.

1 <= A[i] <= 108.



Input Format
First argument is an integer array A.



Output Format
Return a single integer denoting the maximum sum of triplet as described in the question.



Example Input
Input 1:

 A = [2, 5, 3, 1, 4, 9]
Input 2:

 A = [1, 2, 3]


Example Output
Output 1:

 16
Output 2:

 6


Example Explanation
Explanation 1:

 All possible triplets are:-
    2 3 4 => sum = 9
    2 5 9 => sum = 16
    2 3 9 => sum = 14
    3 4 9 => sum = 16
    1 4 9 => sum = 14
  Maximum sum = 16
Explanation 2:

 All possible triplets are:-
    1 2 3 => sum = 6
 Maximum sum = 6
 */

package interviewbit;

public class Maximum_Sum_Triplet {
	
	 public int solve(int[] A) {
		 TreeSet<Integer>st= new TreeSet<Integer>();
		         int []suffixMax= new int[A.length+1];
		         suffixMax[A.length]=0;
		         for(int i=A.length-1;i>=0;i--){
		             suffixMax[i]=Math.max(suffixMax[i+1],A[i]);
		         }
		         int maxElement=0;
		         st.add(Integer.MIN_VALUE);
		         for(int i=0;i<A.length-1;i++){
		             if(suffixMax[i+1]>A[i]){
		                 int val=st.lower(A[i]);
		                 maxElement=Math.max(suffixMax[i+1]+A[i]+val,maxElement);
		             }
		             st.add(A[i]);
		         }
		         return maxElement;
		     }

}
