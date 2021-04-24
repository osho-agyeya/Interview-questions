//completed

/*
 * T=O(N)
 * S=O(N)
 * 
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
 * 
 */

package leetcode;

import java.util.HashMap;

import main_solution.TreeNode;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

	
	public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
		HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
		for (int i=0;i<inorder.length;++i)
			hm.put(inorder[i], i);
		return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
	                          postorder.length-1,hm);
	}

	private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, 
	                                 HashMap<Integer,Integer> hm){
		if (ps>pe || is>ie) return null;
		TreeNode root = new TreeNode(postorder[pe]);
		int ri = hm.get(postorder[pe]);
		TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
		TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
		root.left = leftchild;
		root.right = rightchild;
		return root;
	}
	
}
