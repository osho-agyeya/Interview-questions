/* over, n^( T/M + 1), T/M where n is no. of candidates, T is target and M is minimal value
 * 
 * 
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
Example 4:

Input: candidates = [1], target = 1
Output: [[1]]
Example 5:

Input: candidates = [1], target = 2
Output: [[1,1]]
 

Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {
	
	/*
	 * 
	 * Overview
This is one of the problems in the series of combination sum. They all can be solved with the same algorithm, i.e. backtracking.

Before tackling this problem, we would recommend one to start with another almost identical problem called Combination Sum III, which is arguably easier and one can tweak the solution a bit to solve this problem.

For the sake of this article, we will present the backtracking algorithm. Furthermore, we will list some other problems on LeetCode that one can solve with the same algorithm presented here.

Approach 1: Backtracking
Intuition

As a reminder, backtracking is a general algorithm for finding all (or some) solutions to some computational problems. The idea is that it incrementally builds candidates to the solutions, and abandons a candidate ("backtrack") as soon as it determines that this candidate cannot lead to a final solution.

Specifically, to our problem, we could incrementally build the combination, and once we find the current combination is not valid, we backtrack and try another option.

To demonstrate the idea, we showcase how it works with a concrete example in the following graph:

exploration tree

For the given list of candidates [3, 4, 5] and a target sum 8, we start off from empty combination [] as indicated as the root node in the above graph.

Each node represents an action we take at a step, and within the node we also indicate the combination we build sofar.

From top to down, at each level we descend, we add one more element into the current combination.

The nodes marked in blue are the ones that could sum up to the target value, i.e. they are the desired combination solutions.

The nodes marked in red are the ones that exceed the target value. Since all the candidates are positive value, there is no way we could bring the sum down to the target value, if we explore further.

At any instant, we can only be at one of the nodes. When we backtrack, we are moving from a node to its parent node.

An important detail on choosing the next number for the combination is that we select the candidates in order, where the total candidates are treated as a list. Once a candidate is added into the current combination, we will not look back to all the previous candidates in the next explorations.

zoom in

To demonstrate the idea, let us zoom in a node (as we shown in the above graph) to see how we can choose the next numbers.

When we are at the node of [4], the precedent candidates are [3], and the candidates followed are [4, 5].

We don't add the precedent numbers into the current node, since they would have been explored in the nodes in the left part of the subtree, i.e. the node of [3].

Even though we have already the element 4 in the current combination, we are giving the element another chance in the next exploration, since the combination can contain duplicate numbers.

As a result, we would branch out in two directions, by adding the element 4 and 5 respectively into the current combination.

Algorithm

As one can see, the above backtracking algorithm is unfolded as a DFS (Depth-First Search) tree traversal, which is often implemented with recursion.

Here we define a recursive function of backtrack(remain, comb, start) (in Python), which populates the combinations, starting from the current combination (comb), the remaining sum to fulfill (remain) and the current cursor (start) to the list of candidates. Note that, the signature of the recursive function is slightly different in Java. But the idea remains the same.

For the first base case of the recursive function, if the remain==0, i.e. we fulfill the desired target sum, therefore we can add the current combination to the final list.

As another base case, if remain < 0, i.e. we exceed the target value, we will cease the exploration here.

Other than the above two base cases, we would then continue to explore the sublist of candidates as [start ... n]. For each of the candidate, we invoke the recursive function itself with updated parameters.

Specifically, we add the current candidate into the combination.

With the added candidate, we now have less sum to fulfill, i.e. remain - candidate.

For the next exploration, still we start from the current cursor start.

At the end of each exploration, we backtrack by popping out the candidate out of the combination.


Complexity Analysis

Let NN be the number of candidates, TT be the target value, and MM be the minimal value among the candidates.

Time Complexity: \mathcal{O}(N^{\frac{T}{M}+1})O(N 
M
T
​
 +1
 )

As we illustrated before, the execution of the backtracking is unfolded as a DFS traversal in a n-ary tree. The total number of steps during the backtracking would be the number of nodes in the tree.

At each node, it takes a constant time to process, except the leaf nodes which could take a linear time to make a copy of combination. So we can say that the time complexity is linear to the number of nodes of the execution tree.

Here we provide a loose upper bound on the number of nodes.

First of all, the fan-out of each node would be bounded to NN, i.e. the total number of candidates.

The maximal depth of the tree, would be \frac{T}{M} 
M
T
​
 , where we keep on adding the smallest element to the combination.

As we know, the maximal number of nodes in N-ary tree of \frac{T}{M} 
M
T
​
  height would be N^{\frac{T}{M}+1}N 
M
T
​
 +1
 .

Note that, the actual number of nodes in the execution tree would be much smaller than the upper bound, since the fan-out of the nodes are decreasing level by level.

Space Complexity: \mathcal{O}(\frac{T}{M})O( 
M
T
​
 )

We implement the algorithm in recursion, which consumes some additional memory in the function call stack.

The number of recursive calls can pile up to \frac{T}{M} 
M
T
​
 , where we keep on adding the smallest element to the combination. As a result, the space overhead of the recursion is \mathcal{O}(\frac{T}{M})O( 
M
T
​
 ).

In addition, we keep a combination of numbers during the execution, which requires at most \mathcal{O}(\frac{T}{M})O( 
M
T
​
 ) space as well.

To sum up, the total space complexity of the algorithm would be \mathcal{O}(\frac{T}{M})O( 
M
T
​
 ).

Note that, we did not take into the account the space used to hold the final results for the space complexity.


	 * 
	 */
	
	 public List<List<Integer>> combinationSum(int[] nums, int target) {
		    List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrack(list, new ArrayList<>(), nums, target, 0);
		    return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
		    if(remain < 0) return;
		    else if(remain == 0) list.add(new ArrayList<>(tempList));
		    else{ 
		        for(int i = start; i < nums.length; i++){
		            tempList.add(nums[i]);
		            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
		            tempList.remove(tempList.size() - 1);
		        }
		    }
		}

}
