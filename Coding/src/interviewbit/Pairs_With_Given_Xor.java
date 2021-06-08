/* completedd
 * Given an 1D integer array A containing N distinct integers.

Find the number of unique pairs of integers in the array whose XOR is equal to B.

NOTE:

Pair (a, b) and (b, a) is considered to be same and should be counted once.


Problem Constraints
1 <= N <= 105

1 <= A[i], B <= 107



Input Format
First argument is an 1D integer array A.

Second argument is an integer B.



Output Format
Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.



Example Input
Input 1:

 A = [5, 4, 10, 15, 7, 6]
 B = 5
Input 2:

 A = [3, 6, 8, 10, 15, 50]
 B = 5


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 (10 ^ 15) = 5
Explanation 2:

 (3 ^ 6) = 5 and (10 ^ 15) = 5 
 */

package interviewbit;

public class Pairs_With_Given_Xor {
	
	 public int solve(int[] A, int B) {
         int len = A.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        
        for(int i=0; i<len; i++){
            int xor = (A[i]^B);
            if(map.containsKey(xor)){
                count+=(map.get(xor));
            }
            map.put(A[i], map.getOrDefault(A[i],0)+1);
        }
        
        return count;
    }

}
