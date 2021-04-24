//completed
/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */

package leetcode;

import main_solution.ListNode;

public class Remove_Nth_Node_From_End_of_List {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
dummy.next = head;
int length  = 0;
ListNode first = head;
while (first != null) {
    length++;
    first = first.next;
}
length -= n;
first = dummy;
while (length > 0) {
    length--;
    first = first.next;
}
first.next = first.next.next;
return dummy.next;
    
}

}
