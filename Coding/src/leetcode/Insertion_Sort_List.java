//ddoe

/*
 * 
 * Sort a linked list using insertion sort.


A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 * 
 * 
 */

package leetcode;

import main_solution.ListNode;

public class Insertion_Sort_List {
	
	public ListNode insertionSortList(ListNode ptr) {    
        if (ptr == null || ptr.next == null)
            return ptr;
        
        ListNode preInsert, toInsert, dummyHead = new ListNode(0);
        dummyHead.next = ptr;

        while (ptr != null && ptr.next != null) {
            if (ptr.val <= ptr.next.val) {
                ptr = ptr.next;
            } else {      
                toInsert = ptr.next;
                // Locate preInsert.
                preInsert = dummyHead;
                while (preInsert.next.val < toInsert.val) {
                    preInsert = preInsert.next;
                }
                ptr.next = toInsert.next;
                // Insert toInsert after preInsert.
                toInsert.next = preInsert.next;
                preInsert.next = toInsert;
            }
        }
        return dummyHead.next;

}
}
