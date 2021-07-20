/* over, n, n
 * 
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 * 
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main_solution.TreeNode;

public class Binary_Tree_Level_Order_Traversal {
	
	/*
	 * 
	 * Approach 2: Iteration
Algorithm

The recursion above could be rewritten in the iteration form.

Let's keep nodes of each tree level in the queue structure, which typically orders elements in a FIFO (first-in-first-out) manner. In Java one could use LinkedList implementation of the Queue interface. In Python using Queue structure would be an overkill since it's designed for a safe exchange between multiple threads and hence requires locking which leads to a performance loose. In Python the queue implementation with a fast atomic append() and popleft() is deque.

The zero level contains only one node root. The algorithm is simple :

Initiate queue with a root and start from the level number 0 : level = 0.

While queue is not empty :

Start the current level by adding an empty list into output structure levels.

Compute how many elements should be on the current level : it's a queue length.

Pop out all these elements from the queue and add them into the current level.

Push their child nodes into the queue for the next level.

Go to the next level level++.

Implementation


Complexity Analysis

Time complexity : \mathcal{O}(N)O(N) since each node is processed exactly once.

Space complexity : \mathcal{O}(N)O(N) to keep the output structure which contains N node values.
	 * 
	 * 
	 */
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return ans;
        queue.add(root);
        list.add(root.val);
        ans.add(list);
        while(queue.size()>0){
            list = new ArrayList<Integer>();
            int s = queue.size();
            for(int i = 0; i<s; i++){
                TreeNode node = queue.remove();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                if(node.left!=null) list.add(node.left.val);
                if(node.right!=null) list.add(node.right.val);
            }
            if(list.size()>0) ans.add(list);
        }
       return ans; 
    }

}
