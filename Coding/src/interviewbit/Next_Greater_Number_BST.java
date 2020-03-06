//done
/*
 * Given a BST node, return the node which has value just greater than the given node.

Example:

Given the tree

               100
              /   \
            98    102
           /  \
         96    99
          \
           97
Given 97, you should return the node corresponding to 98 as thats the value just greater than 97 in the tree.
If there are no successor in the tree ( the value is the largest in the tree, return NULL).

Using recursion is not allowed.

Assume that the value is always present in the tree.
 */

package interviewbit;

import main_solution.TreeNode;

public class Next_Greater_Number_BST {
	
	public TreeNode getSuccessor(TreeNode root, int data) {
	    if( root == null ) return null;
	    TreeNode temp = null ;
	    while( root != null ){
	        if( root.val > data )
	        {
	            temp = root;
	            root = root.left;
	        }
	        else 
	        root = root.right;
	    }
	    return temp;
	}

}
