/* over, n, n
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?
 */

package leetcode;

import main_solution.TreeNode;

public class Symmetric_Tree {
	
	/*
	 * 
	 * Approach 1: Recursive
A tree is symmetric if the left subtree is a mirror reflection of the right subtree.

Push an element in stack

Therefore, the question is: when are two trees a mirror reflection of each other?

Two trees are a mirror reflection of each other if:

Their two roots have the same value.
The right subtree of each tree is a mirror reflection of the left subtree of the other tree.
Push an element in stack

This is like a person looking at a mirror. The reflection in the mirror has the same head, but the reflection's right arm corresponds to the actual person's left arm, and vice versa.

The explanation above translates naturally to a recursive function as follows.


Complexity Analysis

Time complexity : O(n)O(n). Because we traverse the entire input tree once, the total run time is O(n)O(n), where nn is the total number of nodes in the tree.

Space complexity : The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in O(n)O(n). Therefore, space complexity due to recursive calls on the stack is O(n)O(n) in the worst case.
	 * 
	 * 
	 */
	
	public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
        && isMirror(t1.right, t2.left)
        && isMirror(t1.left, t2.right);
    }

}
