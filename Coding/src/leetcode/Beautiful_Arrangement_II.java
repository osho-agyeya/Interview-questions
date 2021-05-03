/*completed
 * Given two integers n and k, construct a list answer that contains n different positive integers ranging from 1 to n and obeys the following requirement:

Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
Return the list answer. If there multiple valid answers, return any of them.

 

Example 1:

Input: n = 3, k = 1
Output: [1,2,3]
Explanation: The [1,2,3] has three different positive integers ranging from 1 to 3, and the [1,1] has exactly 1 distinct integer: 1
Example 2:

Input: n = 3, k = 2
Output: [1,3,2]
Explanation: The [1,3,2] has three different positive integers ranging from 1 to 3, and the [2,1] has exactly 2 distinct integers: 1 and 2.
 

Constraints:

1 <= k < n <= 104
 * 
 */


package leetcode;

public class Beautiful_Arrangement_II {
	
	public int[] constructArray(int n, int k) {
		int[] res = new int[n];
		int left = 1;
		int right = n;

		for(int i = 0; i < n; i++){
		 // If k is even, increment by 1, else decrement by 1 (you can swap this order. Just be consistent)
		 if(k % 2 == 0)
		  res[i] = left++;
		 else 
		  res[i] = right--;
			
		 // Keep swapping the reverses on each index until you do it k - 1 times.
		 // Then rest of numbers should just ONLY incremements or ONLY decrements.
		 if(k > 1)
		  k--;
		}
		return res;
	}

}
