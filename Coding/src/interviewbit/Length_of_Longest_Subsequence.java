//done
/*
 * Length of Longest Subsequence
Asked in:  
Microsoft
Problem Setter: mayank111 Problem Tester: glowing_glare
Given an array of integers, A of length N, find the length of longest subsequence which is first increasing then decreasing.

Input Format:

The first and the only argument contains an integer array, A.
Output Format:

Return an integer representing the answer as described in the problem statement.
Constraints:

1 <= N <= 3000
1 <= A[i] <= 1e7
Example:

Input 1:
    A = [1, 2, 1]

Output 1:
    3

Explanation 1:
    [1, 2, 1] is the longest subsequence.

Input 2:
    [1, 11, 2, 10, 4, 5, 2, 1]

Output 2:
    6
    
Explanation 2:
    [1 2 10 4 2 1] is the longest subsequence.
 */

package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class Length_of_Longest_Subsequence {

	public int longestSubsequenceLength(final List<Integer> A) {
        List<Integer> leftLIS = new ArrayList<>();
        List<Integer> rightLIS = new ArrayList<>();

        if(A.isEmpty()) return 0;

        for(int i = 0 ; i < A.size() ; i++) {
            leftLIS.add(i,1);
            rightLIS.add(i,1);
        }

        int max = 0;
        for(int i = 0 ; i < A.size() ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(A.get(i) > A.get(j)) {
                    leftLIS.set(i, Math.max(leftLIS.get(i), leftLIS.get(j) + 1));
                }
            }
        }

        for(int i = A.size() - 2 ; i >=0 ;i -- ){
            for(int j = A.size() - 1 ; j >i ; j--) {
                if(A.get(i) > A.get(j)) {
                    rightLIS.set(i, Math.max(rightLIS.get(i), rightLIS.get(j)+1));
                }
            }
        }

        for(int i = 0 ; i < A.size() ; i++) {
            if(max < (leftLIS.get(i) + rightLIS.get(i)) - 1) {
                max = (leftLIS.get(i) + rightLIS.get(i)) - 1;
            }
        }
        return max;
    }
	
}
