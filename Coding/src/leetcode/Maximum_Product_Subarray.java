//completed

/*
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
