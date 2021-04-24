//completed
/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106
 

Follow up: Could you solve it in O(1) space complexity and O(nodes) time complexity? 
 * 
 */

package leetcode;

import main_solution.ListNode;

public class Odd_Even_Linked_List {
	
	public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
    ListNode odd=head,ehead=head.next,even=ehead;
    while(even!=null&&even.next!=null){
        odd.next=even.next;
        odd=odd.next;
        even.next=odd.next;
        even=even.next;
    }
    odd.next=ehead;
    return head;
    }   

}
