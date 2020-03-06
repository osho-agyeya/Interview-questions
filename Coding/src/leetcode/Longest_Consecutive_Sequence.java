//done

/*
 * 
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
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
