//completed
/*
 * 
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false
 

Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].
 */

package leetcode;

public class Partition_to_K_Equal_Sum_Subsets {
	
	 public boolean canPartitionKSubsets(int[] a, int k) {
	        int sum = IntStream.of(a).sum();
	        return k != 0 && sum % k == 0 && canPartition(0, a, new boolean[a.length], k, 0, sum / k);
	    }

	    boolean canPartition(int start, int[] a, boolean[] seen, int k, int sum, int target) {
	        if (k == 1) return true;
	        if (sum == target)
	            return canPartition(0, a, seen, k - 1, 0, target);
	        for (int i = start; i < a.length; i++)
	            if (!seen[i]) {
	                seen[i] = true;
	                if (canPartition(i + 1, a, seen, k, sum + a[i], target))
	                    return true;
	                seen[i] = false;
	            }
	        return false;
	    }
	
}
