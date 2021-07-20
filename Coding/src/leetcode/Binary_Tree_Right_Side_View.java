/* over, n, d
 * 
 * 
 * 
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
package leetcode;
import java.util.*;

import main_solution.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Binary_Tree_Right_Side_View {
	
	/*
	 * Approach 3: BFS: One Queue + Level Size Measurements
Instead of using the sentinel, we could write down the length of the current level.

diff

Algorithm

Initiate the list of the right side view rightside.

Initiate the queue by adding a root.

While the queue is not empty:

Write down the length of the current level: levelLength = queue.size().

Iterate over i from 0 to level_length - 1:

Pop the current node from the queue: node = queue.poll().

If i == levelLength - 1, then it's the last node in the current level, push it to rightsize list.

Add first left and then right child node into the queue.

Return rightside.
	 * 
	 */
	
	 public List<Integer> rightSideView(TreeNode root) {
	        if (root == null) return new ArrayList<Integer>();
	        
	        ArrayDeque<TreeNode> queue = new ArrayDeque(){{ offer(root); }};
	        List<Integer> rightside = new ArrayList();
	        
	        while (!queue.isEmpty()) {
	            int levelLength = queue.size();

	            for(int i = 0; i < levelLength; ++i) {
	                TreeNode node = queue.poll();
	                // if it's the rightmost element
	                if (i == levelLength - 1) {
	                    rightside.add(node.val);    
	                }

	                // add child nodes in the queue
	                if (node.left != null) {
	                    queue.offer(node.left);    
	                }
	                if (node.right != null) {
	                    queue.offer(node.right);
	                }
	            }
	        }
	        return rightside;
	    }
}
