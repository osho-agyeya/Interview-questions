/* over, n * log(sum of array), 1
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

 

Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], m = 2
Output: 9
Example 3:

Input: nums = [1,4,4], m = 3
Output: 4
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= m <= min(50, nums.length)
 * 
 */


package leetcode;

public class Split_Array_Largest_Sum {
	
	/*
	 * 
	 * Approach #3 Binary Search + Greedy [Accepted]
Intuition

We can easily find a property for the answer:

If we can find a splitting method that ensures the maximum largest subarray sum will not exceed a value x, then we can also find a splitting method that ensures the maximum largest subarray sum will not exceed any value y that is greater than x.

Lets define this property as F(x) for the value x. F(x) is true means we can find a splitting method that ensures the maximum largest subarray sum will not exceed x.

From the discussion above, we can find out that for x ranging from -INFINITY to INFINITY, F(x) will start with false, then from a specific value x0, F(x) will turn to true and stay true forever.

Obviously, the specific value x0 is our answer.

Algorithm

We can use Binary search to find the value x0. Keeping a value mid = (left + right) / 2. If F(mid) is false, then we will search the range [mid + 1, right]; If F(mid) is true, then we will search [left, mid - 1].

For a given x, we can get the answer of F(x) using a greedy approach. Using an accumulator sum to store the sum of the current processing subarray and a counter cnt to count the number of existing subarrays. We will process the elements in the array one by one. For each element num, if sum + num <= x, it means we can add num to the current subarray without exceeding the limit. Otherwise, we need to make a cut here, start a new subarray with the current element num. This leads to an increment in the number of subarrays.

After we have finished the whole process, we need to compare the value cnt to the size limit of subarrays m. If cnt <= m, it means we can find a splitting method that ensures the maximum largest subarray sum will not exceed x. Otherwise, F(x) should be false.

 **Complexity Analysis**
Time complexity : O(n * log(sum of array))O(n∗log(sumofarray)). The binary search costs O(log(sum of array))O(log(sumofarray)), where sum of array is the sum of elements in nums. For each computation of F(x), the time complexity is O(n)O(n) since we only need to go through the whole array.

Space complexity : O(1)O(1) space complexity without taking the output list into account, and O(n)O(n) to store the output list.
	 * 
	 * 
	 */

	 public int splitArray(int[] nums, int m) {
	        long l = 0;
	        long r = 0;        
	        int n = nums.length;
	        for (int i = 0; i < n; i++) {
	            r += nums[i];
	            if (l < nums[i]) {
	                l = nums[i];
	            }
	        }
	        long ans = r;
	        while (l <= r) {
	            long mid = (l + r) >> 1;
	            long sum = 0;
	            int cnt = 1;
	            for (int i = 0; i < n; i++) {
	                if (sum + nums[i] > mid) {
	                    cnt ++;
	                    sum = nums[i];
	                } else {
	                    sum += nums[i];
	                }
	            }
	            if (cnt <= m) {
	                ans = Math.min(ans, mid);
	                r = mid - 1;
	            } else {
	                l = mid + 1;
	            }
	        }
	        return (int)ans;      
	    }
	
	
}
