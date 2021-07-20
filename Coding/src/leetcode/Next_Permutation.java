/* over, n!, 1
 * 
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

 */
package leetcode;

public class Next_Permutation {
	
	
	/*
	 * 
	 * Approach 2: Single Pass Approach
Algorithm

First, we observe that for any given sequence that is in descending order, no next larger permutation is possible. For example, no next permutation is possible for the following array:

[9, 5, 4, 3, 1]
We need to find the first pair of two successive numbers a[i]a[i] and a[i-1]a[i−1], from the right, which satisfy a[i] > a[i-1]a[i]>a[i−1]. Now, no rearrangements to the right of a[i-1]a[i−1] can create a larger permutation since that subarray consists of numbers in descending order. Thus, we need to rearrange the numbers to the right of a[i-1]a[i−1] including itself.

Now, what kind of rearrangement will produce the next larger number? We want to create the permutation just larger than the current one. Therefore, we need to replace the number a[i-1]a[i−1] with the number which is just larger than itself among the numbers lying to its right section, say a[j]a[j].

 Next Permutation 

We swap the numbers a[i-1]a[i−1] and a[j]a[j]. We now have the correct number at index i-1i−1. But still the current permutation isn't the permutation that we are looking for. We need the smallest permutation that can be formed by using the numbers only to the right of a[i-1]a[i−1]. Therefore, we need to place those numbers in ascending order to get their smallest permutation.

But, recall that while scanning the numbers from the right, we simply kept decrementing the index until we found the pair a[i]a[i] and a[i-1]a[i−1] where, a[i] > a[i-1]a[i]>a[i−1]. Thus, all numbers to the right of a[i-1]a[i−1] were already sorted in descending order. Furthermore, swapping a[i-1]a[i−1] and a[j]a[j] didn't change that order. Therefore, we simply need to reverse the numbers following a[i-1]a[i−1] to get the next smallest lexicographic permutation.

The following animation will make things clearer:

Next Permutation
	 * 
	 */
	
	public void nextPermutation(int[] A) {
	    if(A == null || A.length <= 1) return;
	    int i = A.length - 2;
	    while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
	    if(i >= 0) {                           // If not entirely descending
	        int j = A.length - 1;              // Start from the end
	        while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
	        swap(A, i, j);                     // Switch i and j
	    }
	    reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
	}

	public void swap(int[] A, int i, int j) {
	    int tmp = A[i];
	    A[i] = A[j];
	    A[j] = tmp;
	}

	public void reverse(int[] A, int i, int j) {
	    while(i < j) swap(A, i++, j--);
	}

}

