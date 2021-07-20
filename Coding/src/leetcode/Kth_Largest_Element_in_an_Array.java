/* over, nlogk, k
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104
 */
package leetcode;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {

	/*
	 * Approach 1: Heap
The idea is to init a heap "the smallest element first", and add all elements from the array into this heap one by one keeping the size of the heap always less or equal to k. That would results in a heap containing k largest elements of the array.

The head of this heap is the answer, i.e. the kth largest element of the array.

The time complexity of adding an element in a heap of size k is \mathcal{O}(\log k)O(logk), and we do it N times that means \mathcal{O}(N \log k)O(Nlogk) time complexity for the algorithm.

In Python there is a method nlargest in heapq library which has the same \mathcal{O}(N \log k)O(Nlogk) time complexity and reduces the code to one line.

This algorithm improves time complexity, but one pays with \mathcal{O}(k)O(k) space complexity.

Current
1 / 11

Complexity Analysis

Time complexity : \mathcal{O}(N \log k)O(Nlogk).
Space complexity : \mathcal{O}(k)O(k) to store the heap elements.
	 * 
	 * 
	 */
	public int findKthLargest(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	   
	    return pq.peek();
	}
}
