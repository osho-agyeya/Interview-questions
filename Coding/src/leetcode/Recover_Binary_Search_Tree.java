//completed
/*
You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 

Constraints:

The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1s
 */

package leetcode;

import main_solution.TreeNode;

public class Recover_Binary_Search_Tree {
	
	public void recoverTree(TreeNode root) {
        TreeNode[] candidates = null;
        TreeNode prev = null;
        
        TreeNode p = root; ///Morris Begins///
        while (p != null) {
            if (p.left == null) {
                candidates = checkSeq(prev, p, candidates); //visit p
                prev = p; //visit p
                p = p.right;
            }
            else { // p.left != null
                TreeNode r = p.left;
                while (r.right != null && r.right != p) r = r.right;
                if (r.right == null) { // haven't traversed p's left subtree
                    r.right = p;
                    p = p.left;
                } else { // have traversed all p's left subtree, time to go back to parent
                    candidates = checkSeq(prev, p, candidates); //visit p
                    prev = p; //visit p
                    r.right = null;
                    p = p.right;
                }
                
            }
        } ///Morris Ends///
        
        int t = candidates[0].val;
        candidates[0].val = candidates[1].val;
        candidates[1].val = t;
    }
    
    private TreeNode[] checkSeq(TreeNode prev, TreeNode p, TreeNode[] candidates) {
        if (prev == null) return candidates;
        if (prev.val > p.val) {
            if (candidates == null) //first occur
                candidates = new TreeNode[]{prev, p};
            else
                candidates[1] = p; //second occur, update new candidate No.2
        }
        return candidates;
    }

}
