//completed

/*
 * 
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 104
-109 <= nums[i] <= 109
 

Follow up: Could you implement the O(n) solution?
 */

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {
	
	 public int longestConsecutive(int[] nums) {
	        Set<Integer> set = new HashSet<>();
	            for(int n : nums) {
	                set.add(n);
	            }
	            int best = 0;
	            for(int n : set) {
	                if(!set.contains(n - 1)) {  // only check for one direction
	                    int m = n + 1;
	                    while(set.contains(m)) {
	                        m++;
	                    }
	                    best = Math.max(best, m - n);
	                }
	            }
	            return best;
	        
	    }

}
