//completed
/*
 * 
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

The successor of a node p is the node with the smallest key greater than p.val. You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node. A node is defined as the following:
 * 
 */
package leetcodePremium;


public class Inorder_Successor_in_a_BST_II {
	
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node parent;
	};
	
	public Node inorderSuccessor(Node x) {
		  Node result = null;
		 
		  //case 1: right child is not null -> go down to get the next
		  Node p = x.right;
		  while(p!=null){ 
		    result = p;
		    p = p.left;
		  }
		 
		  if(result != null){
		    return result; 
		  }
		 
		  //case 2: right child is null -> go up to the parent, 
		  //until the node is a left child, return the parent
		  p = x;
		 
		  while(p!=null){
		    if(p.parent!=null && p.parent.left==p){
		      return p.parent;
		    } 
		    p = p.parent;
		  }
		 
		  return null;
		}

}
