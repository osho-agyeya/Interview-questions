//completed
/*
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
 

Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

package leetcode;

public class Single_Number_II {
	public int singleNumber(int[] nums) {
	    int res = 0;
	    for(int i = 0; i < 32; i++){
	        int sum = 0;
	        for(int n: nums)
	            if((n >> i & 1) == 1)
	                sum++;
	        sum %= 3;
	        res |= sum<<i;
	    }
	    return res;
	}
}
