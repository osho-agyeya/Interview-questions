//done
/*
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
package leetcode;

public class Target_Sum {
	 public int findTargetSumWays(int[] nums, int S) {
	        return dfs(nums, 0, S, 0);
	    }
	    
	    private int dfs(int[] nums, int sum, int target, int k) {
	        if (nums.length == k) {
	            return sum == target ? 1 : 0;
	        }
	        return dfs(nums, sum + nums[k], target, k + 1) + 
	                dfs(nums, sum - nums[k], target, k + 1);
	    }
}
