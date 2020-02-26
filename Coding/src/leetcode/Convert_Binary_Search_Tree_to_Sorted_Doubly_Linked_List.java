//ddoe 
package leetcode;

import main_solution.Node;

public class Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List {

	
	Node prev = null;
	Node head = null;
	 
	public Node treeToDoublyList(Node root) {
	    if (root == null) {
	        return null;
	    }
	 
	    helper(root);
	 
	    head.left = prev;
	    prev.right = head;
	 
	    return head;
	}
	 
	private void helper(Node p) {
	    if (p == null) {
	        return;
	    }
	 
	    helper(p.left);
	 
	    //handle current
	    if (prev == null) {
	        head = p;
	    } else {
	        prev.right = p;
	        p.left = prev;
	    }
	 
	    prev = p;
	 
	    helper(p.right);
	}
	
}
