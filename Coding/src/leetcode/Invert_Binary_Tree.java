/* over, n, n
 * 
Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100 
 */
package leetcode;

import main_solution.TreeNode;

public class Invert_Binary_Tree {
	
	/*
	 * Approach #1 (Recursive) [Accepted]
This is a classic tree problem that is best-suited for a recursive approach.

Algorithm

The inverse of an empty tree is the empty tree. The inverse of a tree with root rr, and subtrees \mbox{right} and \mbox{left}, is a tree with root rr, whose right subtree is the inverse of \mbox{left}, and whose left subtree is the inverse of \mbox{right}.

Java

public TreeNode invertTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    TreeNode right = invertTree(root.right);
    TreeNode left = invertTree(root.left);
    root.left = right;
    root.right = left;
    return root;
}
Complexity Analysis

Since each node in the tree is visited only once, the time complexity is O(n)O(n), where nn is the number of nodes in the tree. We cannot do better than that, since at the very least we have to visit each node to invert it.

Because of recursion, O(h)O(h) function calls will be placed on the stack in the worst case, where hh is the height of the tree. Because h\in O(n)h∈O(n), the space complexity is O(n)O(n).
	 */
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        
        return root;
    }

}
