/* over, nlogn+n^2, n
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 * 
 * 
 * 
 * 
 * 
 */
package leetcode;

import java.util.*;
public class _3Sum {
	
	public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        Set<List<Integer>> res = new HashSet<>();
    for (int i = 0; i < num.length-2; i++) {
    	if (num[i] > 0) break;
        if (i == 0 || (num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) {
                    // improve: skip duplicates
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    lo++;
                }
                else {
                    // improve: skip duplicates
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    hi--;
                }
           }
        }
    }
    return new ArrayList<>(res);
    }

}
