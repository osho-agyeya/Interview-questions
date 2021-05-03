/*
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

Example
Example1

Input:  nums = [-2,0,1,3], target = 2
Output: 2
Explanation:
Because there are two triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]
Example2

Input: nums = [-2,0,-1,3], target = 2
Output: 3
Explanation:
Because there are three triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]
[-2, -1, 3]
Challenge
Could you solve it in O(n2) runtime?
 */



package leetcodePremium;


public class _3Sum_Smaller {
	
	public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
         
        int result = 0;
        Arrays.sort(nums);
         
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    result += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }
         
        return result;
    }
	
	

}
