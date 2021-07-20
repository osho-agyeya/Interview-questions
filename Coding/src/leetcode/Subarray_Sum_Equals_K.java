/* over, n, n
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Subarray_Sum_Equals_K {
	
	/*
	 * 
	 * Approach 4: Using Hashmap
Algorithm

The idea behind this approach is as follows: If the cumulative sum(represented by sum[i]sum[i] for sum up to i^{th}i 
th
  index) up to two indices is the same, the sum of the elements lying in between those indices is zero. Extending the same thought further, if the cumulative sum up to two indices, say ii and jj is at a difference of kk i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices ii and jj is kk.

Based on these thoughts, we make use of a hashmap mapmap which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs. We store the data in the form: (sum_i, no. of occurrences of sum_i)(sum 
i
​
 ,no.ofoccurrencesofsum 
i
​
 ). We traverse over the array numsnums and keep on finding the cumulative sum. Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum. If the same sum occurs again, we increment the count corresponding to that sum in the hashmap. Further, for every sum encountered, we also determine the number of times the sum sum-ksum−k has occurred already, since it will determine the number of times a subarray with sum kk has occurred up to the current index. We increment the countcount by the same amount.

After the complete array has been traversed, the countcount gives the required result.

The animation below depicts the process.

Current
9 / 9

Complexity Analysis

Time complexity : O(n)O(n). The entire numsnums array is traversed only once.

Space complexity : O(n)O(n). Hashmap mapmap can contain up to nn distinct entries in the worst case.
	 * 
	 */
	
	
	public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result; 
    }
}
