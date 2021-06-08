
//completed

//t=O(N)
//s=O(N*N)


/*
 * 
 * 
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 500
0 <= nums[i] <= 100
 */
package leetcode;

public class Burst_Balloons {
	public int maxCoins(int[] nums) {
        
	    int[][] dp = new int[nums.length][nums.length];
	    return maxCoins(nums, 0, nums.length - 1, dp);
	}

	public int maxCoins(int[] nums, int start, int end, int[][] dp) {
	    if (start > end) {
	        return 0;
	    }
	    if (dp[start][end] != 0) {
	        return dp[start][end];
	    }
	    int max = nums[start];
	    for (int i = start; i <= end; i++) {  //i is the last balloon to be burst in the range start to end
	        int val = maxCoins(nums, start, i - 1, dp) + 
	                  get(nums, i) * get(nums, start - 1) * get(nums, end + 1) + 
	                  maxCoins(nums, i + 1, end, dp);
	                  
	        max = Math.max(max, val);
	    }
	    dp[start][end] = max;
	    return max;
	}

	public int get(int[] nums, int i) {
	    if (i == -1 || i == nums.length) {
	        return 1;
	    }
	    return nums[i];
	}
}
