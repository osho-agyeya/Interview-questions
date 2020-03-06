//done

/*
 * 
 * Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 * 
 */

package leetcode;

import main_solution.TreeNode;

public class Flatten_Binary_Tree_to_Linked_List {
	
	public void flatten(TreeNode root) {
	    TreeNode node = root;
	    while (node != null) {
	        TreeNode left = node.left;
	        TreeNode right = node.right;
	        if (left != null) {
	            TreeNode temp = left;
	            while (temp.right != null)
	                temp = temp.right;
	            temp.right = right;
	            node.right = left;
	            node.left = null;
	        }
	        node = node.right;
	    }
	}
	
	

}
