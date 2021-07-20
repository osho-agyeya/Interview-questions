/* over, n, k
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:

Input: nums = [9,11], k = 2
Output: [11]
Example 5:

Input: nums = [4,-2], k = 2
Output: [4]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */

package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Window_Maximum {
	
	/*
	 * 
	 * Approach 2: Deque
Intuition

How one could improve the time complexity? The first idea is to use a heap, since in a maximum heap heap[0] is always the largest element. Though to add an element in a heap of size k costs \log(k)log(k), that means \mathcal{O}(N \log(k))O(Nlog(k)) time complexity for the solution.

Could we figure out \mathcal{O}(N)O(N) solution?

Let's use a deque (double-ended queue), the structure which pops from / pushes to either side with the same \mathcal{O}(1)O(1) performance.

It's more handy to store in the deque indexes instead of elements since both are used during an array parsing.

Algorithm

The algorithm is quite straigthforward :

Process the first k elements separately to initiate the deque.

Iterate over the array. At each step :

Clean the deque :

Keep only the indexes of elements from the current sliding window.

Remove indexes of all elements smaller than the current one, since they will not be the maximum ones.

Append the current element to the deque.

Append deque[0] to the output.

Return the output array.

Implementation


Complexity Analysis

Time complexity : \mathcal{O}(N)O(N), since each element is processed exactly twice - it's index added and then removed from the deque.

Space complexity : \mathcal{O}(N)O(N), since \mathcal{O}(N - k + 1)O(N−k+1) is used for an output array and \mathcal{O}(k)O(k) for a deque.
	 * 
	 */

public int[] maxSlidingWindow(int[] a, int k) {
	
	
	/*
	 * We scan the array from 0 to n-1, keep "promising" elements in the deque. The algorithm is amortized O(n) as each element is put and polled once.

At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window. This means

If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array

Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from the tail. This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.

As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]
	 * 
	 */
        
        if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			if (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}
	
}
