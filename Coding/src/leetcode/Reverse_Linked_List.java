//doe
/*
 * Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?


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
