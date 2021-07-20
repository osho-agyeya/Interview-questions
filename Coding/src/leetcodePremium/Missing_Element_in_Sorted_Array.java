/*completedd
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.

Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.
Example 2:

Input: A = [4,7,9,10], K = 3
Output: 8
Explanation: 
The missing numbers are [5,6,8,...], hence the third missing number is 8.
Example 3:

Input: A = [1,2,4], K = 3
Output: 6
Explanation: 
The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
Note:

1 <= A.length <= 50000
1 <= A[i] <= 1e7
1 <= K <= 1e8
 */

package leetcodePremium;

public class Missing_Element_in_Sorted_Array {

	public int missingElement(int[] nums, int k) {
	    int l = 0;
	    int r = nums.length;

	    // find the first index l s.t. nMissing(l) >= k
	    while (l < r) {
	      final int m = l + (r - l) / 2;
	      if (nMissing(nums, m) >= k)
	        r = m;
	      else
	        l = m + 1;
	    }

	    return nums[l - 1] + (k - nMissing(nums, l - 1));
	  }

	  // # of missing numbers in [nums[0], nums[i]]
	  private int nMissing(int[] nums, int i) {
	    return nums[i] - nums[0] - i;
	  }
	
}
