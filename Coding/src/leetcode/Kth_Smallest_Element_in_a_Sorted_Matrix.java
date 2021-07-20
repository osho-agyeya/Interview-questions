/* over, x+(k ln x), x where x= minimum value
 * 
Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length
n == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 * 
 */
package leetcode;

import java.util.PriorityQueue;

public class Kth_Smallest_Element_in_a_Sorted_Matrix {
	
	/*
	 * 
	 * Solution
Approach 1: Min-Heap approach
Intuition

The intuition for this approach is really simple. If you think about it, we can reframe the problem as finding the K^{\text{th}}K 
th
  smallest elements from amongst N sorted lists right? We know that the rows are sorted and so are the columns. So, we can treat each row (or column) as a sorted list in itself. Then, the problem just boils down to finding the K^{\text{th}}K 
th
  smallest element from amongst these N sorted lists. However, before we get to this problem, lets first talk about a simpler version of the problem which is to find the K^{\text{th}}K 
th
  smallest element from amongst 2 sorted lists. This is easy enough to solve since all we need are a pair of pointers which act as indices in the two lists.

At each step we check which element is smaller amongst the two being pointed at by the indices and progress the corresponding index accordingly. If you think about it, we just need to run the algorithm for merging two sorted lists without actually merging them. We need to keep on running this algorithm until we find our K^{\text{th}}K 
th
  element. Let's quickly look at how this would look like diagrammatically.


We can use this two-pointer approach for finding the K^{\text{th}}K 
th
  element. As explained above, at each step we check the two values and move the pointer corresponding to the smaller value forward.


Now that was simple enough to do. In this particular problem, we have NN sorted lists instead of just 2. That's what adds to the complexity. We can't really keep NN different pointers now, can we? The heap data structure is perfect for this problem since at all times, we want to maintain N different variables with each of them pointing to an element in their corresponding lists. We want to be able to find the minimum amongst these NN pointers quickly and then replace that element with the next one in its corresponding list.

The heap data structure gives us O(1)O(1) access to the minimum element and log(N)log(N) removal of the minimum element and addition of a new one. We just need to perform this operation K times to get our K^{\text{th}}K 
th
  smallest number. It's possible that our matrix has say 100 rows whereas we just need to find out the 5th smallest element. In this case, we can safely discard the rows in the lower part of the matrix i.e. in this case starting from the 6th row to the end of the matrix because the columns are sorted as well. So, we need the min(N, K)min(N,K) rows essentially to find out the answer.

Algorithm

Initialize a min-heap called H.

For our implementation, we will be considering each row an individual list. Since the columns are sorted as well, we can easily treat each column as an individual list as well.

As mentioned before, we will take the first element of min(N, K)min(N,K) rows where NN represents the number of rows, and add each of these elements to the heap. It's important to know what row and column an element belongs to. Without knowing that, we won't be able to move forward in that particular list. So, apart from adding an element to the heap, we also need to add its row and column number. Hence, our min-heap will contain a triplet of information (value, row, column). The heap will be arranged on the basis of the values and we will use the row and column number to add a replacement for the next element in case it gets popped off the heap.


At this point, our heap contains min(N, K)min(N,K) elements. Now we start a loop that goes until we iterate over K elements.

At each step, we remove the minimum element from the heap. The element will tell us which row should be further consumed. Using the row and column information we will add the next element to the heap. Specifically, if the current minimum element was from row r and had a column position c, then the next element to be added to the heap will be (r, c+1).

Extract-Min


Add a new element


Keep on iterating till we exhaust K elements. The last element to be popped at the end of the loop will be the K^{\text{th}}K 
th
  smallest element.


Complexity Analysis

Time Complexity: \text{let X=} \text{min}(K, N); X + K \log(X)let X=min(K,N);X+Klog(X)

Well the heap construction takes O(X)O(X) time.
After that, we perform KK iterations and each iteration has two operations. We extract the minimum element from a heap containing XX elements. Then we add a new element to this heap. Both the operations will take O(\log(X))O(log(X)) time.
Thus, the total time complexity for this algorithm comes down to be O(X + K\log(X))O(X+Klog(X)) where XX is \text{min}(K, N)min(K,N).
Space Complexity: O(X)O(X) which is occupied by the heap.


Approach 2: Binary Search
Inuition

Since each row and column of the matrix is sorted, is it possible to use Binary Search to find the K^{\text{th}}K 
th
  smallest number? The biggest problem to use Binary Search in this case is that we don’t have a straightforward sorted array, instead we have a matrix. As we remember, in Binary Search, we calculate the middle index of the search space (1 to N) and see if our required number is pointed out by the middle index; if not we either search in the lower half or the upper half. In a sorted matrix, we can't really find a middle. Even if we do consider some index as middle, it is not straightforward to find the search space containing numbers bigger or smaller than the number pointed out by the middle index.

An alternate could be to apply the Binary Search on the number range instead of the index range. As we know that the smallest number of our matrix is at the top left corner and the biggest number is at the bottom lower corner. These two number can represent the range i.e., the start and the end for the Binary Search. This does sound a bit counter-intuitive now, however, it will start to make sense soon. We are all accustomed to the linear array binary search algorithm. So, to delve into this idea a bit deeper, let's represent the number range on a single line as a one-dimensional array and see why and how binary search makes sense.


Now, let's proceed with the first step that we take in any binary search implementation. We find the middle element, right? In a normal, one-dimensional binary search, we use the indices to find the middle element. In this case, the left and the right ends of our sorted matrix are the two values. So, we use them to find the hypothetical middle of the matrix. The reason we call this hypothetical is because it is not necessary that the middle value will exist in the matrix. However, that is not a requirement for our algorithm.


Even though this is a stupid question, it will help us to understand the overall logic here: How will you find out the K^{\text{th}}K 
th
  smallest number in a sorted one-dimensional array? It's simple, right? You'll just return the K^{\text{th}}K 
th
  element in the array. This is because you know the index KK in the array contains your answer. In our example, we know the two extremes and the middle element value. However, what we don't know are the sizes of the two halves. For all we know, we could have 8 elements in the left half and just 2 on the right in the example above. We don't know!

So, after finding the middle element, we need to determine the size of the left half. Why, you might ask? Well because we want the Kth smallest element and not the largest. If the question asked us for the largest, we would be determining the size of the right half.

We already have a problem on LeetCode that is about searching for an element in a sorted 2D matrix. However, we don't want to search for our middle element. We want to count the number of elements in the left half of the number range of which we know the middle element and the two extremes as well. As it turns out, this can be done in O(N + N) = O(N)O(N+N)=O(N) time where NN represents the number of rows and columns. We will make use of the sorted nature of the matrix and count all the elements we need without actually iterating over them.

For example, if an element in the cell [i, j] is smaller than our middle element, then it means that all the elements in the column "j" before this element i.r. (i-1) other elements in this column are also going to be less than the middle element. Why? Because the columns are sorted as well!




What do we do with this newfound information of ours? Well, that depends on the value of K. So, let's consider our 3 different cases here.

Case 1: The size of the left half is EQUAL to K


Case 2: The size of the left half is LESS than K


Case 3: The size of the left half is MORE than K


So, as we can see from the above figures, when we are trying to determine the size of our left-half, we also need to keep track of two values. The largest element less-than-or-equal-to the middle element and the smallest element greater than the middle. For an index-based binary search, this wouldn't be a problem since middle+1 and middle-1 would represent these entries :).

Algorithm

Start the binary search with start = matrix[0][0] and end = matrix[N-1][N-1]
Find the middle of the start and the end. This middle number is NOT necessarily an element in the matrix.
Count all the numbers smaller than or equal to middle in the matrix. As the matrix is sorted, we can do this in O(N)O(N). Note that this is determining the size of the left-half of the array.
While counting, we need to keep track of the smallest number greater than the middle (let’s call it R) and at the same time the biggest number less than or equal to the middle (let’s call it L). These two numbers will be used to adjust the number range for the binary search in the next iteration.
If the count is equal to K, L will be our required number as it is the biggest number less than or equal to the middle, and is definitely present in the matrix.
If the count is less than K, we can update start = R to search in the higher part of the matrix
If the count is greater than K, we can update end = L to search in the lower part of the matrix in the next iteration.

Complexity Analysis

Time Complexity: O(N \times log(\text{Max}-\text{Min}))O(N×log(Max−Min))

Let's think about the time complexity in terms of the normal binary search algorithm. For a one-dimensional binary search over an array with NN elements, the complexity comes out to be O(log(N))O(log(N)).
For our scenario, we are kind of defining our binary search space in terms of the minimum and the maximum numbers in the array. Going by this idea, the complexity for our binary search should be O(log(\text{Max}-\text{Min}))O(log(Max−Min)) where \text{Max}Max is the maximum element in the array and likewise, \text{Min}Min is the minimum element.
However, we update our search space after each iteration. So, even if the maximum element is super large as compared to the remaining elements in the matrix, we will bring down the search space considerably in the next iterations. But, going purely by the extremes for our search space, the complexity of our binary search in search of K^{\text{th}}K 
th
  smallest element will be O(log(\text{Max}-\text{Min}))O(log(Max−Min)).
In each iteration of our binary search approach, we iterate over the matrix trying to determine the size of the left-half as explained before. That takes O(N)O(N).
Thus, the overall time complexity is O(N \times log(\text{Max}-\text{Min}))O(N×log(Max−Min))
Space Complexity: O(1)O(1) since we don't use any additional space for performing our binary search.
	 * 
	 */
	
	class Node {
		  int row;
		  int col;

		  Node(int row, int col) {
		    this.row = row;
		    this.col = col;
		  }
		}


		  public int kthSmallest(int[][] matrix, int k) {
		    PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

		    // put the 1st element of each row in the min heap we don't need to push more than 'k' elements in the heap
		    for (int i = 0; i < matrix.length && i < k; i++)
		      minHeap.add(new Node(i, 0));

		    // take the smallest (top) element form the min heap, if the running count is equal to k return the number
		    // if the row of the top element has more elements, add the next element to the heap
		    int numberCount = 0, result = 0;
		    while (!minHeap.isEmpty()) {
		      Node node = minHeap.poll();
		      result = matrix[node.row][node.col];
		      if (++numberCount == k)
		        break;
		      node.col++;
		      if (matrix[0].length > node.col)
		        minHeap.add(node);
		    }
		    return result;
		  }
		}

