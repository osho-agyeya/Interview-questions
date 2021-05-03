//completed
/*
Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0. 
Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.

Note: 
The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000

Follow up:
What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently? 
 * 
 */
package leetcodePremium;

public class Max_Consecutive_Ones_II {
	
	public int findMaxConsecutiveOnes(int[] nums) {
        int k = 1, low = 0, zeroCount = 0, ret = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[low] == 0) {
                    zeroCount--;
                }
                low++;
            }
            ret = Math.max(ret, i - low + 1);
        }
        
        return ret;
    }


}
