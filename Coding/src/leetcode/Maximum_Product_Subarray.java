/* over, n, 1
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 */

package leetcode;

public class Maximum_Product_Subarray {
	
	/*
	 * 
	 * Approach 2: Dynamic Programming
Intuition

Rather than looking for every possible subarray to get the largest product, we can scan the array and solve smaller subproblems.

Let's see this problem as a problem of getting the highest combo chain. The way combo chains work is that they build on top of the previous combo chains that you have acquired. The simplest case is when the numbers in nums are all positive numbers. In that case, you would only need to keep on multiplying the accumulated result to get a bigger and bigger combo chain as you progress.

However, two things can disrupt your combo chain:

Zeros
Negative numbers
Zeros will reset your combo chain. A high score which you have achieved will be recorded in placeholder result. You will have to restart your combo chain after zero. If you encounter another combo chain which is higher than the recorded high score in result, you just need to update the result.

Negative numbers are a little bit tricky. A single negative number can flip the largest combo chain to a very small number. This may sound like your combo chain has been completely disrupted but if you encounter another negative number, your combo chain can be saved. Unlike zero, you still have a hope of saving your combo chain as long as you have another negative number in nums (Think of this second negative number as an antidote for the poison that you just consumed). However, if you encounter a zero while you are looking your another negative number to save your combo chain, you lose the hope of saving that combo chain.

While going through numbers in nums, we will have to keep track of the maximum product up to that number (we will call max_so_far) and minimum product up to that number (we will call min_so_far). The reason behind keeping track of max_so_far is to keep track of the accumulated product of positive numbers. The reason behind keeping track of min_so_far is to properly handle negative numbers.

max_so_far is updated by taking the maximum value among:

Current number.
This value will be picked if the accumulated product has been really bad (even compared to the current number). This can happen when the current number has a preceding zero (e.g. [0,4]) or is preceded by a single negative number (e.g. [-3,5]).
Product of last max_so_far and current number.
This value will be picked if the accumulated product has been steadily increasing (all positive numbers).
Product of last min_so_far and current number.
This value will be picked if the current number is a negative number and the combo chain has been disrupted by a single negative number before (In a sense, this value is like an antidote to an already poisoned combo chain).
min_so_far is updated in using the same three numbers except that we are taking minimum among the above three numbers.

In the animation below, you will observe a negative number -5 disrupting a combo chain but that combo chain is later saved by another negative number -4. The only reason this can be saved is because of min_so_far. You will also observe a zero disrupting a combo chain.

Current
1 / 17
Implementation


Complexity Analysis

Time complexity : O(N)O(N) where NN is the size of nums. The algorithm achieves linear runtime since we are going through nums only once.

Space complexity : O(1)O(1) since no additional space is consumed rather than variables which keep track of the maximum product so far, the minimum product so far, current variable, temp variable, and placeholder variable for the result.
	 * 
	 * 
	 */
	
	public int maxProduct(int[] A) {
        // store the result that is the max we have found so far
    int r = A[0];
        int n=A.length;

    // imax/imin stores the max/min product of
    // subarray that ends with the current number A[i]
    for (int i = 1, imax = r, imin = r; i < n; i++) {
        // multiplied by a negative makes big number smaller, small number bigger
        // so we redefine the extremums by swapping them
        if (A[i] < 0){
            int temp=imax;
            imax=imin;
            imin=temp;
        }
           // swap(imax, imin);

        // max/min product for the current number is either the current number itself
        // or the max/min by the previous number times the current one
        imax = Math.max(A[i], imax * A[i]);
        imin = Math.min(A[i], imin * A[i]);

        // the newly computed max value is a candidate for our global result
        r = Math.max(r, imax);
    }
    return r;
    }

}
