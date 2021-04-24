//completed
/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

 */

package leetcode;

import main_solution.ListNode;

public class Reverse_Linked_List {
	public ListNode reverseList(ListNode head) {
        return putPreAfterNode(head, null);
    }
    
    private ListNode putPreAfterNode(ListNode node, ListNode pre) {
        if (node == null) {
            return pre;
        }
        ListNode next = node.next;
        node.next = pre;
        return putPreAfterNode(next, node);
    }
}
