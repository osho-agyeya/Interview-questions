/* completedd
 * Given a stream of numbers A. On arrival of each number, you need to increase its first occurence by 1 and include this in the stream.

Return the final stream of numbers.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10000



Input Format
First and only argument is the array A.



Output Format
Return an array, the final stream of numbers.



Example Input
Input 1:

A = [1, 1]
Input 2:

A = [1, 2]


Example Output
Output 1:

[2, 1]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

 On arrival of the second element, the other element is increased by 1.
Explanation 2:

No increases are to be done.
 */

package interviewbit;

public class An_Increment_Problem {

	
public ArrayList<Integer> solve(ArrayList<Integer> A) {

        
        for(int i=0;i<A.size();i++){
            int first=A.indexOf(A.get(i));
           if(first>=0&& first<i){
               A.set(first,A.get(first)+1);
           }
            
        }
        return A;
    }
}
