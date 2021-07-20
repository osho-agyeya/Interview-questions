/* over, n, 1
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up:

Could you solve it in O(n) time complexity and without using division?
Could you solve it with O(1) constant space complexity? (The output array does not count as extra space for space complexity analysis.)
 *
 *
 */
package leetcode;

public class Product_of_Array_Except_Self {
	
	/*
	 * 
	 * Approach 2: O(1) space approach
Although the above solution is good enough to solve the problem since we are not using division anymore, there's a follow-up component as well which asks us to solve this using constant space. Understandably so, the output array does not count towards the space complexity. This approach is essentially an extension of the approach above. Basically, we will be using the output array as one of L or R and we will be constructing the other one on the fly. Let's look at the algorithm based on this idea.

Algorithm

Initialize the empty answer array where for a given index i, answer[i] would contain the product of all the numbers to the left of i.
We construct the answer array the same way we constructed the L array in the previous approach. These two algorithms are exactly the same except that we are trying to save up on space.
The only change in this approach is that we don't explicitly build the R array from before. Instead, we simply use a variable to keep track of the running product of elements to the right and we keep updating the answer array by doing answer[i] = answer[i] * Ranswer[i]=answer[i]∗R. For a given index i, answer[i] contains the product of all the elements to the left and R would contain product of all the elements to the right. We then update R as R = R * nums[i]R=R∗nums[i]

Complexity analysis

Time complexity : O(N)O(N) where NN represents the number of elements in the input array. We use one iteration to construct the array LL, one to update the array answeranswer.
Space complexity : O(1)O(1) since don't use any additional array for our computations. The problem statement mentions that using the answeranswer array doesn't add to the space complexity.
	 * 
	 */
	
	public int[] productExceptSelf(int[] nums) {
	       int n = nums.length;
	    int[] res = new int[n];
	    res[0] = 1;
	    for (int i = 1; i < n; i++) {
	        res[i] = res[i - 1] * nums[i - 1];
	    }
	    int right = 1;
	    for (int i = n - 1; i >= 0; i--) {
	        res[i] *= right;
	        right *= nums[i];
	    }
	    return res; 
	    }
}
