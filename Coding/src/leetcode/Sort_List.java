/* over, nln n, ln n
 * Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 */

package leetcode;

import main_solution.ListNode;

public class Sort_List {
	
	/*
	 * 
	 * Overview
The problem is to sort the linked list in \mathcal{O}(n \log n)O(nlogn) time and using only constant extra space. If we look at various sorting algorithms, Merge Sort is one of the efficient sorting algorithms that is popularly used for sorting the linked list. The merge sort algorithm runs in \mathcal{O}(n \log n)O(nlogn) time in all the cases. Let's discuss approaches to sort linked list using merge sort.

Quicksort is also one of the efficient algorithms with the average time complexity of \mathcal{O}(n \log n)O(nlogn). But the worst-case time complexity is \mathcal{O}(n ^{2})O(n 
2
 ). Also, variations of the quick sort like randomized quicksort are not efficient for the linked list because unlike arrays, random access in the linked list is not possible in \mathcal{O}(1)O(1) time. If we sort the linked list using quicksort, we would end up using the head as a pivot element which may not be efficient in all scenarios.

Approach 1: Top Down Merge Sort
Intuition

Merge sort is a popularly known algorithm that follows the Divide and Conquer Strategy. The divide and conquer strategy can be split into 2 phases:

Divide phase: Divide the problem into subproblems.

Conquer phase: Repeatedly solve each subproblem independently and combine the result to form the original problem.

The Top Down approach for merge sort recursively splits the original list into sublists of equal sizes, sorts each sublist independently, and eventually merge the sorted lists. Let's look at the algorithm to implement merge sort in Top Down Fashion.

Algorithm

Recursively split the original list into two halves. The split continues until there is only one node in the linked list (Divide phase). To split the list into two halves, we find the middle of the linked list using the Fast and Slow pointer approach as mentioned in Find Middle Of Linked List.

Recursively sort each sublist and combine it into a single sorted list. (Merge Phase). This is similar to the problem Merge two sorted linked lists

The process continues until we get the original list in sorted order.

For the linked list = [10,1,60,30,5], the following figure illustrates the merge sort process using a top down approach.

img

If we have sorted lists, list1 = [1,10] and list2 = [5,30,60]. The following animation illustrates the merge process of both lists into a single sorted list.

Current
1 / 9

Complexity Analysis

Time Complexity: \mathcal{O}(n \log n)O(nlogn), where nn is the number of nodes in linked list. The algorithm can be split into 2 phases, Split and Merge.
Let's assume that nn is power of 22. For n = 16, the split and merge operation in Top Down fashion can be visualized as follows

img

Split

The recursion tree expands in form of a complete binary tree, splitting the list into two halves recursively. The number of levels in a complete binary tree is given by \log_{2} nlog 
2
​
 n. For n=16n=16, number of splits = \log_{2} 16 = 4log 
2
​
 16=4

Merge

At each level, we merge n nodes which takes \mathcal{O}(n)O(n) time. For n = 16n=16, we perform merge operation on 1616 nodes in each of the 44 levels.

So the time complexity for split and merge operation is \mathcal{O}(n \log n)O(nlogn)

Space Complexity: \mathcal{O}(\log n)O(logn) , where nn is the number of nodes in linked list. Since the problem is recursive, we need additional space to store the recursive call stack. The maximum depth of the recursion tree is \log nlogn
	 * 
	 */
	
	public ListNode sortList(ListNode head) {
	    if (head == null || head.next == null)
	      return head;
	        
	    // step 1. cut the list to two halves
	    ListNode prev = null, slow = head, fast = head;
	    
	    while (fast != null && fast.next != null) {
	      prev = slow;
	      slow = slow.next;
	      fast = fast.next.next;
	    }
	    
	    prev.next = null;
	    
	    // step 2. sort each half
	    ListNode l1 = sortList(head);
	    ListNode l2 = sortList(slow);
	    
	    // step 3. merge l1 and l2
	    return merge(l1, l2);
	  }
	  
	  ListNode merge(ListNode l1, ListNode l2) {
	    ListNode l = new ListNode(0), p = l;
	    
	    while (l1 != null && l2 != null) {
	      if (l1.val < l2.val) {
	        p.next = l1;
	        l1 = l1.next;
	      } else {
	        p.next = l2;
	        l2 = l2.next;
	      }
	      p = p.next;
	    }
	    
	    if (l1 != null)
	      p.next = l1;
	    
	    if (l2 != null)
	      p.next = l2;
	    
	    return l.next;
	  }

}
