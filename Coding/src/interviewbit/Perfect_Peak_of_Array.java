/*completedd
 * Given an integer array A of size N.

You need to check that whether there exist a element which is strictly greater than all the elements on left of it and strictly smaller than all the elements on right of it.

If it exists return 1 else return 0.

NOTE:

Do not consider the corner elements i.e A[0] and A[N-1] as the answer.


Problem Constraints
3 <= N <= 105

1 <= A[i] <= 109



Input Format
First and only argument is an integer array A containing N integers.



Output Format
Return 1 if there exist a element that is strictly greater than all the elements on left of it and strictly smaller than all the elements on right of it else return 0.



Example Input
Input 1:

 A = [5, 1, 4, 3, 6, 8, 10, 7, 9]
Input 2:

 A = [5, 1, 4, 4]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 A[4] = 6 is the element we are looking for.
 All elements on left of A[4] are smaller than it and all elements on right are greater.
Explanation 2:

 No such element exits.
 */

package interviewbit;

public class Perfect_Peak_of_Array {
	
	public int perfectPeak(int[] A) {
		int n=A.length;
		        int rightMin[]=new int[n];
		        int leftMax[]=new int[n];
		        int max=A[0];
		        for(int i=0;i<n;i++)
		        {
		            max=Math.max(A[i],max);
		            leftMax[i]=max;
		           // System.out.print(leftMax[i]+" "+max);
		        }
		        int min=A[n-1];
		        for(int i=n-1;i>=0;i--)
		        {
		            min=Math.min(A[i],min);
		            rightMin[i]=min;
		        }
		        int k=0;
		        //System.out.println(max+" "+min);
		        for(int i=1;i<n-1;i++)
		        {
		            if(A[i]>leftMax[i-1]&&A[i]<rightMin[i+1])
		            {
		                k=1;
		                break;
		            }
		            
		        }
		        return k;
		    }

}
