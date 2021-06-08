/*completed
 * Given a string A and integer B, what is maximal lexicographical stringthat can be made from A if you do atmost B swaps.



Problem Constraints
1 <= |A| <= 9

A contains only digits from 0 to 9.

1 <= B <= 5



Input Format
First argument is string A.

Second argument is integer B.



Output Format
Return a string, the naswer to the problem.



Example Input
Input 1:

A = "254"
B = 1
Input 2:

A = "254'
B = 2


Example Output
Output 1:

 524
Output 2:

 542


Example Explanation
Explanation 1:

 Swap 2 and 5.
Explanation 2:

Swap 2 and 5 then swap 4 and 2.
 */

package interviewbit;

public class Maximal_String {
	
    static String ans;
    public String solve(String A, int B) {
        char[] arr=A.toCharArray();
        ans=A;
        solve(arr,B);
        return ans;
    }
    public void solve(char[] A,int B)
    {
        if(B==0)
            return;
        for(int i=0;i<A.length;i++)
        {
            for(int j=i+1;j<A.length;j++)
            {
                if(A[j]>A[i])
                {
                    swap(A,i,j);
                    if(String.valueOf(A).compareTo(ans)>0)
                        ans=String.valueOf(A);
                    solve(A,B-1);
                    swap(A,i,j);
                }
            }
        }
    }
 
    public void swap(char[] A, int ind , int i)
    {
        char c=A[ind];
        A[ind]=A[i];
        A[i]=c;
    }

}
