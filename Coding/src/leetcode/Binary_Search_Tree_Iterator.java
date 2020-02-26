//ddone
//t=
//s=O(N)


/*
 * 
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

 

Example:



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
 

Note:

next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 * 
 * 
 */
package leetcode;

import java.util.Stack;

import main_solution.TreeNode;

public class Binary_Search_Tree_Iterator {
	
	Stack<TreeNode> stack =  null ;            
    TreeNode current = null ;
	
    public Binary_Search_Tree_Iterator(TreeNode root) {
    	  current = root;	     
    	  stack = new Stack<> ();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {		  
	      return !stack.isEmpty() || current != null;  
	}

	    /** @return the next smallest number */
	public int next() {
		while (current != null) {
			stack.push(current);
			current = current.left ;
		}		
		TreeNode t = stack.pop() ;		
		current = t.right ;		
		return t.val ;
	}
	
}
