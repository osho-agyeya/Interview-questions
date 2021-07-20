/* over, n, 1
Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
 */

package leetcode;

public class Plus_One {
	
	/*
	 * Approach 1: Schoolbook Addition with Carry
Intuition

Let us identify the rightmost digit which is not equal to nine and increase that digit by one. All the following consecutive digits of nine should be set to zero.

Here is the simplest use case which works fine.

simple

Here is a slightly complicated case which still passes.

more

And here is the case which breaks everything, because all the digits are nines.

handle

In this case, we need to set all nines to zero and append 1 to the left side of the array.

append

Algorithm

Move along the input array starting from the end of array.

Set all the nines at the end of array to zero.

If we meet a not-nine digit, we would increase it by one. The job is done - return digits.

We're here because all the digits were equal to nine. Now they have all been set to zero. We then append the digit 1 in front of the other digits and return the result.

Implementation

Current
1 / 7

Complexity Analysis

Let NN be the number of elements in the input list.

Time complexity: \mathcal{O}(N)O(N) since it's not more than one pass along the input list.

Space complexity: \mathcal{O}(N)O(N)

Although we perform the operation in-place (i.e. on the input list itself), in the worst scenario, we would need to allocate an intermediate space to hold the result, which contains the N+1N+1 elements. Hence the overall space complexity of the algorithm is \mathcal{O}(N)O(N).
	 * 
	 */

	public int[] plusOne(int[] digits) {
        int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        digits[i] = 0;
    }
    
    digits = new int [n+1];
    digits[0] = 1;
    
    return digits;
    }
	
}
