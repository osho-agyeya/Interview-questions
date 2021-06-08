/*completedd
 * 
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */

package leetcode;

public class Contiguous_Array {
	
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int result = 0;
    int sum = 0;
        int k =0;
 
    for(int i=0; i<nums.length; i++){
        sum += (nums[i]==0)?-1:1;
        if(map.containsKey(sum - k)){
            result = Math.max(result, i - map.get(sum - k));
        }
        map.putIfAbsent(sum, i);
    }
 
    return result;
        
    }

}
