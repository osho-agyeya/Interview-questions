/* over, n!, n!
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	/*
	 * 
	 * Approach 1: Backtracking
Backtracking is an algorithm for finding all solutions by exploring all potential candidates. If the solution candidate turns to be not a solution (or at least not the last one), backtracking algorithm discards it by making some changes on the previous step, i.e. backtracks and then try again.

Here is a backtrack function which takes the index of the first integer to consider as an argument backtrack(first).

If the first integer to consider has index n that means that the current permutation is done.
Iterate over the integers from index first to index n - 1.
Place i-th integer first in the permutation, i.e. swap(nums[first], nums[i]).
Proceed to create all permutations which starts from i-th integer : backtrack(first + 1).
Now backtrack, i.e. swap(nums[first], nums[i]) back.
Current
1 / 14

Complexity Analysis

Time complexity : \mathcal{O}(\sum_{k = 1}^{N}{P(N, k)})O(∑ 
k=1
N
​
 P(N,k)) where P(N, k) = \frac{N!}{(N - k)!} = N (N - 1) ... (N - k + 1)P(N,k)= 
(N−k)!
N!
​
 =N(N−1)...(N−k+1) is so-called k-permutations_of_n, or partial permutation.
Here first + 1 = kfirst+1=k for the expression simplicity. The formula is easy to understand : for each kk (each firstfirst) one performs N(N - 1) ... (N - k + 1)N(N−1)...(N−k+1) operations, and kk is going through the range of values from 11 to NN (and firstfirst from 00 to N - 1N−1).

Let's do a rough estimation of the result : N! \le \sum_{k = 1}^{N}{\frac{N!}{(N - k)!}} = \sum_{k = 1}^{N}{P(N, k)} \le N \times N!N!≤∑ 
k=1
N
​
  
(N−k)!
N!
​
 =∑ 
k=1
N
​
 P(N,k)≤N×N!, i.e. the algorithm performs better than \mathcal{O}(N \times N!)O(N×N!) and a bit slower than \mathcal{O}(N!)O(N!).

Space complexity : \mathcal{O}(N!)O(N!) since one has to keep N! solutions.
	 * 
	 * 
	 */
	
	public List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
		}

		    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		       if(tempList.size() == nums.length){
		          list.add(new ArrayList<>(tempList));
		       } else{
		          for(int i = 0; i < nums.length; i++){ 
		             if(tempList.contains(nums[i])) continue; // element already exists, skip
		             tempList.add(nums[i]);
		             backtrack(list, tempList, nums);
		             tempList.remove(tempList.size() - 1);
		          }
		       }
		    } 

}
