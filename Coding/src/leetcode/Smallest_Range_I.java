/*completed
 * Given an array nums of integers, for each integer nums[i] we may choose any x with -k <= x <= k, and add x to nums[i].

After this process, we have some array result.

Return the smallest possible difference between the maximum value of result and the minimum value of result.

 

Example 1:

Input: nums = [1], k = 0
Output: 0
Explanation: result = [1]
Example 2:

Input: nums = [0,10], k = 2
Output: 6
Explanation: result = [2,8]
Example 3:

Input: nums = [1,3,6], k = 3
Output: 0
Explanation: result = [3,3,3] or result = [4,4,4]
 

Note:

1 <= nums.length <= 10000
0 <= nums[i] <= 10000
0 <= k <= 10000
 */
package leetcode;

public class Smallest_Range_I {
	
	   public int smallestRangeI(int[] A, int K) {
	        int mx = A[0], mn = A[0];
	        for (int a : A) {
	            mx = Math.max(mx, a);
	            mn = Math.min(mn, a);
	        }
	        return Math.max(0, mx - mn - 2 * K);
	    }

}
