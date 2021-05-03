/*completed
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.
 */


package leetcode;

public class Largest_Divisible_Subset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
	    List<Integer> res = new ArrayList<Integer>();
	    if (nums == null || nums.length == 0) return res;
	    Arrays.sort(nums);
	    int[] dp = new int[nums.length];
	    Arrays.fill(dp, 1);

	    //for each element in nums, find the length of largest subset it has.
	    for (int i = 1; i < nums.length; i++){
	        for (int j = i-1; j >= 0; j--){
	            if (nums[i] % nums[j] == 0){
	                dp[i] = Math.max(dp[i],dp[j] + 1);
	            }
	        }
	    }

	    //pick the index of the largest element in dp.
	    int maxIndex = 0;
	    for (int i = 1; i < nums.length; i++){
	        maxIndex = dp[i] > dp[maxIndex] ?  i :  maxIndex;
	    }

	    //from nums[maxIndex] to 0, add every element belongs to the largest subset.
	    int temp = nums[maxIndex];
	    int curDp = dp[maxIndex];
	    for (int i = maxIndex; i >= 0; i--){
	        if (temp % nums[i] == 0 && dp[i] == curDp){
	            res.add(nums[i]);
	            temp = nums[i];
	            curDp--;
	        }
	    }
	    return res;
	}
}
