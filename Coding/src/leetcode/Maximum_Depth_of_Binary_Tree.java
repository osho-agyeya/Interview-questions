/* over, n, n
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
Example 3:

Input: root = []
Output: 0
Example 4:

Input: root = [0]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100 
 */

package leetcode;

import main_solution.*;

public class Maximum_Depth_of_Binary_Tree {
	
	/*
	 * 
	 * Approach 1: Recursion
Intuition By definition, the maximum depth of a binary tree is the maximum number of steps to reach a leaf node from the root node.

From the definition, an intuitive idea would be to traverse the tree and record the maximum depth during the traversal.

Algorithm

Current
1 / 10
One could traverse the tree either by Depth-First Search (DFS) strategy or Breadth-First Search (BFS) strategy. For this problem, either way would do. Here we demonstrate a solution that is implemented with the DFS strategy and recursion.


Complexity analysis

Time complexity : we visit each node exactly once, thus the time complexity is \mathcal{O}(N)O(N), where NN is the number of nodes.

Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only left child node, the recursion call would occur NN times (the height of the tree), therefore the storage to keep the call stack would be \mathcal{O}(N)O(N). But in the best case (the tree is completely balanced), the height of the tree would be \log(N)log(N). Therefore, the space complexity in this case would be \mathcal{O}(\log(N))O(log(N)).
	 * 
	 * 
	 */
	
	public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

}
