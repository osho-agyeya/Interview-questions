//completed
/*
 * Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.

 

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation: The third maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Can you find an O(n) solution?
 */
package leetcode;

public class Third_Maximum_Number {
	
	 public int thirdMax(int[] nums) {
         Integer max1 = null;
 Integer max2 = null;
 Integer max3 = null;
 for (Integer n : nums) {
     if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
     if (max1 == null || n > max1) {
         max3 = max2;
         max2 = max1;
         max1 = n;
     } else if (max2 == null || n > max2) {
         max3 = max2;
         max2 = n;
     } else if (max3 == null || n > max3) {
         max3 = n;
     }
 }
 return max3 == null ? max1 : max3;
}

}
