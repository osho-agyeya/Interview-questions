//done
/*
 * 
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 */
package leetcode;

import java.util.PriorityQueue;

public class Kth_Smallest_Element_in_a_Sorted_Matrix {
	
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

