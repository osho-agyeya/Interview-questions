/*completedd
 * Given a string A and integer B, remove all consecutive same characters that have length exactly B.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= |A|



Input Format
First Argument is string A.

Second argument is integer B.



Output Format
Return a string after doing the removals.



Example Input
Input 1:

A = "aabcd"
B = 2
Input 2:

A = "aabbccd"
B = 2


Example Output
Output 1:

 "bcd"
Output 2:

 "d"


Example Explanation
Explanation 1:

 "aa" had length 2.
Explanation 2:

 "aa", "bb" and "cc" had length of 2.
 */

package interviewbit;

public class Remove_Consecutive_Characters {
	
	 public String solve(String A, int B) {
	        StringBuilder sb=new StringBuilder();
	        if(B==1){
	            return A;
	        }
	        for(int i=0;i<A.length();){
	            int j=i+1;
	            while(j<A.length() && A.charAt(i)==A.charAt(j)){
	                j++;
	            }
	            if(j-i!=B){
	                sb.append(A.charAt(i));
	            }
	            i=j;
	        }
	        return sb.toString();
	    }

}
