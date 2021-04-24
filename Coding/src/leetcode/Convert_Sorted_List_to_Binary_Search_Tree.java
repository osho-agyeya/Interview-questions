//completed

/*T=O(N)
 * 
 * 
 * 
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 

Example 1:


Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [0]
Output: [0]
Example 4:

Input: head = [1,3]
Output: [3,1]
 

Constraints:

The number of nodes in head is in the range [0, 2 * 104].
-10^5 <= Node.val <= 10^5
 */

package leetcode;

import main_solution.ListNode;
import main_solution.TreeNode;

public class Convert_Sorted_List_to_Binary_Search_Tree {


 
	public TreeNode sortedListToBST(ListNode head) {
	    if(head==null) return null;
	    return toBST(head,null);
	}
	public TreeNode toBST(ListNode head, ListNode tail){
	    ListNode slow = head;
	    ListNode fast = head;
	    if(head==tail) return null;
	    
	    while(fast!=tail&&fast.next!=tail){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    TreeNode thead = new TreeNode(slow.val);
	    thead.left = toBST(head,slow);
	    thead.right = toBST(slow.next,tail);
	    return thead;
	}
	
}
