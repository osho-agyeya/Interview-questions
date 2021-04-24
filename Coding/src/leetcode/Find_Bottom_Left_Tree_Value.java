
/*completed
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 * 
 * 
 */

package leetcode;

public class Find_Bottom_Left_Tree_Value {

	public int findLeftMostNode(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        root = queue.poll();
	        if (root.right != null)
	            queue.add(root.right);
	        if (root.left != null)
	            queue.add(root.left);
	    }
	    return root.val;
	}
	
}
