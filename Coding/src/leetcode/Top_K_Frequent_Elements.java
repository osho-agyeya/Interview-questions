/* over, n, n
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top_K_Frequent_Elements {
	
	/*
	 * 
	 * Approach 1: Heap
Let's start from the simple heap approach with \mathcal{O}(N \log k)O(Nlogk) time complexity. To ensure that \mathcal{O}(N \log k)O(Nlogk) is always less than \mathcal{O}(N \log N)O(NlogN), the particular case k = Nk=N could be considered separately and solved in \mathcal{O}(N)O(N) time.

Algorithm

The first step is to build a hash map element -> its frequency. In Java, we use the data structure HashMap. Python provides dictionary subclass Counter to initialize the hash map we need directly from the input array.
This step takes \mathcal{O}(N)O(N) time where N is a number of elements in the list.

The second step is to build a heap of size k using N elements. To add the first k elements takes a linear time \mathcal{O}(k)O(k) in the average case, and \mathcal{O}(\log 1 + \log 2 + ... + \log k) = \mathcal{O}(log k!) = \mathcal{O}(k \log k)O(log1+log2+...+logk)=O(logk!)=O(klogk) in the worst case. It's equivalent to heapify implementation in Python. After the first k elements we start to push and pop at each step, N - k steps in total. The time complexity of heap push/pop is \mathcal{O}(\log k)O(logk) and we do it N - k times that means \mathcal{O}((N - k)\log k)O((N−k)logk) time complexity. Adding both parts up, we get \mathcal{O}(N \log k)O(Nlogk) time complexity for the second step.

The third and the last step is to convert the heap into an output array. That could be done in \mathcal{O}(k \log k)O(klogk) time.

In Python, library heapq provides a method nlargest, which combines the last two steps under the hood and has the same \mathcal{O}(N \log k)O(Nlogk) time complexity.

diff

Implementation


Complexity Analysis

Time complexity : \mathcal{O}(N \log k)O(Nlogk) if k < Nk<N and \mathcal{O}(N)O(N) in the particular case of N = kN=k. That ensures time complexity to be better than \mathcal{O}(N \log N)O(NlogN).

Space complexity : \mathcal{O}(N + k)O(N+k) to store the hash map with not more NN elements and a heap with kk elements.


Approach 2: Quickselect (Hoare's selection algorithm)
Quickselect is a textbook algorthm typically used to solve the problems "find kth something": kth smallest, kth largest, kth most frequent, kth less frequent, etc. Like quicksort, quickselect was developed by Tony Hoare, and also known as Hoare's selection algorithm.

It has \mathcal{O}(N)O(N) average time complexity and widely used in practice. It worth to note that its worth case time complexity is \mathcal{O}(N^2)O(N 
2
 ), although the probability of this worst-case is negligible.

The approach is the same as for quicksort.

One chooses a pivot and defines its position in a sorted array in a linear time using so-called partition algorithm.

As an output, we have an array where the pivot is on its perfect position in the ascending sorted array, sorted by the frequency. All elements on the left of the pivot are less frequent than the pivot, and all elements on the right are more frequent or have the same frequency.

Hence the array is now split into two parts. If by chance our pivot element took N - kth final position, then kk elements on the right are these top kk frequent we're looking for. If not, we can choose one more pivot and place it in its perfect position.

diff

If that were a quicksort algorithm, one would have to process both parts of the array. That would result in \mathcal{O}(N \log N)O(NlogN) time complexity. In this case, there is no need to deal with both parts since one knows in which part to search for N - kth less frequent element, and that reduces the average time complexity to \mathcal{O}(N)O(N).

Algorithm

The algorithm is quite straightforward :

Build a hash map element -> its frequency and convert its keys into the array unique of unique elements. Note that elements are unique, but their frequencies are not. That means we need a partition algorithm that works fine with duplicates.

Work with unique array. Use a partition scheme (please check the next section) to place the pivot into its perfect position pivot_index in the sorted array, move less frequent elements to the left of pivot, and more frequent or of the same frequency - to the right.

Compare pivot_index and N - k.

If pivot_index == N - k, the pivot is N - kth most frequent element, and all elements on the right are more frequent or of the same frequency. Return these top kk frequent elements.

Otherwise, choose the side of the array to proceed recursively.

diff

Lomuto's Partition Scheme

There is a zoo of partition algorithms. The most simple one is Lomuto's Partition Scheme, and so is what we will use in this article.

Here is how it works:

Move pivot at the end of the array using swap.

Set the pointer at the beginning of the array store_index = left.

Iterate over the array and move all less frequent elements to the left swap(store_index, i). Move store_index one step to the right after each swap.

Move the pivot to its final place, and return this index.

Current
1 / 14

Implementation

Here is a total algorithm implementation.


Complexity Analysis

Time complexity: \mathcal{O}(N)O(N) in the average case, \mathcal{O}(N^2)O(N 
2
 ) in the worst case. Please refer to this card for the good detailed explanation of Master Theorem. Master Theorem helps to get an average complexity by writing the algorithm cost as T(N) = a T(N / b) + f(N)T(N)=aT(N/b)+f(N). Here we have an example of Master Theorem case III: T(N) = T \left(\frac{N}{2}\right) + NT(N)=T( 
2
N
​
 )+N, that results in \mathcal{O}(N)O(N) time complexity. That's the case of random pivots.

In the worst-case of constantly bad chosen pivots, the problem is not divided by half at each step, it becomes just one element less, that leads to \mathcal{O}(N^2)O(N 
2
 ) time complexity. It happens, for example, if at each step you choose the pivot not randomly, but take the rightmost element. For the random pivot choice the probability of having such a worst-case is negligibly small.

Space complexity: up to \mathcal{O}(N)O(N) to store hash map and array of unique elements.


Further Discussion: Could We Do Worst-Case Linear Time?
In theory, we could, the algorithm is called Median of Medians.

This method is never used in practice because of two drawbacks:

It's outperformer. Yes, it works in a linear time \alpha NαN, but the constant \alphaα is so large that in practice it often works even slower than N^2N 
2
 .

It doesn't work with duplicates.
	 * 
	 * 
	 */
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}

	for (int key : frequencyMap.keySet()) {
		int frequency = frequencyMap.get(key);
		if (bucket[frequency] == null) {
			bucket[frequency] = new ArrayList<>();
		}
		bucket[frequency].add(key);
	}

	List<Integer> res = new ArrayList<>();

	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
		if (bucket[pos] != null) {
			res.addAll(bucket[pos]);
		}
	}
	return res.subList(0,k);
    }
}
