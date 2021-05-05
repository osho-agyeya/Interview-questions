/*completed
 * Given an integer array nums that is sorted in ascending order, return true if and only if you can split it into one or more subsequences such that each subsequence consists of consecutive integers and has a length of at least 3.

 

Example 1:

Input: nums = [1,2,3,3,4,5]
Output: true
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5
Example 2:

Input: nums = [1,2,3,3,4,4,5,5]
Output: true
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5
Example 3:

Input: nums = [1,2,3,4,4,5]
Output: false
 

Constraints:

1 <= nums.length <= 104
-1000 <= nums[i] <= 1000
nums is sorted in an ascending order.
 */

package leetcode;

public class Split_Array_into_Consecutive_Subsequences {
	
	public boolean isPossible(int[] A) {        
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        
        for (int a: A) left.put(a, left.getOrDefault(a, 0) + 1);
        for (int a: A) {
            if (left.get(a) <= 0) continue;
            
            left.put(a, left.get(a) - 1);
            
            // place a in an existing subsequence if possible
            if (end.containsKey(a-1) && end.get(a-1) > 0) {
                end.put(a-1, end.get(a-1) - 1);
                end.put(a, end.getOrDefault(a, 0) + 1);
                continue;
            }
            
            // place a in a new subsequence
            if (left.containsKey(a+1) && left.get(a+1) > 0 && 
                left.containsKey(a+2) && left.get(a+2) > 0) {
                left.put(a+1, left.get(a+1) - 1);
                left.put(a+2, left.get(a+2) - 1);
                end.put(a+2, end.getOrDefault(a+2, 0) + 1);
                continue;
            }
            
            // don't know where to place a? ---> false
            return false;
        }
        
        return true;
    }

}
